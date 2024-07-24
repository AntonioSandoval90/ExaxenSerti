package com.prueba.pokemon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpeciesDTO {

    private String name;
    private EvolutionChainDTO evolutionChain;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EvolutionChainDTO getEvolutionChain() {
        return evolutionChain;
    }

    public void setEvolutionChain(EvolutionChainDTO evolutionChain) {
        this.evolutionChain = evolutionChain;
    }

    @Override
    public String toString() {
        return "SpeciesDTO{" +
                "name='" + name + '\'' +
                ", evolutionChain=" + evolutionChain +
                '}';
    }
}
