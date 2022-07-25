package fr.diginamic.speciesrest.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.speciesrest.model.Person;
import fr.diginamic.speciesrest.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepo;

	public Person create(@Valid Person personToCreate) {
		return this.personRepo.save(personToCreate);
	}

	public Person update(@Valid Person updatePerson) {
		return this.personRepo.save(updatePerson);
	}

	public List<Person> findAll() {
		return this.personRepo.findAll();
	}

	public Person findById(Integer id) {
		return this.personRepo.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	public void delete(@Valid Person personToDelete) {
		this.personRepo.delete(personToDelete);
	}

}
