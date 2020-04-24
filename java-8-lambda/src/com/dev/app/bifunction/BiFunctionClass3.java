package com.dev.app.bifunction;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class BiFunctionClass3 {

	public static void main(String[] args) {
		
		
		List<String> list = Arrays.asList("node", "c++", "java", "javascript");
		
		BiFunction<String, Integer, String> biFunctionString = BiFunctionClass3::filterByLength;
		List<String> resultList = filterList(list, 3, biFunctionString);
		System.out.println(resultList);
		
		List<String> resultList1 = filterList(list, 3, (s, i) -> s.length() > i ? s: null);
		System.out.println(resultList1);
		
		List<String> resultList2 = filterList(list, "c", (s, c) -> s.startsWith(c) ? s : null);
		System.out.println(resultList2);
		
		List<Integer> number = Arrays.asList(1, 2, 3, 4, 5);
		
		List<Integer> resultListInteger = filterList(number, 2, (i, c) -> i % c == 0 ? i : null);
		System.out.println(resultListInteger);
	}
	
	static String filterByLength(String s, Integer size) {
		if (s.length() > size)
			return s;
		return null;
	}
	
	static <T, U, R> List<R> filterList(List<T> list, U condition, BiFunction<T, U, R> biFunction) {
		List<R> resultList = list.stream()
						.map((t) -> biFunction.apply(t, condition))
						.filter((e) -> e != null)
						.collect(Collectors.toList());
		return resultList;
	}
}
