package com.dev.app.referenciametodo;

public class User {

	private String nombre;
	
	public User(String nombre) {
		this.nombre = nombre;
	}
	
	public static void referenciaAMetodoEstatico() {
		System.out.println("Probando referencia a metodo static");
	}
	
	public void referenciaAMetodoParticular() {
		System.out.println("Probando referencia a metodo de objeto particular");
	}
	
	public void mostrarNombre() {
		System.out.println(nombre);
	}
}
