package com.dev.app.function;

import java.util.function.Function;

public class FunctionClass4 {

	public static void main(String[] args) {
		
		Function<Integer, Double> functionSqrt = Math::sqrt;
		System.out.println("Square root of 49: " + functionSqrt.apply(49));
		System.out.println("Square root of 68: " + functionSqrt.apply(68));
		
		Function<Double, Double> functionDouble = (d) -> d * 2.0;
		
		Double result = functionSqrt.andThen(functionDouble).apply(30);
		System.out.println("Result with AndThen: " + result);
		
		Double result2 = functionDouble.compose(functionSqrt).apply(30);
		System.out.println("Result with Compose: " + result2);
		
		Function<Integer, Integer> f1 = (i) -> i * 4;
		System.out.println(f1.apply(3));
		
		Function<Integer, Integer> f2 = (i) -> i + 4;
		System.out.println(f2.apply(3));
		
		Function<String, Integer> f3 = (s) -> s.length();
		System.out.println(f3.apply("Peter"));
		
		Integer resultInteger = f2.compose(f1).apply(3);
		System.out.println(resultInteger);
		
		Integer j1 = f1.apply(3);
		Integer j2 = f2.apply(j1);
		System.out.println(j2);
		
		resultInteger = f2.andThen(f1).apply(3);
		System.out.println(resultInteger);
		
		j1 = f2.apply(3);
		j2 = f1.apply(j1);
		System.out.println(j2);
		
		System.out.println(Function.identity().apply(10));
		System.out.println(Function.identity().apply("Peter"));
	}
}
