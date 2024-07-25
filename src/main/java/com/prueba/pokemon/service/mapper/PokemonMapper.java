package com.prueba.pokemon.service.mapper;

import com.prueba.pokemon.domain.Pokemon;
import com.prueba.pokemon.dto.PokemonDTO;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface PokemonMapper extends EntityMapper<PokemonDTO, Pokemon> {


    public static PokemonDTO toDTO(Pokemon pokemon) {
        PokemonDTO pokemonDTO = new PokemonDTO();
        pokemonDTO.setId(pokemon.getId());
        pokemonDTO.setNombre(pokemon.getNombre());
        return pokemonDTO;
    }

}
