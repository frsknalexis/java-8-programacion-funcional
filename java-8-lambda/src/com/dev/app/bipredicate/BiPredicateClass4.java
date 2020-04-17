package com.dev.app.bipredicate;

import java.util.function.BiPredicate;

public class BiPredicateClass4 {

	public static void main(String[] args) {
		BiPredicate<String, String> startsWith = String::startsWith;
		BiPredicate<String, String> biPredicate = startsWith.and(String::endsWith);
		boolean result = biPredicate.test("enough is enough", "enough");
		System.out.println(result);
		
		result = biPredicate.test("she is tall", "tall");
		System.out.println(result);
		
		BiPredicate<Integer, Integer> biPredicateInteger = (i1, i2) -> i1 == i2;
		System.out.println("Are numbers matching: " + biPredicateInteger.test(5, 10));
		
		BiPredicate<Integer, Integer> valuesNotMatching = (i1, i2) -> i1 != i2;
		BiPredicate<Integer, Integer> valueOneGreaterThanValueTwo = (i1, i2) -> i1 > i2;
		
		result = valuesNotMatching.and(valueOneGreaterThanValueTwo).test(5, 10);
		System.out.println(result);
		
		checkIfValueMatches(5, 10, biPredicateInteger);
		
		BiPredicate<String, String> startsWithSpecificString = (s1, s2) -> {
			return s1.startsWith(s2);
		};
		
		BiPredicate<String, String> containsSpecificString = (s1, s2) -> s1.contains(s2);
		result = startsWithSpecificString.or(containsSpecificString).test("isha durani", "ish");
		System.out.println("Result: " + result);
		
		BiPredicate<String, String> predicateStringEquals = (s1, s2) -> s1.equals(s2);
		BiPredicate<String, String> predicateNegate = predicateStringEquals.negate();
		System.out.println(predicateNegate.test("Hello Predicate", "Hello"));
	}
	
	private static void checkIfValueMatches(Integer i1, Integer i2, BiPredicate<Integer, Integer> bip) {
		System.out.println("Does value matching: " + bip.test(i1, i2));
	}
}
