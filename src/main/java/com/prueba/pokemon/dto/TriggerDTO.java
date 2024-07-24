package com.prueba.pokemon.dto;

public class TriggerDTO {

    private String name;
    private String url;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "TriggerDTO{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
