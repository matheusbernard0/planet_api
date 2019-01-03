package br.com.cube.swapi.model;

public class PlanetDTO {

	private String id;
	private String nome;
	private String clima;
	private String terreno;
	private int aparitionsQuantity;
	
	public PlanetDTO(String id, String nome, String clima, String terreno, int aparitionsQuantity) {
		this.id = id;
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
		this.aparitionsQuantity = aparitionsQuantity;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public int getAparitionsQuantity() {
		return aparitionsQuantity;
	}
	public void setAparitionsQuantity(int aparitionsQuantity) {
		this.aparitionsQuantity = aparitionsQuantity;
	}
	
}

