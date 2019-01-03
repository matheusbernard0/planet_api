package br.com.cube.swapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.cube.swapi.exception.PlanetApiException;
import br.com.cube.swapi.model.Planet;
import br.com.cube.swapi.model.PlanetDTO;
import br.com.cube.swapi.model.PlanetRegisterDTO;
import br.com.cube.swapi.repository.PlanetRepository;
import br.com.cube.swapi.resource.PlanetResource;

@Service
public class PlanetService {
	
	@Autowired
	private SwapiService swapiService; 
	
	@Autowired
	private PlanetRepository planetRepository;
		
	public ResponseEntity<PlanetDTO> save(PlanetRegisterDTO planet) {
		Planet p = this.planetRepository.findByNome(planet.getNome());
		if (p != null) {
			throw new PlanetApiException("O planeta informado já existe no banco de dados", HttpStatus.PRECONDITION_FAILED);
		}
		Planet mapPlanetRegisterDtoToPlanet = this.mapPlanetRegisterDtoToPlanet(planet);
		return new ResponseEntity<>(this.mapPlanetToPlanetDto(this.planetRepository.save(mapPlanetRegisterDtoToPlanet)), HttpStatus.CREATED);
	}
	
	public ResponseEntity<List<PlanetDTO>> findAll() {
		List<Planet> planets = this.planetRepository.findAll();
		List<PlanetDTO> planetDtoList = new ArrayList<>();
		planets.forEach(planet -> {
			planetDtoList.add(this.mapPlanetToPlanetDto(planet));
		});
		return new ResponseEntity<>(planetDtoList, HttpStatus.OK);
	}
		
	public ResponseEntity<PlanetDTO> findByName(String name) {
		Planet planet = this.planetRepository.findByNome(name);
		if (planet == null) {
			throw new PlanetApiException("Não existe um planeta para o nome informado", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(this.mapPlanetToPlanetDto(planet), HttpStatus.OK);
	}
	
	public ResponseEntity<PlanetDTO> findById(String id) {
		Optional<Planet> planet = this.planetRepository.findById(id);
		if (!planet.isPresent()) {
			throw new PlanetApiException("Não existe um planeta com o nome informado", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(this.mapPlanetToPlanetDto(planet.get()), HttpStatus.OK);
	}
	
	public void delete(String id) {
		if (!this.planetRepository.existsById(id)) {			
			throw new PlanetApiException("Não existe um planeta para o id informado", HttpStatus.NOT_FOUND);
		}
		this.planetRepository.deleteById(id);
	}
	
	private PlanetDTO mapPlanetToPlanetDto(Planet planet) {
		return new PlanetDTO(planet.getId(), planet.getNome(), planet.getClima(), planet.getTerreno(), this.getPlanetApparitions(planet.getNome()));
	} 
	
	private Planet mapPlanetRegisterDtoToPlanet(PlanetRegisterDTO planetRegisterDto) {
		return new Planet(planetRegisterDto.getNome(), planetRegisterDto.getClima(), planetRegisterDto.getTerreno());
	}
		
	private int getfilmsQuantityByPlanetName(String planetName) {
		Map<String, Integer> films = this.swapiService.getPlanets();
		if (!films.containsKey(planetName)) {
			return 0;
		}
		return films.get(planetName);
	}	
	
	private int getPlanetApparitions(String planetName) {
		return this.getfilmsQuantityByPlanetName(planetName);
	}
}
