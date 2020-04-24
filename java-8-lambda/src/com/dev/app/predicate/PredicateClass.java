package com.dev.app.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateClass {

	/*In Java 8, Predicate is a functional interface, which accepts an argument and returns a boolean. 
	 * Usually, it used to apply in a filter for a collection of objects.
	 */
	/*	@FunctionalInterface
		public interface Predicate<T> {
		boolean test(T t);
		}
	*/

	public static void main(String[] args) {
		//predicate in filter()
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		Predicate<Integer> predicate = (i) -> i > 5;
		
		List<Integer> collect = list.stream()
					.filter(predicate)
					.collect(Collectors.toList());
		System.out.println(collect);
		
		//predicate and() - Multiple filters
		
		collect = list.stream()
					.filter((x) -> {
						return x > 5 && x < 8;
					})
					.collect(Collectors.toList());
		System.out.println(collect);
		
		Predicate<Integer> predicate1 = (i) -> i > 5;
		Predicate<Integer> predicate2 = (i) -> i < 8;
		
		collect = list.stream()
					.filter(predicate1.and(predicate2))
					.collect(Collectors.toList());
		
		System.out.println(collect);
		
		//predicate or()
		
		List<String> listString = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");
		
		Predicate<String> lengthIs3 = s -> s.length() == 3;
		Predicate<String> startWithA = s -> s.startsWith("A");
		
		List<String> collectString = listString.stream()
								.filter(lengthIs3.or(startWithA))
								.collect(Collectors.toList());
		
		System.out.println(collectString);
		
		//predicate negate()
		collectString = listString.stream()
								.filter(startWithA.negate())
								.collect(Collectors.toList());
		
		System.out.println(collectString);
		
		//predicate test() in function (high order function)
		System.out.println(StringProcessor.filter(listString, startWithA));
		System.out.println(StringProcessor.filter(listString, startWithA.and(lengthIs3)));
		
		//predicate chaining
		Predicate<String> startWithA2 = (s) -> s.startsWith("a");
		Predicate<String> startWithM = (s) -> s.startsWith("m");
		boolean result = startWithA2.or(startWithM).test("mkyong");
		System.out.println(result);
		
		boolean result2 = startWithA2.and(lengthIs3).negate().test("abc");
		System.out.println(result2);
	}
}

class StringProcessor {
	static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
		return list.stream().filter(predicate::test).collect(Collectors.toList());
	}
}