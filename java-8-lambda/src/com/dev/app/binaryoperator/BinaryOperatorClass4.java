package com.dev.app.binaryoperator;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class BinaryOperatorClass4 {

	public static void main(String... args) {
		BinaryOperator<Integer> getSum = (a, b) -> a + b;
		BinaryOperator<Integer> getDifference = (a, b) -> a - b;
		BinaryOperator<Integer> getProduct = (a, b) -> a * b;
		
		System.out.println("Sum: " + getSum.apply(2, 3));
		System.out.println("Difference: " + getDifference.apply(2, 3));
		System.out.println("Product: " + getProduct.apply(2, 3));
		
		
		BinaryOperator<Person> getYoungerPerson = (p1, p2) -> {
			if (p1.getAge() > p2.getAge())
				return p2;
			else 
				return p1;
		};
		
		Person person1 = new Person("Kathy",34);
		Person person2 = new Person("Tom",23);
		
		Person youngerPerson = getYoungerPerson.apply(person1, person2);
		System.out.println("Younger Person : " + youngerPerson);
		
		BinaryOperator<Integer> getSum1 = (a, b) -> {
			System.out.println("Adding " + a + " and " + b + " ...");
			Integer sum = a + b;
			System.out.println("Sum :" + sum);
			return sum;
		};
		
		Function<Integer, Integer> getSquare = (i) -> {
			System.out.println("Squaring " + i + " ...");
			Integer square = i * i;
			System.out.println("Square: " + square);
			return square;
		};
		
		BiFunction<Integer, Integer, Integer> performCalculation = getSum1.andThen(getSquare);
		System.out.println("Final Result: " + performCalculation.apply(2, 3));
		
		BinaryOperator<Person> getMax = BinaryOperator.maxBy(Comparator.comparing(Person::getAge));
		
		Person persona1 = new Person("Tom",23);
		Person persona2 = new Person("Harry",29);
		
		Person maxPerson = getMax.apply(persona1, persona2);
		System.out.println("Person with higher age : " + maxPerson);
		
		BinaryOperator<Person> getMin = BinaryOperator.minBy(Comparator.comparing(Person::getAge));
		Person minPerson = getMin.apply(persona1, persona2);
		System.out.println("Person with lower age : " + minPerson);
	}
}

class Person {
	String name;
	Integer age;
	
	public Person() {
		
	}

	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}