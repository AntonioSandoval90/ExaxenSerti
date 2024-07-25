package com.prueba.pokemon.repository;

import com.prueba.pokemon.domain.Evoluciones;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


@Repository
public interface EvolucionesRepository extends JpaRepository<Evoluciones, Integer> {}
