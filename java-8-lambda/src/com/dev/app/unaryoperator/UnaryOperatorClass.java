package com.dev.app.unaryoperator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class UnaryOperatorClass {

	public static void main(String[] args) {
		/**
		 * 	In Java 8, UnaryOperator is a functional interface and it extends Function.
		 	The UnaryOperator takes one argument, and returns a result of the same type of its arguments.
		 	
		 		@FunctionalInterface
				public interface UnaryOperator<T> extends Function<T, T> {
				
				}
				
			The Function takes one argument of any type and returns a result of any type.
				
				@FunctionalInterface
				public interface Function<T, R> {
    				R apply(T t);
				}
		 */
		Function<Integer, Integer> function = (x) -> x * 2;
		Integer result = function.apply(2);
		System.out.println(result);
		
		UnaryOperator<Integer> unaryFunction = x -> x * 2;
		Integer resultInteger = unaryFunction.apply(2);
		System.out.println(resultInteger);
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		UnaryOperator<Integer> unaryOperator = (x) -> x * 2;
		
		UnaryOperator<Integer> unaryOperator2 = (x) -> x + 1;
		
		UnaryOperator<Integer> unaryOperator3 = (x) -> x + 5;
		
		List<Integer> resultList = math(list, unaryOperator);
		System.out.println(resultList);
		
		List<Integer> resulList2 = math(list, unaryOperator, unaryOperator2);
		System.out.println(resulList2);
		
		List<Integer> resulList3 = math(list, unaryOperator3);
		System.out.println(resulList3);
	}
	
	static <T> List<T> math(List<T> list, UnaryOperator<T> unaryOperator) {
		List<T> resulList = list.stream()
						.map(unaryOperator::apply)
						.collect(Collectors.toList());
		return resulList;
	}
	
	static <T> List<T> math(List<T> list, UnaryOperator<T> unaryOperator1, UnaryOperator<T> unaryOperator2) {
		List<T> resultList = list.stream()
						.map(unaryOperator1.andThen(unaryOperator2)::apply)
						.collect(Collectors.toList());
		return resultList;
	}
}
