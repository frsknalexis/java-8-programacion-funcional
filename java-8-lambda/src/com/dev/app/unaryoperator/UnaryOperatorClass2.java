package com.dev.app.unaryoperator;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorClass2 {

	public static void main(String... args) {
		UnaryOperator<Boolean> uop = UnaryOperator.identity();
		System.out.println(uop.apply(true));
		
		UnaryOperator<Integer> xor = (i) -> i ^ 1;
		System.out.println(xor.apply(2));
		
		UnaryOperator<Integer> and = (i) -> i & 1;
		Function<Integer, Integer> compose = xor.andThen(and);
		System.out.println(compose.apply(2));
		
		Function<Integer, Integer> compose1 = xor.compose(and);
		System.out.println(compose1.apply(231));
		
		UnaryOperator<Integer> operator = (t) -> t * 2;
		System.out.println(operator.apply(5));
		System.out.println(operator.apply(10));
		System.out.println(operator.apply(15));
		
		UnaryOperator<Integer> operator1 = (x) -> x + 10;
		UnaryOperator<Integer> operator2 = (x) -> x * 10;
		
		Integer a = operator1.andThen(operator2).apply(5);
		System.out.println(a);
		
		Integer b = operator1.compose(operator2).apply(5);
		System.out.println(b);
		
		UnaryOperator<Integer> obj1 = (i) -> i * 5;
		System.out.println("Value of Obj 1: " + obj1.apply(5));
		
		UnaryOperator<String> obj2 = (s) -> s + "For Programmers & Entrepreneurs";
		System.out.println("Value of Obj 2: " + obj2.apply("Techndeck - "));
		
		UnaryOperator<Integer> up1 = (i) -> i * 5;
		UnaryOperator<Integer> up2 = (i) -> i + 5;
		System.out.println("Result: " + up1.andThen(up2).apply(4));
		
		System.out.println("Result: " + up1.compose(up2).apply(4));
		
		UnaryOperator<String> functionString = String::toUpperCase;
		System.out.println(functionString.apply("hello"));
	}
}
