package com.prueba.pokemon.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.prueba.pokemon.domain.Evoluciones;
import com.prueba.pokemon.dto.EvolucionesDTO;
import com.prueba.pokemon.repository.EvolucionesRepository;
import com.prueba.pokemon.service.mapper.EvolucionesMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EvolucionesService {

    private static final Logger log = LoggerFactory.getLogger(EvolucionesService.class);

    private final EvolucionesRepository evolucionesRepository;

    @Autowired
    private EvolucionesMapper evolucionesMapper;

    public EvolucionesService(EvolucionesRepository evolucionesRepository) {
        this.evolucionesRepository = evolucionesRepository;
    }

    public EvolucionesDTO save(EvolucionesDTO evolucionesDTO) {
        log.debug("Request to save Evoluciones : {}", evolucionesDTO);
        Evoluciones evoluciones = evolucionesMapper.toEntity(evolucionesDTO);
        evoluciones = evolucionesRepository.save(evoluciones);
        return evolucionesMapper.toDto(evoluciones);
    }

    public EvolucionesDTO update(EvolucionesDTO evolucionesDTO) {
        log.debug("Request to update Evoluciones : {}", evolucionesDTO);
        Evoluciones evoluciones = evolucionesMapper.toEntity(evolucionesDTO);
        evoluciones = evolucionesRepository.save(evoluciones);
        return evolucionesMapper.toDto(evoluciones);
    }

    public Optional<EvolucionesDTO> partialUpdate(EvolucionesDTO evolucionesDTO) {
        log.debug("Request to partially update Evoluciones : {}", evolucionesDTO);

        return evolucionesRepository
            .findById(evolucionesDTO.getId())
            .map(existingEvoluciones -> {
                evolucionesMapper.partialUpdate(existingEvoluciones, evolucionesDTO);

                return existingEvoluciones;
            })
            .map(evolucionesRepository::save)
            .map(evolucionesMapper::toDto);
    }

    @Transactional(readOnly = true)
    public List<EvolucionesDTO> findAll() {
        log.debug("Request to get all Evoluciones");
        return evolucionesRepository.findAll().stream().map(evolucionesMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Transactional(readOnly = true)
    public Optional<EvolucionesDTO> findOne(Integer id) {
        log.debug("Request to get Evoluciones : {}", id);
        return evolucionesRepository.findById(id).map(evolucionesMapper::toDto);
    }

    public void delete(Integer id) {
        log.debug("Request to delete Evoluciones : {}", id);
        evolucionesRepository.deleteById(id);
    }
}
