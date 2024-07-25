package com.prueba.pokemon.dto;

import java.io.Serializable;
import java.util.Objects;


public class PokemonDTO implements Serializable {

    private Integer id;

    private String nombre;

    public PokemonDTO(){};

    public PokemonDTO(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PokemonDTO)) {
            return false;
        }

        PokemonDTO pokemonDTO = (PokemonDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, pokemonDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PokemonDTO{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + "'" +
                "}";
    }
}
