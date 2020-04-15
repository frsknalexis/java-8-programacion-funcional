package com.dev.app.referenciametodo;

import java.util.ArrayList;
import java.util.List;

public class ReferenciaMetodo {

	public static void main(String[] args) {

		Trabajo trabajo = new Trabajo() {
			
			@Override
			public void accion() {
				User.referenciaAMetodoEstatico();
			}
		};
		
		Trabajo trabajoLambda = () -> User.referenciaAMetodoEstatico();
		
		Trabajo trabajoMR = User::referenciaAMetodoEstatico;
		
		trabajoMR.accion();
		
		User user = new User("ALEXIS");
		Trabajo trabajoLambda2 = () -> user.referenciaAMetodoParticular();
		Trabajo trabajoLambda2MR = user::referenciaAMetodoParticular;
		trabajoLambda2MR.accion();
		
		TrabajoString trabajoString = (palabra) -> {
			return palabra.toUpperCase();
		};
		
		TrabajoString trabajoStringMR = String::toUpperCase;
		
		System.out.println(trabajoStringMR.accion("alexis"));
		
		List<User> users = new ArrayList<>();
		users.add(new User("Alberto"));
		users.add(new User("Alexis"));
		users.add(new User("Adolfo"));
		users.add(new User("Abner"));
		
		users.forEach((usuario) -> {
			usuario.mostrarNombre();
		});
		
		users.forEach(User::mostrarNombre);
		
		UserInterface userInterface = new UserInterface() {
			
			@Override
			public User crear(String nombre) {
				return new User(nombre);
			}
		};
		
		UserInterface userInterfaceLambda = (nombre) -> new User(nombre);
		UserInterface userInterfaceMR = User::new;
	}
}
