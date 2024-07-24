package com.prueba.pokemon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ChainDTO {

    @JsonProperty("evolution_details")
    private List<EvolutionDetailDTO> evolutionDetails;
    @JsonProperty("evolves_to")
    private List<ChainDTO> evolvesTo;
    @JsonProperty("is_baby")
    private boolean isBaby;
    private SpeciesDTO species;

    // Getters and Setters
    public List<EvolutionDetailDTO> getEvolutionDetails() {
        return evolutionDetails;
    }

    public void setEvolutionDetails(List<EvolutionDetailDTO> evolutionDetails) {
        this.evolutionDetails = evolutionDetails;
    }

    public List<ChainDTO> getEvolvesTo() {
        return evolvesTo;
    }

    public void setEvolvesTo(List<ChainDTO> evolvesTo) {
        this.evolvesTo = evolvesTo;
    }

    public boolean isBaby() {
        return isBaby;
    }

    public void setBaby(boolean baby) {
        isBaby = baby;
    }

    public SpeciesDTO getSpecies() {
        return species;
    }

    public void setSpecies(SpeciesDTO species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "ChainDTO{" +
                "evolutionDetails=" + evolutionDetails +
                ", evolvesTo=" + evolvesTo +
                ", isBaby=" + isBaby +
                ", species=" + species +
                '}';
    }
}
