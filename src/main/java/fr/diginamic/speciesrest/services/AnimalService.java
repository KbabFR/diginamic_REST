package fr.diginamic.speciesrest.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.speciesrest.model.Animal;
import fr.diginamic.speciesrest.repository.AnimalRepository;

@Service
public class AnimalService {

	@Autowired
	AnimalRepository animalRepo;

	public Animal create(@Valid Animal animalToCreate) {
		return this.animalRepo.save(animalToCreate);
	}

	public Animal update(@Valid Animal updateAnimal) {
		return this.animalRepo.save(updateAnimal);
	}

	public List<Animal> findAll() {
		return this.animalRepo.findAll();
	}

	public Animal findById(Integer id) {
		return this.animalRepo.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	public void delete(Animal animalToDelete) {
		this.animalRepo.delete(animalToDelete);
	}
}
