package com.dev.app.binaryoperator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class BinaryOperatorClass3 {

	public static void main(String[] args) {
		
		BinaryOperator<Integer> sumOfSquare = BinaryOperatorClass3::getSquareSum;
		Integer resultInteger = sumOfSquare.apply(3, 4);
		System.out.println(resultInteger);
		
		List<Double> doubles = Arrays.asList(1d, 3d, 5d, 7d);
		
		List<Double> resulList = transformList(doubles, 3d, Math::pow);
		System.out.println(resulList);
		
		List<BigDecimal> bigDecimals = Arrays.asList(BigDecimal.valueOf(1), BigDecimal.valueOf(3),
                BigDecimal.valueOf(5), BigDecimal.valueOf(7));
		
		List<BigDecimal> resulList2 = transformList(bigDecimals, BigDecimal.TEN, BigDecimal::add);
		System.out.println(resulList2);
		
		List<String> cars = Arrays.asList("cadillac", "chrysler", "ferrari");
		String s = "I drive a ferrari car";
		List<String> stringList = transformList(cars, "ford", s::replaceAll);
		System.out.println(stringList);
		
		List<Integer> intList = Arrays.asList(1, 2, 3, 4);
		
		BinaryOperator<Integer> binaryOperator = Integer::sum;
		
		resultInteger = intList.stream()
								.reduce(binaryOperator)
								.orElse(null);
		System.out.println(resultInteger);
	}
	
	static Integer getSquareSum(Integer a, Integer b) {
		return a * a + b * b;
	}
	
	static <T> List<T> transformList(List<T> list, T tObject, BinaryOperator<T> binaryOperator) {
		List<T> resultList = list.stream()
						.map((t) -> binaryOperator.apply(t, tObject))
						.collect(Collectors.toList());

		return resultList;
	}
}
