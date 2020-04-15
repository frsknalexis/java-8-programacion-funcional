package com.dev.app.highOrdenFunction;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HighOrderFunctions {

	public static void main(String[] args) {
		
		HighOrderFunctions hof = new HighOrderFunctions();
		
		System.out.println(hof.suma(2, 3));
		
		//-------------HIGH ORDER FUNCTIONS---------------//
		SumarInterfaz sumaInterfaz = (a, b) -> {
			return a + b;
		};
		
		System.out.println(hof.sumarHighOrderFun(sumaInterfaz, 2, 5));
		
		//--------Interfaz funcional Function<T, R>---------------//
		/*
		 interface Function<T t, R r> 
		 {
		 	R apply(T t)
		 }
		 */
		Function<String, String> convertirAMayuscula = (e) -> {
			return e.toUpperCase();
		};
		
		hof.imprimirMayuscula(convertirAMayuscula, "alexis");
		
		///---------------Interfaz Funcional BiFunction<T, U, R>--//
		/*
		 *interface BiFunction<T, U, R>
		 *{
		 *	R apply(T t, U u)
		 *}
		 */
		
		
		//----------------Interfaz Funcional Predicate<T>--------//
		/*
		 *interface Predicate<T>
		 *{
		 *	Boolean text(T t)
		 *} 
		 */
		List<Integer> numeros = Arrays.asList(6, 23, -5, 4, 68, -9, -67, 46);
		
		BiFunction<List<Integer>, Predicate<Integer>, List<Integer>> filtrar = (lista, predicate) -> {
			return lista.stream()
						.filter(e -> predicate.test(e))
						.collect(Collectors.toList());
		};
		
		System.out.println(filtrar.apply(numeros, (e) -> {
			return e > 0;
		}));
		
		//---------Interfaz Funcional Consumer<T>------------//
		/*
		 *interface Consumer<T> 
		 *{
		 *	void accept(T t)
		 *} 
		 */
		
		List<String> nombres = Arrays.asList("Alberto", "Maria", "Paco");
		
		//hof.filtrar(nombres, System.out::println, 6);
		hof.filtrar(nombres, (e) -> System.out.println(e), 6);
	}
	
	public void filtrar(List<String> lista, Consumer<String> consumer, int maximoCaracteres) {
		lista.stream()
			.filter(logicaPredicado(maximoCaracteres))
			.forEach(consumer);
	}
	
	public Predicate<String> logicaPredicado(int maximoCaracteres) {
		return e -> e.length() < maximoCaracteres;
	}
	
	public int suma(int a, int b) {
		return a + b;
	}
	
	public int sumarHighOrderFun(SumarInterfaz sumar, int a, int b) {
		return sumar.apply(a, b);
	}
	
	public void imprimirMayuscula(Function<String, String> function, String name) {
		System.out.println(function.apply(name));
	}
}
