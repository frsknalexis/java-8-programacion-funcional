package com.dev.app.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamCollect {

	/*
	 The syntax of Stream.collect() using supplier, accumulator, combiner is as follows.

	collect(Supplier supplier, BiConsumer accumulator, BiConsumer combiner)

	supplier : It creates a new result container which will be populated by accumulator and combiner and 
	finally it will be returned by collect() method. 
	In parallel processing the Supplier function will be called multiple times that will return fresh value each time.
	accumulator : It incorporates additional element into the result.
	combiner : It combines two values that must be compatible with accumulator. Combiner works in parallel processing.  
	 **/
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Mukesh", "Vishal", "Amar");
		
		String result = list.parallelStream()
							.collect(StringBuilder::new,
									(response, element) -> response.append(" ").append(element),
									(response1, response2) -> response1.append(",").append(response2.toString()))
							.toString();
		
		System.out.println("Result: " + result);
		
		List<Integer> lista = Arrays.asList(23, 43, 12, 25);
		
		IntSummaryStatistics stats = lista.stream()
					.collect(Collectors.summarizingInt((i) -> i + 1));
		
		System.out.println("Sum: " + stats.getSum());
		
		List<String> listaString = Arrays.asList("Ram","Shyam","Shiv","Mahesh");
		
		String stringResult = listaString.stream()
								.collect(Collectors.joining(","));
		
		System.out.println("Joining Result: " + stringResult);
		
		List<Integer> listaInteger = Arrays.asList(1,2,3,4);
		
		Double resultInteger = listaInteger.stream()
									.collect(Collectors.averagingInt((v) -> v*2));
		
		System.out.println("Average: " + resultInteger);
		
		List<Integer> listaCount = Arrays.asList(1,2,3,4);
		
		Long countResult = listaCount.stream()
								.collect(Collectors.counting());
		
		System.out.println("Count: " + countResult);
		
		String[] strArray = {"AA", "BB", "CC"};
		
		List<String> listaString2 = Arrays.stream(strArray).collect(Collectors.toList());
		
		listaString2.stream().forEach((e) -> System.out.println(e));
		
		List<Persona> listaPersona = new ArrayList<Persona>();
		listaPersona.add(new Persona(100, "Mohan"));
		listaPersona.add(new Persona(200, "Sohan"));
		listaPersona.add(new Persona(300, "Mahesh"));
		
		Map<Integer, String> mapPersona = listaPersona.stream()
								.collect(Collectors.toMap(Persona::getId, Persona::getName));
		
		mapPersona.forEach((x, y) -> System.out.println("Key: " + x + ", value: " + y));
		
		List<String> listOfString = Arrays.asList("Java", "C", "C++", "Go",
		        "JavaScript", "Python", "Scala");

		System.out.println("input list of String: " + listOfString);

		// Example 1 - converting Stream to List using collect() method
		
		List<String> listOfStringStartsWithJ = listOfString.stream()
											.filter((s) -> s.startsWith("J"))
											.collect(Collectors.toList());
		
		System.out.println("list of String starts with letter J: "
		        + listOfStringStartsWithJ);
		
		// Example 2 - converting Stream to Set

		Set<String> setOfStringStartsWithC = listOfString.stream()
											.filter((s) -> s.startsWith("C"))
											.collect(Collectors.toSet());

		System.out.println("set of String starts with letter C: "
		        + setOfStringStartsWithC);

		// Example 3 - converting Stream to Map
		
		Map<String, Integer> stringToMap = listOfString.stream()
								.collect(Collectors.toMap(Function.identity(), String::length));
		
		System.out.println("map of string and their length: " + stringToMap);
		
		// Example - Converting Stream to Collection e.g. ArrayList

		ArrayList<String> stringWithLengthGreaterThanTwo = listOfString.stream()
													.filter((s) -> s.length() > 2)
													.collect(Collectors.toCollection(ArrayList::new));

		System.out.println("collection of String with length greather than 2: "
		        + stringWithLengthGreaterThanTwo);
		
		List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
		
		List<Integer> even = numbers.stream()
					.map(Integer::valueOf)
					.filter((i) -> i % 2 == 0)
					.collect(Collectors.toList());
		
		System.out.println("processed list, only even numbers: " + even);

	}
}
