package com.dev.app.function;

import java.util.function.Function;

public class FunctionClass5 {

	public static void main(String[] args) {
		Function<Integer, Integer> functionInteger = (i) -> i * 2;
		System.out.println(functionInteger.apply(5));
		
		Function<Integer, Integer> functionObj1 = (i) -> i * 10;
		Function<Integer, Integer> functionObj2 = (i) -> i / 2;
		
		//andThen operation	
		System.out.println(functionObj1.andThen(functionObj2).apply(4));
		
		//compose operation
		System.out.println(functionObj1.compose(functionObj2).apply(4));
		System.out.println(functionObj2.compose(functionObj1).apply(4));
	}
}
