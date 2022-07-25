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

import fr.diginamic.speciesrest.model.Species;
import fr.diginamic.speciesrest.services.SpeciesService;

@RestController
@RequestMapping("/rest/species")
public class SpeciesController {
	
	@Autowired
	private SpeciesService speciesService = new SpeciesService();

	@GetMapping
	public List<Species> findall() {
		return this.speciesService.findAll();
	}
	
	@GetMapping("/{id}")
	public Species findOne(@PathVariable("id") Integer id) {
		return this.speciesService.findById(id);
	}
	
	@PostMapping
	public Species createSpecies(@RequestBody @Valid Species speciesToCreate) {
		return this.speciesService.create(speciesToCreate);
	}

	@PutMapping
	public Species updateSpecies(@RequestBody @Valid Species updateSpecies) {
		return this.speciesService.update(updateSpecies);
	}
	
	@DeleteMapping
	public void deleteSpecies(@RequestBody @Valid Species speciesToDelete) {
		this.speciesService.delete(speciesToDelete);
	}
}
