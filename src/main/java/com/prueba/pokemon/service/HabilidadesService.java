package com.prueba.pokemon.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.prueba.pokemon.domain.Habilidades;
import com.prueba.pokemon.dto.HabilidadesDTO;
import com.prueba.pokemon.dto.PokemonDTO;
import com.prueba.pokemon.repository.HabilidadesRepository;
import com.prueba.pokemon.service.mapper.HabilidadesMapper;
import com.prueba.pokemon.service.mapper.PokemonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.prueba.pokemon.domain.Pokemon;


@Service
@Transactional
public class HabilidadesService {

    private static final Logger log = LoggerFactory.getLogger(HabilidadesService.class);

    private final HabilidadesRepository habilidadesRepository;

    private final HabilidadesMapper habilidadesMapper;

    @Autowired
    private PokemonMapper pokemonMapper;

    public HabilidadesService(HabilidadesRepository habilidadesRepository, HabilidadesMapper habilidadesMapper) {
        this.habilidadesRepository = habilidadesRepository;
        this.habilidadesMapper = habilidadesMapper;
    }

    public HabilidadesDTO save(HabilidadesDTO habilidadesDTO) {
        log.debug("Request to save Habilidades : {}", habilidadesDTO);
        Habilidades habilidades = habilidadesMapper.toEntity(habilidadesDTO);
        habilidades = habilidadesRepository.save(habilidades);
        return habilidadesMapper.toDto(habilidades);
    }

    public HabilidadesDTO update(HabilidadesDTO habilidadesDTO) {
        log.debug("Request to update Habilidades : {}", habilidadesDTO);
        Habilidades habilidades = habilidadesMapper.toEntity(habilidadesDTO);
        habilidades = habilidadesRepository.save(habilidades);
        return habilidadesMapper.toDto(habilidades);
    }

    public Optional<HabilidadesDTO> partialUpdate(HabilidadesDTO habilidadesDTO) {
        log.debug("Request to partially update Habilidades : {}", habilidadesDTO);

        return habilidadesRepository
            .findById(habilidadesDTO.getId())
            .map(existingHabilidades -> {
                habilidadesMapper.partialUpdate(existingHabilidades, habilidadesDTO);

                return existingHabilidades;
            })
            .map(habilidadesRepository::save)
            .map(habilidadesMapper::toDto);
    }

    @Transactional(readOnly = true)
    public List<HabilidadesDTO> findAll() {
        log.debug("Request to get all Habilidades");
        return habilidadesRepository.findAll().stream().map(habilidadesMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Transactional(readOnly = true)
    public Optional<HabilidadesDTO> findOne(Integer id) {
        log.debug("Request to get Habilidades : {}", id);
        return habilidadesRepository.findById(id).map(habilidadesMapper::toDto);
    }


    public void delete(Integer id) {
        log.debug("Request to delete Habilidades : {}", id);
        habilidadesRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Habilidades> findHabilidadByPokemon(PokemonDTO pokemonDTO) {
        log.debug("Request to get Habilidades By Pokemon: {}", pokemonDTO);
        Pokemon pokemon = pokemonMapper.toEntity(pokemonDTO);
        return habilidadesRepository.findByPokemon(pokemon);
    }
}
