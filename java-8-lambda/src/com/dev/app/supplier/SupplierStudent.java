package com.dev.app.supplier;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierStudent {

	public static void main(String[] args) {
		
		Supplier<Student> studentSupplier = () -> new Student(1, "Arpit", "M", 19);
		Student student = studentSupplier.get();
		
		System.out.println(student);
		
		/*
		 *	Stream's generate method returns an infinite sequential stream where supplier generates each element.
			Let’s say you want to generate 5 random numbers between 0 to 10. 
		 *
		 * public static<T> Stream<T> generate(Supplier<T> s)
		 * */
		
		Supplier<Integer> randomNumberSupplier = () -> new Random().nextInt(10);
		
		Stream.generate(randomNumberSupplier)
			.limit(5)
			.forEach(System.out::println);
	}
}
