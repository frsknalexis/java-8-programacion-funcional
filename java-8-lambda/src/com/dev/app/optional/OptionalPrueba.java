package com.dev.app.optional;

import java.util.Optional;

public class OptionalPrueba {

	public static void main(String[] args) {
		// probarOptional(null);
		//orElseOptional(null);
		// orElseThrow(null);
		isPresent(null);
	}
	
	public static void probarOptional(String nombre) {
		System.out.println(nombre.length());
	}
	
	public static void crearOptional() {
		Optional<String> optional = Optional.empty();
		optional.get();
	}
	
	public static void orElseOptional(String nombre) {
		Optional<String> optionalStringNull = Optional.ofNullable(nombre);
		// Optional<String> optionalString = Optional.of(nombre);
		
		String nombreOfNullable = optionalStringNull.orElse("Vacio");
		// String nombreOf = optionalString.orElse("Vacio");
		
		System.out.println(nombreOfNullable);
		// System.out.println(nombreOf);
	}
	
	public static void orElseThrow(String nombre) {
		Optional<String> optionalString = Optional.ofNullable(nombre);
		optionalString.orElseThrow(NullPointerException::new);
		
		String nombreString = optionalString.get();
		System.out.println(nombreString);
	}
	
	public static void isPresent(String nombre) {
		Optional<String> optionalString = Optional.ofNullable(nombre);
		System.out.println(optionalString.isPresent());
	}
}
