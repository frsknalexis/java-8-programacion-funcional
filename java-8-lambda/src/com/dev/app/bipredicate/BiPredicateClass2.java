package com.dev.app.bipredicate;

import java.util.function.BiPredicate;

public class BiPredicateClass2 {

	public static void main(String[] args) {
		BiPredicate<String, String> predicate = (s1, s2) -> s1.equals(s2);
		
		System.out.println(predicate.test("BORAJI", "BORAJI"));
		System.out.println(predicate.test("JAVA", "BORAJI"));
		
		BiPredicate<Long, Long> predicate1 = (x, y) -> x > y;
		BiPredicate<Long, Long> predicate2 = (x, y) -> x == y;
		
		boolean result = predicate1.and(predicate2).test(5l, 5l);
		System.out.println(result);
		
		boolean result1 = predicate1.or(predicate2).test(6l, 5l);
		System.out.println(result1);
		
		boolean result2 = predicate1.negate().test(8l, 1l);
		System.out.println(result2);
		
		System.out.println("============= ejemplo 2============");
		
		BiPredicate<Integer, String> biPredicate = (i, s) -> {
			if (i == Integer.valueOf(s))
				return true;
			return false;
		};
		System.out.println(biPredicate.test(2, "2"));
		
		BiPredicate<Integer, String> biPredicate1 = (i, s) -> {
			if (i > Integer.valueOf(s))
				return true;
			return false;
		};
		
		BiPredicate<Integer, String> biPredicate2 = biPredicate.and(biPredicate1);
		System.out.println(biPredicate2.test(2, "3"));
		
		biPredicate2 = biPredicate.or(biPredicate1);
		System.out.println(biPredicate2.test(3, "2"));
		
		biPredicate2 = biPredicate.negate();
		System.out.println(biPredicate2.test(3, "2"));
	}
}
