package com.dev.app.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPrueba {

	private static List<Usuario> usuarios;
	
	public static void main(String[] args) {
		setUp();
		Stream<List<Usuario>> streamUsuarios = Stream.of(usuarios);
		usuarios.stream();
		
		// ForEach
		usuarios.stream().forEach((usuario) -> {
			usuario.setNombre(usuario.getNombre() + " Apellido");
		});
		
		imprimirLista();
		
		// Map y Collectors.toList
		List<String> listaString = usuarios.stream()
											.map((usuario) -> {
												return usuario.getNombre();
											})
											.collect(Collectors.toList());
		
		listaString.stream().forEach((nombre) -> System.out.println(nombre));
		
		System.out.println("---------------FILTERS----------------------");
		setUp();
		List<Usuario> usersFilter = usuarios.stream()
											.filter((usuario) -> {
												return usuario.getNombre() != "Alberto";
											})
											.filter((usuario) -> {
												return usuario.getId() < 3;
											})
											.collect(Collectors.toList());
		
		usersFilter.stream().forEach((u) -> System.out.println(u.getId() + " " + u.getNombre()));
		
		System.out.println("---------------FIND FIRST----------------------");
		setUp();
		Usuario usuarioReturn = usuarios.stream()
										.filter((usuario) -> {
											return usuario.getNombre().equals("Alberto");
										})
										.findFirst()
										.orElse(new Usuario(7, "Usuario Por defecto"));
		
		System.out.println(usuarioReturn.getId() + " " + usuarioReturn.getNombre());
		
		System.out.println("---------------FLAT MAP----------------------");
		// flatMap
		List<List<String>> nombresVariasListas = new ArrayList<List<String>>(
				Arrays.asList(
						new ArrayList<String>(Arrays.asList("Alberto", "Maria", "Pedro")),
						new ArrayList<String>(Arrays.asList("Monica", "Pablo"))));
		
		List<String> nombresUnicaLista = nombresVariasListas.stream()
															.flatMap((e) -> {
																return e.stream();
															})
															.collect(Collectors.toList());
		
		nombresUnicaLista.stream().forEach((nombre) -> System.out.println(nombre));
		
		System.out.println("---------------PEEK----------------------");
		//peek
		setUp();
		
		List<Usuario> usuarios2 = usuarios.stream()
										.peek((usuario) -> {
											usuario.setNombre(usuario.getNombre() + " Apellido");
										})
										.collect(Collectors.toList());
		
		usuarios2.stream().forEach((u) -> System.out.println(u.getNombre()));
		
		System.out.println("---------------COUNT----------------------");
		//count
		setUp();
		
		long cantidadElementos = usuarios.stream().count();
		System.out.println("Cantidad de elementos de la lista de usuarios: " + cantidadElementos);
		
		long numeroFiltrado = usuarios.stream()
								.filter((usuario) -> {
									return usuario.getId() < 3;
								})
								.count();
		
		System.out.println("Cantidad de elementos filtrados de la lista de usuarios: " + numeroFiltrado);
		
		System.out.println("---------------SKIP Y LIMIT----------------------");
		//skip y limit
		String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};

		List<String> abcFiltrado = Arrays.stream(abc)
										.skip(2)
										.limit(4)
										.collect(Collectors.toList());
		abcFiltrado.stream().forEach((e) -> System.out.println(e));
		
		System.out.println("---------------SORTED----------------------");
		//sorted
		setUp();
		
		usuarios = usuarios.stream()
						.sorted(Comparator.comparing(Usuario::getNombre))
						.collect(Collectors.toList());
		imprimirLista();
		
		System.out.println("---------------MIN Y MAX----------------------");
		//min y max
		setUp();
		
		Usuario usuarioMinimo = usuarios.stream()
										.min(Comparator.comparing(Usuario::getId))
										.orElse(null);
		System.out.println("Usuario minimo: " + usuarioMinimo.getId() + " " + usuarioMinimo.getNombre());
		
		Usuario usuarioMaximo = usuarios.stream()
										.max(Comparator.comparing(Usuario::getId))
										.orElse(null);
		
		System.out.println("Usuario Maximo: " + usuarioMaximo.getId() + " " + usuarioMaximo.getNombre());
		
		System.out.println("---------------DISTINCT----------------------");
		//distinct
		String[] abc1 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "a", "c"};
		
		List<String> abcFiltradoDistinct = Arrays.stream(abc1)
												.distinct()
												.collect(Collectors.toList());
		
		abcFiltradoDistinct.stream().forEach((e) -> System.out.println(e));
		
		System.out.println("---------------anyMatch, allMatch, noneMatch----------------------");
		//anyMatch, allMatch, noneMatch
		
		List<Integer> listaNumeros = Arrays.asList(100, 300, 900, 5000);
		
		boolean allMatch = listaNumeros.stream()
							.allMatch((e) -> {
								return e > 301;
							});
		
		System.out.println(allMatch);
		
		boolean anyMatch = listaNumeros.stream()
							.anyMatch((e) -> {
								return e > 301;
							});
		
		System.out.println(anyMatch);
		
		boolean noneMatch = listaNumeros.stream()
								.noneMatch((e) -> {
									return e > 10000;
								});
		
		System.out.println(noneMatch);
		
		System.out.println("---------------sum, average, range----------------------");
		//sum, average, range
		setUp();
		
		double result = usuarios.stream()
						.mapToInt(Usuario::getId)
						.average()
						.orElse(0.00);
		
		System.out.println(result);
		
		int resultadoSuma = usuarios.stream()
									.mapToInt(Usuario::getId)
									.sum();
		
		System.out.println(resultadoSuma);
		
		System.out.println(IntStream.range(0, 100).sum());
		
		System.out.println("---------------reduce----------------------");
		//reduce
		setUp();
		
		int numeroSuma = usuarios.stream()
								.map(Usuario::getId)
								//.reduce(100, (a, b) -> a+ b); primera forma
								.reduce(0, Integer::sum);
		
		System.out.println(numeroSuma);
		
		System.out.println("---------------JOINING----------------------");
		//joining
		setUp();
		
		String namesJoining = usuarios.stream()
									.map((usuario) -> {
										return usuario.getNombre();
									})
									.collect(Collectors.joining(" - "))
									.toString();
		
		System.out.println(namesJoining);
		
		System.out.println("---------------toSet----------------------");
		//toSet
		setUp();
		
		Set<String> usuariosSet = usuarios.stream()
								.map(Usuario::getNombre)
								.collect(Collectors.toSet());
		
		usuariosSet.stream().forEach((nombre) -> System.out.println(nombre));
		
		System.out.println("---------------summarizingDouble----------------------");
		//summarizingDouble
		setUp();
		
		DoubleSummaryStatistics statistics = usuarios.stream()
							.collect(Collectors.summarizingDouble(Usuario::getId));
		
		System.out.println(statistics.getAverage() + " " + statistics.getMax() + " " + statistics.getMin() + " " 
				+ statistics.getCount() + " " + statistics.getSum());
		
		IntSummaryStatistics statistics1 = usuarios.stream()
							.mapToInt(Usuario::getId)
							.summaryStatistics();
		
		System.out.println(statistics1.getAverage() + " " + statistics1.getMax() + " " + statistics1.getMin() + " " 
				+ statistics1.getCount() + " " + statistics1.getSum());
		
		System.out.println("---------------partitioningBy----------------------");
		//partitioningBy
		setUp();
		
		List<Integer> numerosLista = Arrays.asList(5, 7, 34, 56, 2, 3, 67, 4, 98);
		
		Map<Boolean, List<Integer>> esMayor = numerosLista.stream()
														.collect(Collectors.partitioningBy(e -> e > 10));
		
		esMayor.get(true).stream().forEach((i) -> System.out.println(i));
		esMayor.get(false).stream().forEach((i) -> System.out.println(i));
		
		System.out.println("---------------groupingBy----------------------");
		//groupingBy
		setUp();
		
		Map<Character, List<Usuario>> grupoAlfabetico = usuarios.stream()
											.collect(Collectors.groupingBy(e -> new Character(e.getNombre().charAt(0))));
		
		grupoAlfabetico.get('A').stream().forEach((usuario) -> System.out.println(usuario.getNombre()));
		grupoAlfabetico.get('M').stream().forEach((usuario) -> System.out.println(usuario.getNombre()));
		grupoAlfabetico.get('P').stream().forEach((usuario) -> System.out.println(usuario.getNombre()));
		
		System.out.println("---------------mapping----------------------");
		//mapping
		setUp();
		
		List<String> personas = usuarios.stream()
						.collect(Collectors.mapping(Usuario::getNombre, Collectors.toList()));
		
		personas.stream().forEach((e) -> System.out.println(e));
		
		System.out.println("---------------stream paralelo----------------------");
		//stream paralelo
		setUp();
		
		long tiempo1 = System.currentTimeMillis();
		listaString.stream().forEach((e) -> convertirAMayusculas(e));
		long tiempo2 = System.currentTimeMillis();
		
		System.out.println("Stream: " + (tiempo2 - tiempo1));
		
		tiempo1 = System.currentTimeMillis();
		listaString.parallelStream().forEach((e) -> convertirAMayusculas(e));
		tiempo2 = System.currentTimeMillis();
		
		System.out.println("Stream Paralelo: " + (tiempo2 - tiempo1));
	}
	
	private static String convertirAMayusculas(String nombre) {
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		return nombre.toUpperCase();
	}
	
	private static void setUp() {
		usuarios = new ArrayList<>();
		usuarios.add(new Usuario(1, "Alberto"));
		usuarios.add(new Usuario(2, "Marta"));
		usuarios.add(new Usuario(3, "Maria"));
		usuarios.add(new Usuario(4, "Pablo"));
		usuarios.add(new Usuario(5, "Adolfo"));
		usuarios.add(new Usuario(6, "Alberto"));
	}
	
	private static void imprimirLista() {
		usuarios.stream().forEach((usuario) -> {
			System.out.println(usuario.getId() + " " + usuario.getNombre());
		});
	}
}
