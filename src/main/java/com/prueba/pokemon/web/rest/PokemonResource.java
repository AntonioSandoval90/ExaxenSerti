package com.prueba.pokemon.web.rest;

import com.prueba.pokemon.dto.InformacionPokemonDTO;
import com.prueba.pokemon.service.PokemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public InformacionPokemonDTO getPrueba(@PathVariable int id) {

        log.debug("REST request to get Informacion de Pokemon con ID: {} ", id);
        return pokemonService.obtenerInformacionPokemon(id);
    }
}
