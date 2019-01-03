package br.com.cube.swapi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.cube.swapi.exception.PlanetApiException;
import br.com.cube.swapi.model.SwapiList;
import br.com.cube.swapi.model.SwapiPlanet;

@Component
public class SwapiService {
		
	@Value("${swapi.url}")
	private String swapiurl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Cacheable("planets")
	public Map<String, Integer> getPlanets() {		
		ResponseEntity<SwapiList> forEntity = restTemplate.getForEntity(swapiurl, SwapiList.class);
		if (forEntity.getStatusCode() != HttpStatus.OK) {
			throw new PlanetApiException("Não possível retornar o recurso da SWAPI", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return this.craeteMap(forEntity.getBody());	
	}
	
	private Map<String, Integer> craeteMap(SwapiList body) {
		
		List<SwapiPlanet> results = body.getResults();		
		Map<String, Integer> planetMap = new HashMap<>();
		
		results.forEach( planet -> {
			planetMap.put(planet.getName(), planet.getFilms().size());
		});
		return planetMap;
	}
	
	
}
