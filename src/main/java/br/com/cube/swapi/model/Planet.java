package br.com.cube.swapi.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Planet {
	
	@Id
	private String id;
	
	private String nome;
	private String clima;
	private String terreno;
	
	public Planet(String nome, String clima, String terreno) {
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
	}
	
	public Planet() {
		
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
	
	@Override
	public String toString() {
		return String.format("Planeta[id=%s, nome='%s', clima='%s', terreno='%s']",
							 this.id, this.nome, this.clima, this.terreno);
	}
}
