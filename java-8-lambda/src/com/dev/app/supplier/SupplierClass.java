package com.dev.app.supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierClass {

	public static void main(String[] args) {
	
		/*
		Supplier is functional interface which does not take any argument and produces result of type T
		.It has a functional method called T get()
		*/
		
		/*
		 *	@FunctionalInterface
			public interface Supplier<T> {
			/**
		 	* Gets a result.
		 	*
		 	* @return a result
		 	* T get();
			} 
		 * 
		 */
		System.out.println("E.g. #1 - Java8 Supplier Example\n");
		
		List<String> names = new ArrayList<String>();
		names.add("Harry");
		names.add("Daniel");
		names.add("Lucifer");		
		names.add("April O' Neil");
		
		names.stream()
			.forEach((s) -> {
				printNames(() -> s);
			});
		
		System.out.println("E.g. #2 - Java8 Supplier Example\n");
		
		Supplier<Double> randomValue = () -> Math.random();
		
		System.out.println(randomValue.get());
		
		System.out.println("E.g. #3 - Java8 Supplier Example\n");
		
		Supplier<String> supplierString = () -> "Arpit";
		System.out.println(supplierString.get());
	}
	
	static void printNames(Supplier<String> supplier) {
		System.out.println(supplier.get());
	}
}
