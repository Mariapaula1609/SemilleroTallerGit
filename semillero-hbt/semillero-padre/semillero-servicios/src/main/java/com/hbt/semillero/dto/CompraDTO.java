package com.hbt.semillero.dto;

public class CompraDTO {
	private Long id;
	private int Cantidad;
	/**
	 * Constructor de la clase.
	 * @param id
	 * @param cantidad
	 */
	public CompraDTO(Long id, int cantidad) {
		super();
		this.id = id;
		Cantidad = cantidad;
	}
	/**
	 * Constructor de la clase.
	 */
	public CompraDTO() {
		super();
	}
	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	public Long getId() {
		return id;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * @param id El nuevo id a modificar.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo Cantidad
	 * @return El cantidad asociado a la clase
	 */
	public int getCantidad() {
		return Cantidad;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo Cantidad
	 * @param cantidad El nuevo cantidad a modificar.
	 */
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
		
	
}
