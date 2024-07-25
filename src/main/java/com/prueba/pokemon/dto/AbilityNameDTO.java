package com.prueba.pokemon.dto;

public class AbilityNameDTO {

    private String name;
    private String url;

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
        return "AbilityDetail{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
