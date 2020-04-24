package com.dev.app.function;

import java.util.function.Function;

public class FunctionClass3 {

	public static void main(String[] args) {
		
		Function<Integer, Double> half = (i) -> i / 2.0;
		Double result = half.apply(10);
		System.out.println(result);
		
		Function<Double, Double> multiply = (i) -> i * 3;
		
		Double result2 = half.andThen(multiply).apply(10);
		System.out.println(result2);
		
		Function<Integer, Double> function = half.compose((i) -> i * 3);
		Double result3 = function.apply(5);
		System.out.println(result3);
		
		Function<Integer, String> functiontoString = (t) -> {
			if (t % 2 == 0) {
				return t + " is even number";
			} else {
				return t + " is odd number";
			}
		};
		
		System.out.println(functiontoString.apply(5));
		System.out.println(functiontoString.apply(8));
		
		Function<Integer, Integer> function1 = (t) -> t - 5;
		Function<Integer, Integer> function2 = (t) -> t * 2;
		
		Integer a = function1.andThen(function2).apply(50);
		System.out.println(a);
		
		Integer c = function1.compose(function2).apply(50);
		System.out.println(c);
	
	}
}
