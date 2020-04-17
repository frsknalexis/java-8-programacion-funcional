package com.dev.app.bipredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class BiPredicateClass6 {

	public static void main(String[] args) {
		BiPredicate<Integer, Integer> bi = (x, y) -> x > y;
		System.out.println(bi.test(2, 3));
		
		BiPredicate<Integer, Integer> biPredicate = (x, y) -> x / 2 == y; 
		
		boolean result = compare(10, 5, biPredicate);
		System.out.println("Compare result: " + result);
		
		
		BiPredicate<List<String>, String> checkIfInList = (list, s) -> {
			if (list.contains(s))
				return true;
			return false;
		};
		
		List<String> fruits = new ArrayList<String>();
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Orange");
		
		boolean isInList = checkIfInList.test(fruits, "Water Melon");
		System.out.println("Is Water Melon present in the List ? : "+isInList);
		
		System.out.println("Is Grapes present in the List ? : " + checkIfInList.test(fruits, "Grapes"));
		System.out.println("Is Apple present in the List ? : " + checkIfInList.test(fruits, "Apple"));
		
		BiPredicate<Person, Integer> isPersonAgeValid = (person, ageLimit) -> {
			if (person.getAge() <= ageLimit)
				return true;
			return false;
		};
		
		int ageLimit = 59;
		Person personObject1 = new Person("Tom",68);
		System.out.println("Is "+personObject1.getName()+"'s Age valid? "+isPersonAgeValid.test(personObject1, ageLimit));
		Person personObject2 = new Person("Mary",40);
		System.out.println("Is "+personObject2.getName()+"'s Age valid? "+isPersonAgeValid.test(personObject2, ageLimit));
		Person personObject3 = new Person("Mike",51);
		System.out.println("Is "+personObject3.getName()+"'s Age valid? "+isPersonAgeValid.test(personObject3, ageLimit));
	    Person personObject4 = new Person("Larry",35);
		System.out.println("Is "+personObject4.getName()+"'s Age valid? "+isPersonAgeValid.test(personObject4, ageLimit));
		
		BiPredicate<String, String> biPredicate1 = (s1, s2) -> s1.startsWith(s2);
		System.out.println(biPredicate1.test("TopJavaTutorial", "Top"));
		
		BiPredicate<Integer, Integer> biPredicateInteger1 = (i1, i2) -> i1 > i2;
		System.out.println(biPredicateInteger1.test(10, 5));
		System.out.println(biPredicateInteger1.negate().test(10, 5));
		
		BiPredicate<Integer, Integer> biPredicateInteger2 = (i1, i2) -> i1 * i1 > i2 * i2;
		System.out.println(biPredicateInteger1.test(10, 5));
		System.out.println(biPredicateInteger1.and(biPredicateInteger2).test(10, 5));
		System.out.println(biPredicateInteger1.and(biPredicateInteger2).test(-10, -5));
		
		System.out.println(biPredicateInteger1.or(biPredicateInteger2).test(10, 5));
		System.out.println(biPredicateInteger1.or(biPredicateInteger2).test(-10, -5));
	}
	
	public static <T, U> boolean compare(T t, U u, BiPredicate<T, U> biPredicate) {
		return biPredicate.test(t, u);
	}
}

class Person {
	
	String name;
	
	int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Person() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}