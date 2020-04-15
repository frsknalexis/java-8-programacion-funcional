package com.dev.app.highOrdenFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerClass4 {
	
	// Consumer is a functional interface; it takes an argument and returns nothing.

	public static void main(String[] args) {
		
		System.out.println("=============example 1================");
		
		Consumer<String> c = (x) -> System.out.println(x.toLowerCase());
		c.accept("Java2s.com");
		
		System.out.println("=============example 2================");
		
		int x = 99;
		Consumer<Integer> myConsumer = (i) -> {
			System.out.println("x = " + x);
			System.out.println("i = " + i);
		};
		
		myConsumer.accept(x);
		
		System.out.println("=============example 3================");
		
		List<Student> students = Arrays.asList(
				new Student("John", 3),
	            new Student("Mark", 4)
	            );
			
		acceptAllEmployees(students, (e) -> System.out.println(e.name));
		acceptAllEmployees(students, (student) -> {
			student.gpa *= 1.5;
		});
		
		acceptAllEmployees(students, (e) -> System.out.println(e.name + " : " + e.gpa));
		
		System.out.println("=============example 4================");
		
		Consumer<String> consumer1 = System.out::println;
		consumer1.accept("John");
		
		Consumer<Integer> consumer2 = System.out::println;
		consumer2.accept(12);
		
		System.out.println("=============example 5================");
		
		List<Integer> list = new ArrayList<Integer>();  
        list.add(10);  
        list.add(20);  
        list.add(30);  
        list.add(40); 
        
        Consumer<List<Integer>> consumerList = (lista) -> {
        	int result = lista.stream()
        				.mapToInt(Integer::valueOf)
        				.sum();
        	System.out.println("Result sum of list values: " + result);
        };
		
        consumerList.accept(list);
        
        System.out.println("=============example 6================");
        Consumer<String> consumerString1 = (s) -> System.out.println(s + " World.");
        Consumer<String> consumerString2 = (s) -> System.out.println(s + " Java.");
        consumerString1.andThen(consumerString2).accept("Hello");
        
        System.out.println("=============example 7================");
        Consumer<String> consumerString = (s) -> System.out.println(s + "OK");
        consumerString.accept("TestConsumerAccept - ");
        Consumer<String> consumerStringAndThen = (s) -> System.out.println(s + "OK !");
        consumerString.andThen(consumerStringAndThen).accept("TestConsumerAfterThen - ");
	}
	
	static <T> void acceptAllEmployees(List<T> lista, Consumer<T> consumer) {
		lista.stream()
			.forEach(consumer::accept);
	}
}

class Student {
	public String name;
	public double gpa;
	
	public Student(String name, double gpa) {
		this.name = name;
		this.gpa = gpa;
	}
}
