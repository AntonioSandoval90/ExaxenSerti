package com.prueba.pokemon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EvolutionChainDTO {
    private ChainDTO chain;
    private int id;

    // Getters and Setters
    public ChainDTO getChain() {
        return chain;
    }

    public void setChain(ChainDTO chain) {
        this.chain = chain;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EvolutionChainDTO{" +
                "chain=" + chain +
                ", id=" + id +
                '}';
    }
}
