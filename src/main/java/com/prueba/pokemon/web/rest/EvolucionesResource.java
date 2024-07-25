package com.prueba.pokemon.web.rest;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.prueba.pokemon.dto.EvolucionesDTO;
import com.prueba.pokemon.repository.EvolucionesRepository;
import com.prueba.pokemon.service.EvolucionesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/evoluciones")
public class EvolucionesResource {

    private static final Logger log = LoggerFactory.getLogger(EvolucionesResource.class);

    private static final String ENTITY_NAME = "evoluciones";

    private final EvolucionesService evolucionesService;

    private final EvolucionesRepository evolucionesRepository;

    public EvolucionesResource(EvolucionesService evolucionesService, EvolucionesRepository evolucionesRepository) {
        this.evolucionesService = evolucionesService;
        this.evolucionesRepository = evolucionesRepository;
    }

    @PostMapping("")
    public ResponseEntity<EvolucionesDTO> createEvoluciones(@RequestBody EvolucionesDTO evolucionesDTO) throws URISyntaxException {
        return null;
    }

}
