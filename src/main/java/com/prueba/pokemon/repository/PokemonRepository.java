package com.prueba.pokemon.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import com.prueba.pokemon.domain.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {}
