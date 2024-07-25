package com.prueba.pokemon.dto;

import java.io.Serializable;
import java.util.Objects;


public class EvolucionesDTO implements Serializable {

    private Integer id;

    private String nombreEvolucion;

    private PokemonDTO pokemon;

    public EvolucionesDTO(String nombreEvolucion, PokemonDTO pokemon) {
        this.nombreEvolucion = nombreEvolucion;
        this.pokemon = pokemon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEvolucion() {
        return nombreEvolucion;
    }

    public void setNombreEvolucion(String nombreEvolucion) {
        this.nombreEvolucion = nombreEvolucion;
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
        if (!(o instanceof EvolucionesDTO)) {
            return false;
        }

        EvolucionesDTO evolucionesDTO = (EvolucionesDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, evolucionesDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EvolucionesDTO{" +
            "id=" + getId() +
            ", nombreEvolucion='" + getNombreEvolucion() + "'" +
            ", pokemon=" + getPokemon() +
            "}";
    }
}
