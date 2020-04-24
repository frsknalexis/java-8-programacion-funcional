package com.dev.app.bipredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class BiPredicateClass3 {

	public static void main(String[] args) {
		BiPredicate<Integer, Integer> multiplePredicate = (a, b) -> a % b == 0;
		boolean b = multiplePredicate.test(72, 9);
		System.out.println(b);
		
		BiPredicate<Integer, Integer> biPredicateInteger = BiPredicateClass3::isMultipleOf;
		boolean result = biPredicateInteger.test(7847, 1121);
		System.out.println(result);
		
		
		List<Integer> list = Arrays.asList(1, 4, 5, 8, 11);
		
		List<Integer> listaInteger = searchList(list, 4, Integer::equals);
		System.out.println(listaInteger);
		
		List<String> cars = Arrays.asList("cadillac", "chrysler", "ferrari");
		BiPredicate<String, String> biPredicateString = (s1, s2) -> {
			return s1.startsWith(s2);
		};
		List<String> carList = searchList(cars, "c", biPredicateString);
		System.out.println(carList);
	}
	
	static boolean isMultipleOf(Integer t, Integer u) {
		return t % u == 0;
	}
	
	static <T, U> List<T> searchList(List<T> list, U u, BiPredicate<T, U> biPredicate) {
		return list.stream()
					.filter((t) -> biPredicate.test(t, u))
					.collect(Collectors.toList());
	}
}
