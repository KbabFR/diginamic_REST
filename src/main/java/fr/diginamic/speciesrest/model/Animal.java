package fr.diginamic.speciesrest.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.diginamic.speciesrest.enums.Sex;

import java.util.Set;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    @NotEmpty
    @Size(max = 50)
    private String name;

    @Column(length = 50)
    @NotEmpty
    @Size(max = 50)
    private String color;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @ManyToOne
    @NotNull
    private Species species;

    @ManyToMany(mappedBy = "animals")
    @JsonIgnore
    Set<Person> persons;

    // Getters / setters

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }
}
