package com.prueba.pokemon.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import com.prueba.pokemon.domain.Pokemon;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

    List<Pokemon> findByNombre(String nombre);
}
