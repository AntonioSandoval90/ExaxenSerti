package com.prueba.pokemon;

import com.prueba.pokemon.domain.Habilidades;
import com.prueba.pokemon.dto.PokemonDTO;
import com.prueba.pokemon.repository.HabilidadesRepository;
import com.prueba.pokemon.repository.PokemonRepository;
import com.prueba.pokemon.service.HabilidadesService;
import com.prueba.pokemon.service.PokemonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PokemonTest {

    @Autowired
    private PokemonService pokemonService;

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private HabilidadesService habilidadesService;

    @Autowired
    private HabilidadesRepository habilidadesRepository;

    @Test
    void testgetPokemonByNombre() {
        List<PokemonDTO> pokemonList = pokemonService.findByName("pidgey");
        assertNotNull(pokemonList);
        assertEquals("pidgey", pokemonList.get(0).getNombre());
    }

    @Test
    void testgetPokemonByAbilidad() {
        List<PokemonDTO> pokemonList = pokemonService.findByName("pidgey");
        assertNotNull(pokemonList);
        assertEquals("pidgey", pokemonList.get(0).getNombre());

        List<Habilidades> habilidadesList = habilidadesService.findHabilidadByPokemon(pokemonList.get(0));
        assertNotNull(habilidadesList);
        assertFalse(habilidadesList.isEmpty());
    }
}
