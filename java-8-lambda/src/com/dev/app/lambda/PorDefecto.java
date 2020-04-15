package com.dev.app.lambda;

public interface PorDefecto {

	void mostrarNombre(String nombre);
	
	default String nombrePorDefecto(String nombre) {
		return nombre + " Por Defecto";
	}
}
