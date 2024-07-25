package com.prueba.pokemon.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Pokemon.
 */
@Entity
@Table(name = "pokemon")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Pokemon implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pokemon")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "pokemon" }, allowSetters = true)
    private Set<Habilidades> habilidades = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pokemon")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "pokemon" }, allowSetters = true)
    private Set<Evoluciones> evoluciones = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Integer getId() {
        return this.id;
    }

    public Pokemon id(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Pokemon nombre(String nombre) {
        this.setNombre(nombre);
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Habilidades> getHabilidades() {
        return this.habilidades;
    }

    public void setHabilidades(Set<Habilidades> habilidades) {
        if (this.habilidades != null) {
            this.habilidades.forEach(i -> i.setPokemon(null));
        }
        if (habilidades != null) {
            habilidades.forEach(i -> i.setPokemon(this));
        }
        this.habilidades = habilidades;
    }

    public Pokemon habilidades(Set<Habilidades> habilidades) {
        this.setHabilidades(habilidades);
        return this;
    }

    public Pokemon addHabilidades(Habilidades habilidades) {
        this.habilidades.add(habilidades);
        habilidades.setPokemon(this);
        return this;
    }

    public Pokemon removeHabilidades(Habilidades habilidades) {
        this.habilidades.remove(habilidades);
        habilidades.setPokemon(null);
        return this;
    }

    public Set<Evoluciones> getEvoluciones() {
        return this.evoluciones;
    }

    public void setEvoluciones(Set<Evoluciones> evoluciones) {
        if (this.evoluciones != null) {
            this.evoluciones.forEach(i -> i.setPokemon(null));
        }
        if (evoluciones != null) {
            evoluciones.forEach(i -> i.setPokemon(this));
        }
        this.evoluciones = evoluciones;
    }

    public Pokemon evoluciones(Set<Evoluciones> evoluciones) {
        this.setEvoluciones(evoluciones);
        return this;
    }

    public Pokemon addEvoluciones(Evoluciones evoluciones) {
        this.evoluciones.add(evoluciones);
        evoluciones.setPokemon(this);
        return this;
    }

    public Pokemon removeEvoluciones(Evoluciones evoluciones) {
        this.evoluciones.remove(evoluciones);
        evoluciones.setPokemon(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pokemon)) {
            return false;
        }
        return getId() != null && getId().equals(((Pokemon) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Pokemon{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            "}";
    }
}
