package br.com.cube.swapi.resource;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cube.swapi.exception.PlanetApiException;
import br.com.cube.swapi.model.Planet;
import br.com.cube.swapi.model.PlanetDTO;
import br.com.cube.swapi.model.PlanetRegisterDTO;
import br.com.cube.swapi.service.PlanetService;
import br.com.cube.swapi.service.SwapiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/planeta")
@Api(value = "Planet API", description = "API ReST responsável pelo CRUD de planetas")
public class PlanetResource {

	@Autowired
	private PlanetService planetService;

	@ApiOperation(value = "Cria um planeta")
	@RequestMapping(method=RequestMethod.POST)
	private ResponseEntity<PlanetDTO> save(@Valid @RequestBody PlanetRegisterDTO planeta) {
		return this.planetService.save(planeta);
	}
	
	@ApiOperation(value = "Lista todos planetas cadastrados")
	@RequestMapping(method=RequestMethod.GET)
	private ResponseEntity<List<PlanetDTO>> findAll() {
		return this.planetService.findAll();
	}
	
	@ApiOperation(value = "Busca um planeta pelo nome")
	@RequestMapping(path="/name", method=RequestMethod.GET)
	private ResponseEntity<PlanetDTO> findByName(@RequestParam(value="nome", required = true) String nome) {
		return this.planetService.findByName(nome);
	}
	
	@ApiOperation(value = "Busca um planeta pelo id")
	@RequestMapping(path="/{planetaId}", method=RequestMethod.GET)
	private ResponseEntity<PlanetDTO> findById( @PathVariable("planetaId") String planetaId ) {
		return this.planetService.findById(planetaId);
	}
	
	@ApiOperation(value = "Deleta um planeta pelo id")
	@RequestMapping(path="/{planetaId}", method=RequestMethod.DELETE)
	private void deleteById(@PathVariable("planetaId") String planetId ) {
		this.planetService.delete(planetId);
	}
	
}
