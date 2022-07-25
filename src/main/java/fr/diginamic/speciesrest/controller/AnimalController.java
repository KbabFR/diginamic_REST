package fr.diginamic.speciesrest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.speciesrest.model.Animal;
import fr.diginamic.speciesrest.services.AnimalService;

@RestController
@RequestMapping("/rest/animal")
public class AnimalController {

	@Autowired
	private AnimalService animalService;

	@GetMapping
	public List<Animal> findall() {
		return this.animalService.findAll();
	}

	@GetMapping("/{id}")
	public Animal findOne(@PathVariable("id") Integer id) {
		return this.animalService.findById(id);
	}

	@PostMapping
	public Animal createAnimal(@RequestBody @Valid Animal animalToCreate) {
		return this.animalService.create(animalToCreate);
	}

	@PutMapping
	public Animal updateAnimal(@RequestBody @Valid Animal updateAnimal) {
		return this.animalService.update(updateAnimal);
	}

	@DeleteMapping
	public void deleteAnimal(@RequestBody @Valid Animal animalToDelete) {
		this.animalService.delete(animalToDelete);
	}
}
