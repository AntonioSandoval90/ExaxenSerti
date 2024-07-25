package com.prueba.pokemon.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prueba.pokemon.dto.Auditable;
import jakarta.persistence.*;
import java.io.Serializable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Habilidades.
 */
@Entity
@Table(name = "habilidades")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Habilidades extends Auditable implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "habilidad")
    private String habilidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "habilidades", "evoluciones" }, allowSetters = true)
    private Pokemon pokemon;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Integer getId() {
        return this.id;
    }

    public Habilidades id(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHabilidad() {
        return this.habilidad;
    }

    public Habilidades habilidad(String habilidad) {
        this.setHabilidad(habilidad);
        return this;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public Pokemon getPokemon() {
        return this.pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public Habilidades pokemon(Pokemon pokemon) {
        this.setPokemon(pokemon);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Habilidades)) {
            return false;
        }
        return getId() != null && getId().equals(((Habilidades) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Habilidades{" +
            "id=" + getId() +
            ", habilidad='" + getHabilidad() + "'" +
            "}";
    }
}
