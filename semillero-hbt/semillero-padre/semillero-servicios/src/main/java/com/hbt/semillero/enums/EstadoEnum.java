package com.hbt.semillero.enums;
/**
 * CLASE QUE INDICA EL ESTADO DEL COMIC , INACTIVO Y ACTIVO 
 */

public enum EstadoEnum {
	ACTIVO("enum.estado.activo"),
	INACTIVO("enum.estado.inactivo");
	/**
	 * 
	 */
	
	private String estado;

	/**
	 * Metodo encargado de retornar el valor del atributo estado
	 * @return El estado asociado a la clase 
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo estado
	 * @param estado El nuevo estado a modificar.
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Constructor que recibe como parametro el estado del commic 
	 * 
	 * @param estado, (Activo o inactivo)
	 */
		EstadoEnum(String estado){
			this.estado= estado;
		}
	
}
