package br.com.cube.swapi.model;

import java.util.List;

public class SwapiList {
	
	private String count;
	private String next;
	private String previous;
	private List<SwapiPlanet> results;
	
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public String getPrevious() {
		return previous;
	}
	public void setPrevious(String previous) {
		this.previous = previous;
	}
	public List<SwapiPlanet> getResults() {
		return results;
	}
	public void setResults(List<SwapiPlanet> results) {
		this.results = results;
	}
}
