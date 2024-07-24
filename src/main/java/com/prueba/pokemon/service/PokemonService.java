package com.prueba.pokemon.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.pokemon.dto.EvolutionChainDTO;
import com.prueba.pokemon.dto.PokemonDTO;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import com.prueba.pokemon.dto.ChainDTO;

@Service
public class PokemonService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${external.api.url}")
    private String externalApiUrl;

    @Autowired
    public PokemonService(){
    }

    private static final Logger log = LoggerFactory.getLogger(PokemonService.class);

    public PokemonDTO getInfPokemon(int id){

        PokemonDTO response = restTemplate.getForObject(externalApiUrl + "/pokemon/"+id, PokemonDTO.class);
        return response;
    }

    public List<String> getEvolutionChain(int pokemonId) throws BadRequestException {
        String evolutionChainResponse;

        evolutionChainResponse = restTemplate.getForObject(externalApiUrl + "evolution-chain/"+pokemonId, String.class);

        EvolutionChainDTO evolutionChain = parseEvolutionChain(evolutionChainResponse);

        List<String> pokemonNames = new ArrayList<>();
        if(evolutionChain == null){
            return pokemonNames;
        }
        extractPokemonNames(evolutionChain.getChain(), pokemonNames);
        return pokemonNames;
    }

    private EvolutionChainDTO parseEvolutionChain(String evolutionChainResponse) {
        try {
            return objectMapper.readValue(evolutionChainResponse, EvolutionChainDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void extractPokemonNames(ChainDTO chain, List<String> pokemonNames) {
        if (chain != null) {
            pokemonNames.add(chain.getSpecies().getName());
            for (ChainDTO evolvesTo : chain.getEvolvesTo()) {
                extractPokemonNames(evolvesTo, pokemonNames);
            }
        }
    }
}
