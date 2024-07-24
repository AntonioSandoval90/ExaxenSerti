package com.prueba.pokemon.dto;

import java.util.List;

public class PokemonDTO {

    private int id;

    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PokemonDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
