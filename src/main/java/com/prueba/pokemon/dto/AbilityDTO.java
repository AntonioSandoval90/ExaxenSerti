package com.prueba.pokemon.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AbilityDTO {

    @JsonProperty("ability")
    private AbilityNameDTO abilityName;

    @JsonProperty("is_hidden")
    private boolean isHidden;

    private int slot;

    public AbilityNameDTO getAbilityName() {
        return abilityName;
    }

    public void setAbilityName(AbilityNameDTO abilityName) {
        this.abilityName = abilityName;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    @Override
    public String toString() {
        return "Ability{" +
                "abilityName=" + abilityName +
                ", isHidden=" + isHidden +
                ", slot=" + slot +
                '}';
    }
}