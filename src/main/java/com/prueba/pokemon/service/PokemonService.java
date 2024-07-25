package com.prueba.pokemon.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.pokemon.domain.Pokemon;
import com.prueba.pokemon.dto.*;
import com.prueba.pokemon.repository.PokemonRepository;
import com.prueba.pokemon.service.mapper.PokemonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${external.api.url}")
    private String externalApiUrl;

    @Autowired
    private PokemonMapper pokemonMapper;

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private HabilidadesService habilidadesService;

    @Autowired
    private EvolucionesService evolucionesService;

    @Autowired
    public PokemonService(){
    }

    private static final Logger log = LoggerFactory.getLogger(PokemonService.class);

    public PokemonApiDTO getInfPokemon(String nombrePokemon){

        PokemonApiDTO response = restTemplate.getForObject(externalApiUrl + "/pokemon/"+nombrePokemon, PokemonApiDTO.class);
        return response;
    }

    public List<String> getCadenaEvolucion(int pokemonId) {
        String evolutionChainResponse;

        evolutionChainResponse = restTemplate.getForObject(externalApiUrl + "evolution-chain/"+pokemonId, String.class);

        EvolutionChainDTO evolutionChain = obtenerChain(evolutionChainResponse);

        List<String> pokemonNames = new ArrayList<>();
        if(evolutionChain == null){
            return pokemonNames;
        }
        obtenerNombresEvolveTo(evolutionChain.getChain(), pokemonNames);
        return pokemonNames;
    }


    private EvolutionChainDTO obtenerChain(String evolutionChainResponse) {
        try {
            return objectMapper.readValue(evolutionChainResponse, EvolutionChainDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void obtenerNombresEvolveTo(ChainDTO chain, List<String> pokemonNames) {
        if (chain != null) {
            pokemonNames.add(chain.getSpecies().getName());
            for (ChainDTO evolvesTo : chain.getEvolvesTo()) {
                obtenerNombresEvolveTo(evolvesTo, pokemonNames);
            }
        }
    }

    public InformacionPokemonDTO obtenerInformacionPokemon(int idPokemon) {

        List<String> cadenaEvolucion = getCadenaEvolucion(idPokemon);
        if (!cadenaEvolucion.isEmpty()) {

            PokemonApiDTO pokemonDTO = getInfPokemon(cadenaEvolucion.get(0));

            guardarInfBaseDatos(pokemonDTO, cadenaEvolucion);

            return new InformacionPokemonDTO(
                    pokemonDTO.getId(),
                    pokemonDTO.getName(),
                    cadenaEvolucion);
        }
        return new InformacionPokemonDTO();
    }

    public void guardarInfBaseDatos(PokemonApiDTO pokemonApiDTO,  List<String> cadenaEvolucion){

        //Guardar Pokemon en Base de datos
        PokemonDTO pokemonDbDTO = new PokemonDTO(pokemonApiDTO.getName());

        PokemonDTO pokemonDTOResp = save(pokemonDbDTO);

        //Guardar Habilidades de Pokemon en Base de datos
        pokemonApiDTO.getAbilities().forEach(
                habilidad -> {
                    HabilidadesDTO habilidadesDTO = habilidadesService.save(
                            new HabilidadesDTO(habilidad.getAbilityName().getName(),
                                    pokemonDTOResp));
                }
        );

        //Guardar Cadena Evolucion de Pokemon en Base de datos
        cadenaEvolucion.forEach(
                evolucion -> {
                    EvolucionesDTO evolucionesDTO = evolucionesService.save(
                            new EvolucionesDTO(evolucion,
                                    pokemonDTOResp));
                }
        );
    }

    public PokemonDTO save(PokemonDTO pokemonDTO) {
        log.debug("Request to save Pokemon : {}", pokemonDTO);
        Pokemon pokemon = pokemonMapper.toEntity(pokemonDTO);
        pokemon = pokemonRepository.save(pokemon);
        return pokemonMapper.toDto(pokemon);
    }
}
