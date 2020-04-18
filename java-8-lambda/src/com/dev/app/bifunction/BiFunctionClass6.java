package com.dev.app.bifunction;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BiFunctionClass6 {

	public static void main(String[] args) {
		BiFunction<Integer, Number, String> integerAdder = (integer, number) -> {
			return Double.toString(number.doubleValue() + integer);
		};
		
		String stringResult = integerAdder.apply(10, new BigDecimal("1.1"));
		System.out.println(stringResult);
		
		BiFunction<Integer, Number, String> integerAdder2 = BiFunctionClass6::addIntegerToNumber;
		String resultString = integerAdder2.apply(11, Double.valueOf(1.9));
		System.out.println(resultString);
		
		List<Integer> list = Arrays.asList(1, 4, 5, 8, 11);
		
		List<Integer> compareList = getAnotherList(list, 5, Integer::compareTo);
		System.out.println(compareList);
		
		List<String> unsignedStringList = getAnotherList(list, 2, Integer::toUnsignedString);
		System.out.println(unsignedStringList);
		
		List<Integer> exactsList = getAnotherList(list, 3, Math::addExact);
		System.out.println(exactsList);
		
		List<Integer> multiplesList = getAnotherList(list, 2, Math::multiplyExact);
		System.out.println(multiplesList);
		
		List<Boolean> booleanList = getAnotherList(list, 5, Integer::equals);
		System.out.println(booleanList);
		
		List<String> fruits = Arrays.asList("Apple", "Banana", "Orange");
		List<String> substringsList = getAnotherList(fruits, 2, String::substring);
		System.out.println(substringsList);
		
		List<Integer> indexesList = getAnotherList(fruits, "a", String::indexOf);
		System.out.println(indexesList);
		
		BiFunction<String, Integer, Integer> biFunction1 = (s, i) -> {
			if (s != null && i != null) {
				if (s.equalsIgnoreCase("Manager") && i > 30) {
					return 1000000;
				} else if(s.equalsIgnoreCase("Developer") && i > 25) {
					return 100000;
				} else {
					return 0;
				}
			} else {
				return 0;
			}
		};
		
		Integer salary = biFunction1.apply("Manager", 30);
		System.out.println(salary);
		salary = biFunction1.apply("Developer", 28);
		System.out.println(salary);
		
		Function<Integer, String> function = (i) -> {
			if (i >= 1000000)
				return "Band 5";
			else if(i >= 100000)
				return "Band 4";
			else
				return "Band 3";
		};
		
		String band = biFunction1.andThen(function).apply("Manager", 30);
		System.out.println(band);
		
		BiFunction<String, String, String> f2 = String::concat;
		Function<String, Integer> f1 = String::length;
		System.out.println(f2.andThen(f1).apply("TopJavaTutorial", ".com"));
	}
	
	static String  addIntegerToNumber(Integer i, Number n) {
		return Double.toString(n.doubleValue() + i);
	}
	
	static <T, U, R> List<R> getAnotherList(List<T> list, U u, BiFunction<T, U, R> biFunction) {
		List<R> resultList = list.stream()
						.map((t) -> biFunction.apply(t, u))
						.collect(Collectors.toList());
		return resultList;
						
	}
}
