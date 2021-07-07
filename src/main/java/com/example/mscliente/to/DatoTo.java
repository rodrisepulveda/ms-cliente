package com.example.mscliente.to;

import java.io.Serializable;

public class DatoTo implements Serializable {

	/**
	 * Serie.
	 */
	private static final long serialVersionUID = -2801601735644149563L;

	private String dato1;

	private String dato2;

	public String getDato1() {
		return dato1;
	}

	public void setDato1(String dato1) {
		this.dato1 = dato1;
	}

	public String getDato2() {
		return dato2;
	}

	public void setDato2(String dato2) {
		this.dato2 = dato2;
	}

}
