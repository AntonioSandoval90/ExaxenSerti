package com.prueba.pokemon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EvolutionDetailDTO {
    @JsonProperty("min_level")
    private Integer minLevel;
    private TriggerDTO trigger;

    // Getters and Setters
    public Integer getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(Integer minLevel) {
        this.minLevel = minLevel;
    }

    public TriggerDTO getTrigger() {
        return trigger;
    }

    public void setTrigger(TriggerDTO trigger) {
        this.trigger = trigger;
    }

    @Override
    public String toString() {
        return "EvolutionDetailDTO{" +
                "minLevel=" + minLevel +
                ", trigger=" + trigger +
                '}';
    }
}
