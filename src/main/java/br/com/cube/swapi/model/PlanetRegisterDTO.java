package br.com.cube.swapi.model;

import javax.validation.constraints.NotNull;

public class PlanetRegisterDTO {
	
	@NotNull(message="O nome do planeta deve ser informado")
	private String nome;
	@NotNull(message="O clima deve ser informado")
	private String clima;
	@NotNull(message="O terreno deve ser informado")
	private String terreno;
	
	public PlanetRegisterDTO(String id, String nome, String clima, String terreno, int aparitionsQuantity) {
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
	}
	
	public PlanetRegisterDTO() {
		
	}
		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}
	public String getTerreno() {
		return terreno;
	}
	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}	
}
