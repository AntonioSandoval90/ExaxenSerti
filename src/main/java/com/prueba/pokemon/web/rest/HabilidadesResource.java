package com.prueba.pokemon.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.prueba.pokemon.dto.HabilidadesDTO;
import com.prueba.pokemon.repository.HabilidadesRepository;
import com.prueba.pokemon.service.HabilidadesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/habilidades")
public class HabilidadesResource {

    private static final Logger log = LoggerFactory.getLogger(HabilidadesResource.class);

    private static final String ENTITY_NAME = "habilidades";

    private final HabilidadesService habilidadesService;

    private final HabilidadesRepository habilidadesRepository;

    public HabilidadesResource(HabilidadesService habilidadesService, HabilidadesRepository habilidadesRepository) {
        this.habilidadesService = habilidadesService;
        this.habilidadesRepository = habilidadesRepository;
    }

    @PostMapping("")
    public ResponseEntity<HabilidadesDTO> createHabilidades(@RequestBody HabilidadesDTO habilidadesDTO) throws URISyntaxException {
       return null;
    }
}
