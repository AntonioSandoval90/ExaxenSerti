package com.prueba.pokemon.dto;

import java.util.List;

public class InformacionPokemonDTO {

    private int id;

    private String nombre;

    private List<String> cadenaEvolucion;

    public InformacionPokemonDTO(){};

    public InformacionPokemonDTO(int id, String nombre, List<String> cadenaEvolucion) {
        this.id = id;
        this.nombre = nombre;
        this.cadenaEvolucion = cadenaEvolucion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getCadenaEvolucion() {
        return cadenaEvolucion;
    }

    public void setCadenaEvolucion(List<String> cadenaEvolucion) {
        this.cadenaEvolucion = cadenaEvolucion;
    }

    @Override
    public String toString() {
        return "InformacionPokemon{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cadenaEvolucion=" + cadenaEvolucion +
                '}';
    }
}
