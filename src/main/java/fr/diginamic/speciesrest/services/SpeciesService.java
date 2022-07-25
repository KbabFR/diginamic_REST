package fr.diginamic.speciesrest.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.speciesrest.model.Species;
import fr.diginamic.speciesrest.repository.SpeciesRepository;

@Service
public class SpeciesService {
	
	@Autowired
	SpeciesRepository speciesRepo;

	public Species create(@Valid Species speciesToCreate) {
		return this.speciesRepo.save(speciesToCreate);
	}

	public Species update(@Valid Species updateSpecies) {
		return this.speciesRepo.save(updateSpecies);
	}

	public List<Species> findAll() {
		return this.speciesRepo.findAll();
	}

	public Species findById(Integer id) {
		return this.speciesRepo.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	public void delete(Species speciesToDelete) {
		this.speciesRepo.delete(speciesToDelete);
	}
}
