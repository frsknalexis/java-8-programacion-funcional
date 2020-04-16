package com.dev.app.biconsumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerClass4 {

	public static void main(String[] args) {
		
		List<String> fruits = new ArrayList<>();
		fruits.add("apple");
		fruits.add("banana");
		fruits.add("orange");
		
		List<String> colors = new ArrayList<>();
		colors.add("Red");
		colors.add("yello");
		colors.add("orange");
		
		BiConsumer<List<String>, List<String>> same = (listFruits, listColors) -> {
			if (listFruits.stream().count() != listColors.stream().count()) {
				System.out.println("fruits names and colors count is not same");
			} else {
				System.out.println("fruits names and colors count is same");
			}
		};
		
		same.accept(fruits, colors);
		
		Map<Integer, String> values = new HashMap<>();
		values.put(1, "One");
		values.put(2, "Two");
		values.put(3, "Three");
		
		BiConsumer<Integer, String> consumerMap = (k, v) -> {
			System.out.println("key: " + k + " value: " + v);
			//values.put(4, "Four");
		};
		
		values.forEach(consumerMap);
		
		BiConsumer<String, String> concatenateBiConsumer = (s1, s2) -> System.out.println(s1 + " " + s2);
		concatenateBiConsumer.accept("Hello", "World");
		
		BiConsumer<List<String>, List<String>> secondBiConsumer = (list1, list2) -> {
			list1.stream().forEach(System.out::println);
			list2.stream().forEach(System.out::println);
		};
		
		same.andThen(secondBiConsumer).accept(fruits, colors);
		
		
		BiConsumer<Integer, Integer> biConsumerInteger = (a, b) -> System.out.println(a * b);
		biConsumerInteger.accept(10, 3);
	}
}
