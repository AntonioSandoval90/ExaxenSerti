package com.prueba.pokemon.web.rest;

import com.prueba.pokemon.dto.PokemonDTO;
import com.prueba.pokemon.service.PokemonService;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/examen")
public class PokemonResource {

    private static final Logger log = LoggerFactory.getLogger(PokemonResource.class);


    @Autowired
    PokemonService pokemonService;

    @Autowired
    public PokemonResource() {
    }

    @GetMapping("/pokemon/{id}")
    public List<String> getPrueba(@PathVariable int id) throws BadRequestException {

        List<String> pokemonChainList = pokemonService.getEvolutionChain(id);
        log.debug("REST request to get all User for an admin: {} ", pokemonChainList);
        return pokemonChainList;
    }
}
