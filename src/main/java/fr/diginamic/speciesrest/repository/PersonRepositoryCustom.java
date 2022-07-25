package fr.diginamic.speciesrest.repository;

public interface PersonRepositoryCustom {

    int deletePersonsWithoutAnimal();

    void insertRandomPersons(int numberToCreate);
}
