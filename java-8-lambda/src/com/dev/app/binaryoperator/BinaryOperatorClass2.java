package com.dev.app.binaryoperator;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class BinaryOperatorClass2 {

	public static void main(String... args) {
		BinaryOperator<Integer> operator1 = (a, b) -> a + b;
		System.out.println(operator1.apply(5, 7));
		
		BinaryOperator<String> operatorString = (s1, s2) -> s1 + s2;
		System.out.println(operatorString.apply("Hello ", "BORAJI.COM"));
		
		Function<Integer, Integer> functionInteger = (n) -> n * 2;
		
		System.out.println(operator1.andThen(functionInteger).apply(1, 6));
		
		Comparator<Integer> comparator = Comparator.comparing(Integer::intValue);
		
		BinaryOperator<Integer> opMax = BinaryOperator.maxBy(comparator);
		System.out.println("Max: " + opMax.apply(5, 6));
		System.out.println("Max: " + opMax.apply(9, 6));
		
		BinaryOperator<Integer> opMin = BinaryOperator.minBy(comparator);
		System.out.println("Min: " + opMin.apply(5, 6));
		System.out.println("Min: " + opMin.apply(9, 6));
		
		BinaryOperator<Integer> op = BinaryOperator.maxBy((a, b) -> (a > b) ? 1 : ((a == b) ? 0 : -1));
		System.out.println(op.apply(98, 11));
		
		BinaryOperator<Integer> op2 = BinaryOperator.minBy((a, b) -> (a > b) ? 1 : ((a == b) ? 0 : -1));
		System.out.println(op2.apply(98, 11));
		
		BinaryOperator<Integer> binaryOperatorObj = (i1, i2) -> i1 * i2;
		Function<Integer, Integer> functionObj = (i) -> i / 2;
		
		System.out.println("Result of multiplication of (10,5) and then divided by 2 is: " + binaryOperatorObj.andThen(functionObj).apply(10, 5));
	}
}
