package com.prueba.pokemon.repository;

import com.prueba.pokemon.domain.Habilidades;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


@Repository
public interface HabilidadesRepository extends JpaRepository<Habilidades, Integer> {}
