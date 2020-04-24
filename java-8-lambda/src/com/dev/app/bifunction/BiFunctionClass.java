package com.dev.app.bifunction;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionClass {

	public static void main(String[] args) {
		/**
		 * In Java 8, BiFunction is a functional interface; it takes two arguments and returns an object.
		 * 
		 * 		@FunctionalInterface
				public interface BiFunction<T, U, R> {
      				R apply(T t, U u);
				}
		 * 
		 * */
		BiFunction<Integer, Integer, Integer> biFunctionInteger = (x1, x2) -> x1 + x2;
		Integer resultInteger = biFunctionInteger.apply(2, 3);
		System.out.println(resultInteger);
		
		BiFunction<Integer, Integer, Double> biFunctionDouble = (i1, i2) -> Math.pow(i1, i2);
		Double resultDouble = biFunctionDouble.apply(2, 4);
		System.out.println(resultDouble);
		
		BiFunction<Integer, Integer, List<Integer>> biFunctionList = (x1, x2) -> Arrays.asList(x1, x2);
		List<Integer> resultList = biFunctionList.apply(2, 3);
		System.out.println(resultList);
		
		BiFunction<Integer, Integer, Double> biFunctionIntegerToDouble = (a1, a2) -> Math.pow(a1, a2);
		
		Function<Double, String> functionDoubleToString = String::valueOf;
		String result = biFunctionIntegerToDouble.andThen(functionDoubleToString).apply(2, 4);
		
		System.out.println("Result: " + result);
		
		String resultDoubleToString = powToString(2, 4, biFunctionIntegerToDouble, (d) -> "Result: " + String.valueOf(d));
		System.out.println(resultDoubleToString);
	}
	
	static <R> R powToString(Integer i1, Integer i2, BiFunction<Integer, Integer, Double> biFunction, 
								Function<Double, R> function) {
		return biFunction.andThen(function).apply(i1, i2);
	}
}
