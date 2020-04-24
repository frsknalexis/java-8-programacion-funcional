package com.dev.app.collect;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamCollectTwo {

	public static void main(String[] args) {
		
		List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
		
		//collectors toList
		List<String> result = givenList.stream()
						.collect(Collectors.toList());
		
		System.out.println(result);
		
		//collectors toSet
		Set<String> resultSet = givenList.stream()
							.collect(Collectors.toSet());
		
		System.out.println(resultSet);
		
		//collectors toCollection
		List<String> resultCollection = givenList.stream()
									.collect(Collectors.toCollection(LinkedList::new));
		
		System.out.println(resultCollection);
		
		//collectors toMap
		Map<String, Integer> resultMap = givenList.stream()
							.collect(Collectors.toMap(Function.identity(), String::length));
		
		System.out.println(resultMap);
		
		Map<String, Integer> resultMap2 = givenList.stream()
				.collect(Collectors.toMap(Function.identity(), String::length, (item, identicalItem) -> item));
		
		System.out.println(resultMap2);
		
		//collectors collectingAndThen
		/*List<String> resultList = givenList.stream()
							.collect(collectingAndThen(Collectors.toList(), ImmutableList::copyOf));
		*/
		
		//collectors joining
		String resultString = givenList.stream()
								.collect(Collectors.joining());
		
		System.out.println(resultString);
		
		String resultString2 = givenList.stream()
								.collect(Collectors.joining(" "));
		
		System.out.println(resultString2);
		
		String resultString3 = givenList.stream()
								.collect(Collectors.joining(" ", "PRE-", "-POST"));
		
		System.out.println(resultString3);
		
		//collectors counting
		Long resultCount = givenList.stream()
								.collect(Collectors.counting());
		System.out.println("Tamaño de elementos given list: " + resultCount);
		
		//Collectors.summarizingDouble/Long/Int()
		IntSummaryStatistics resultStatistics = givenList.stream()
									.collect(Collectors.summarizingInt(String::length));
		
		System.out.println("Result statistics: " + resultStatistics.getAverage() + " " + resultStatistics.getCount() + 
				" " + resultStatistics.getMax() + " " + resultStatistics.getMin() + " " + resultStatistics.getSum());
		
		//Collectors.averagingDouble/Long/Int()
		Double resultAverage = givenList.stream()
								.collect(Collectors.averagingDouble(String::length));
		
		System.out.println("Average given list: " + resultAverage);
		
		//Collectors.summingDouble/Long/Int()
		Double resultSumming = givenList.stream()
								.collect(Collectors.summingDouble(String::length));
		
		System.out.println("Summing given list: " + resultSumming);
		
		//Collectors.maxBy()/minBy()
		Optional<String> resultStringOptional = givenList.stream()
									//.collect(Collectors.maxBy(Comparator.naturalOrder()));
									.collect(Collectors.maxBy(Comparator.comparing(String::length)));
		resultStringOptional.orElse("Default value");
		System.out.println(resultStringOptional.get());
		
		//Collectors.groupingBy()
		Map<Integer, Set<String>> resultMapGrouping = givenList.stream()
							.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
		
		System.out.println(resultMapGrouping.get(3));
		
		//Collectors.partitioningBy()
		Map<Boolean, List<String>> resultPartitioning = givenList.stream()
																.collect(Collectors.partitioningBy(s -> s.length() > 2));
		
		System.out.println(resultPartitioning);
		
		
		List<Integer> integerList = Arrays.asList(new Integer[] { 1, 2, 3, 4,
				  5, 6, 8, 9, 11, 13, 14, 15, 17, 18, 19, 20 });
		
		List<Integer> evenIntegers = integerList.stream()
								.filter((i) -> i % 2 == 0)
								.collect(Collectors.toList());
		
		System.out.println(evenIntegers);
		
		Map<String, List<Integer>> evenOddMap = integerList.stream()
								.collect(Collectors.groupingBy((i) -> (i % 2 == 0) ? "even" : "add"));
		
		System.out.println(evenOddMap);
		
		Map<String, List<Integer>> evenOddSquareMap = integerList.stream()
									.collect(Collectors.groupingBy((i) -> (i % 2 == 0) ? "even" : "odd", 
												Collectors.mapping((i) -> i * i, Collectors.toList())));
		
		System.out.println(evenOddSquareMap);
		
		Map<String, Integer> evenOddSumMap = integerList.stream()
									.collect(Collectors.groupingBy((i) -> (i % 2 == 0) ? "even" : "odd", 
											Collectors.reducing(0, (i1, i2) -> i1 + i2)));
		
		System.out.println(evenOddSumMap);
	}
}