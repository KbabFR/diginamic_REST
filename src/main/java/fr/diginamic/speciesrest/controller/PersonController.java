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

import fr.diginamic.speciesrest.model.Person;
import fr.diginamic.speciesrest.services.PersonService;

@RestController
@RequestMapping("/rest/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	/*
	 * WORK IN PROGRESS
	 * 
	 * @GetMapping("/all") public Page<Person> findall(@RequestBody @Valid Pageable
	 * pageable) { return this.personService.findAll(pageable); }
	 */

	@GetMapping()
	public List<Person> findall() {
		return this.personService.findAll();
	}

	@GetMapping("/{id}")
	public Person findOne(@PathVariable("id") Integer id) {
		return this.personService.findById(id);
	}

	@PostMapping
	public Person createPerson(@RequestBody @Valid Person personToCreate) {
		return this.personService.create(personToCreate);
	}

	@PutMapping
	public Person updatePerson(@RequestBody @Valid Person updatePerson) {
		return this.personService.update(updatePerson);
	}

	@DeleteMapping
	public void deletePerson(@RequestBody @Valid Person personToDelete) {
		this.personService.delete(personToDelete);
	}
}
