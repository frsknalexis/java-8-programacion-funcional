package com.dev.app.binaryoperator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

public class BinaryOperatorClass {

	public static void main(String... args) {
		/**
		 * 	In Java 8, BinaryOperator is a functional interface and it extends BiFunction.
			The BinaryOperator takes two arguments of the same type and returns a result of the same type of its arguments.
		 * 	
		 * 		@FunctionalInterface
				public interface BinaryOperator<T> extends BiFunction<T,T,T> {
				
				}
				
		 * 	The BiFunction takes two arguments of any type, and returns a result of any type.
		 * 
		 * 		@FunctionalInterface
				public interface BiFunction<T, U, R> {
      				R apply(T t, U u);
				}
		 * 
		 * */
		// BiFunction
		BiFunction<Integer, Integer, Integer> function = (x1, x2) -> x1 + x2;
		Integer resultInteger = function.apply(2, 3);
		System.out.println(resultInteger);
		
		//BinaryOperator
		BinaryOperator<Integer> binaryOperator = (x1, x2) -> x1 + x2;
		resultInteger = binaryOperator.apply(2, 3);
		System.out.println(resultInteger);
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		resultInteger = math(numbers, 0, binaryOperator);
		System.out.println(resultInteger);
		
		resultInteger = math(numbers, 0, Integer::sum);
		System.out.println(resultInteger);
			
		/**
		 *	IntBinaryOperator
			If the math operations involve primitive types like int, change to IntBinaryOperator for better performance.
		 * */
		IntBinaryOperator intBinaryOperator = (x1, x2) -> x1 + x2;
		resultInteger = mathInt(numbers, 0, intBinaryOperator);
		System.out.println(resultInteger);
		
		resultInteger = mathInt(numbers, 0, Integer::sum);
		System.out.println(resultInteger);
		
		/**
		 * 	BinaryOperator.maxBy() and BinaryOperator.minBy()
			This example uses BinaryOperator and a custom Comparator to find the highest and lowest 
			pay developer from a list of developers.
		 * 
		 * */
		Developer dev1 = new Developer("jordan", BigDecimal.valueOf(9999));
        Developer dev2 = new Developer("jack", BigDecimal.valueOf(8888));
        Developer dev3 = new Developer("jaden", BigDecimal.valueOf(10000));
        Developer dev4 = new Developer("ali", BigDecimal.valueOf(2000));
        Developer dev5 = new Developer("mkyong", BigDecimal.valueOf(1));

        List<Developer> list = Arrays.asList(dev1, dev2, dev3, dev4, dev5);
        
        Comparator<Developer> comparing = Comparator.comparing(Developer::getSalary);
        BinaryOperator<Developer> bio = BinaryOperator.maxBy(comparing);
        
		Developer developer = find(list, bio);
		System.out.println(developer);
		
		developer = find(list, BinaryOperator.maxBy(Comparator.comparing(Developer::getSalary)));
		System.out.println(developer);
		
		developer = find(list, BinaryOperator.minBy(Comparator.comparing(Developer::getSalary)));
		System.out.println(developer);
	}
	
	static <T> T math(List<T> list, T init, BinaryOperator<T> binaryOperator) {
		T result = list.stream()
					.reduce(init, binaryOperator::apply);
		return result;
	}
	
	static Integer mathInt(List<Integer> list, Integer init, IntBinaryOperator intBinaryOperator) {
		Integer result = list.stream()
					.reduce(init, intBinaryOperator::applyAsInt);
		return result;
	}
	
	static Developer find(List<Developer> list, BinaryOperator<Developer> binaryOperator) {
		
		Developer developer = list.stream()
								.reduce(binaryOperator::apply)
								.orElse(null);
		return developer;
	}
}

class Developer {
	String name;
	BigDecimal salary;
	
	public Developer() {
		
	}
	
	public Developer(String name, BigDecimal salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Developer [name=" + name + ", salary=" + salary + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
}