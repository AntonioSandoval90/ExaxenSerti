package com.prueba.pokemon.service.mapper;

import com.prueba.pokemon.domain.Evoluciones;
import com.prueba.pokemon.domain.Pokemon;
import com.prueba.pokemon.dto.EvolucionesDTO;
import com.prueba.pokemon.dto.PokemonDTO;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface EvolucionesMapper extends EntityMapper<EvolucionesDTO, Evoluciones> {
    @Mapping(target = "pokemon", source = "pokemon", qualifiedByName = "pokemonId")
    EvolucionesDTO toDto(Evoluciones s);

    @Named("pokemonId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    PokemonDTO toDtoPokemonId(Pokemon pokemon);
}
