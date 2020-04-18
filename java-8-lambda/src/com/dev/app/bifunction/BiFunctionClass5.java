package com.dev.app.bifunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionClass5 {

	public static void main(String[] args) {
		BiFunction<String, String, String> biFunctionString = (s1, s2) -> s1 + s2;
		System.out.println(biFunctionString.apply("BORAJI", ".COM"));
		
		BiFunction<Integer, Integer, Integer> biFunctionInteger = (a, b) -> a + b;
		System.out.println(biFunctionInteger.apply(100, 200));
		
		Function<Integer, Integer> functionInteger = (i) -> i * i;
		
		System.out.println(biFunctionInteger.andThen(functionInteger).apply(5, 3));
		System.out.println(biFunctionInteger.andThen(functionInteger).apply(12, 2));
		
		String result = calculator(3, 5, (i1, i2) -> ": " + (i1 * i2));
		System.out.println(result);
		
		System.out.println("BiFunction Interface - 'andThen' example \n");
		
		BiFunction<Integer, Integer, Integer> biFunctionObj = (i1, i2) -> i1 * i2;
		Function<Integer, Integer> functionObj = (i) -> i / 2;
		System.out.println(biFunctionObj.andThen(functionObj).apply(10, 5));
	}
	
	static String calculator(Integer i1, Integer i2, BiFunction<Integer, Integer, String> biFunction) {
		return biFunction.apply(i1, i2);
	}
}
