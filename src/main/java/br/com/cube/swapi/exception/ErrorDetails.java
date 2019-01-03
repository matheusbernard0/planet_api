package br.com.cube.swapi.exception;

import java.util.Date;

public class ErrorDetails {
	  private Date timestamp;
	  private Object message;


	  public ErrorDetails(Date timestamp, Object message) {
	    this.timestamp = timestamp;
	    this.message = message;
	  }

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
