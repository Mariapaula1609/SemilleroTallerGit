package com.hbt.semillero.dto;

import java.util.ArrayList;

public class ConsultarComicTamanioNombreDTO extends ResultadoDTO {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<String> mayorLongitud;
	private ArrayList<String> menorLongitud;
	/**
	 * Constructor de la clase.
	 * @param mayorLongitud
	 * @param menorLongitud
	 */
	public ConsultarComicTamanioNombreDTO() {
		
	}
	public ConsultarComicTamanioNombreDTO(ArrayList<String> mayorLongitud, ArrayList<String> menorLongitud) {
		super();
		this.mayorLongitud = mayorLongitud;
		this.menorLongitud = menorLongitud;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo mayorLongitud
	 * @return El mayorLongitud asociado a la clase
	 */
	public ArrayList<String> getMayorLongitud() {
		return mayorLongitud;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo mayorLongitud
	 * @param mayorLongitud El nuevo mayorLongitud a modificar.
	 */
	public void setMayorLongitud(ArrayList<String> mayorLongitud) {
		this.mayorLongitud = mayorLongitud;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo menorLongitud
	 * @return El menorLongitud asociado a la clase
	 */
	public ArrayList<String> getMenorLongitud() {
		return menorLongitud;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo menorLongitud
	 * @param menorLongitud El nuevo menorLongitud a modificar.
	 */
	public void setMenorLongitud(ArrayList<String> menorLongitud) {
		this.menorLongitud = menorLongitud;
	}
	
}
