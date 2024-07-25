package com.prueba.pokemon.service.mapper;

import com.prueba.pokemon.domain.Habilidades;
import com.prueba.pokemon.domain.Pokemon;
import com.prueba.pokemon.dto.HabilidadesDTO;
import com.prueba.pokemon.dto.PokemonDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface HabilidadesMapper extends EntityMapper<HabilidadesDTO, Habilidades> {
    @Mapping(target = "pokemon", source = "pokemon", qualifiedByName = "pokemonId")
    HabilidadesDTO toDto(Habilidades s);

    @Named("pokemonId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    PokemonDTO toDtoPokemonId(Pokemon pokemon);

    Habilidades toEntity(HabilidadesDTO habilidadesDTO);
}
