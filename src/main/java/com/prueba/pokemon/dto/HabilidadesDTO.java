package com.prueba.pokemon.dto;

import java.io.Serializable;
import java.util.Objects;

public class HabilidadesDTO implements Serializable {

    private Integer id;

    private String habilidad;

    private PokemonDTO pokemon;

    public HabilidadesDTO() {
    }

    public HabilidadesDTO(String habilidad, PokemonDTO pokemon) {
        this.habilidad = habilidad;
        this.pokemon = pokemon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public PokemonDTO getPokemon() {
        return pokemon;
    }

    public void setPokemon(PokemonDTO pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HabilidadesDTO)) {
            return false;
        }

        HabilidadesDTO habilidadesDTO = (HabilidadesDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, habilidadesDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "HabilidadesDTO{" +
            "id=" + getId() +
            ", habilidad='" + getHabilidad() + "'" +
            ", pokemon=" + getPokemon() +
            "}";
    }
}
