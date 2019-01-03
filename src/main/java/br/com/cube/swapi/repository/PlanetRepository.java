package br.com.cube.swapi.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.cube.swapi.model.Planet;

@Repository
public interface PlanetRepository extends MongoRepository<Planet, String>{

	public Planet findByNome(String name);
}
