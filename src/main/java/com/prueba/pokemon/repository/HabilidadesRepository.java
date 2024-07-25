package com.prueba.pokemon.repository;

import com.prueba.pokemon.domain.Habilidades;
import com.prueba.pokemon.domain.Pokemon;
import com.prueba.pokemon.dto.PokemonDTO;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HabilidadesRepository extends JpaRepository<Habilidades, Integer> {

    List<Habilidades> findByPokemon(Pokemon pokemon);

}
