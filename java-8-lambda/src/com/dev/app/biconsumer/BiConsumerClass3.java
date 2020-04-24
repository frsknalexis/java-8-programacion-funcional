package com.dev.app.biconsumer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerClass3 {

	public static void main(String[] args) {
		BiConsumer<Integer, String> consumer = (a, b) -> System.out.println(a + b);
		consumer.accept(5, " Chapters");
		
		BiConsumer<Integer, Integer> addition = (a, b) -> System.out.println(a + b);
		
		BiConsumer<Integer, Integer> subtraction = (a, b) -> System.out.println(a - b);
		
		addition.andThen(subtraction).accept(10, 6);
		
		BiConsumer<String, Integer> biCon = BiConsumerClass3::showDetails;
		biCon.accept("Rama", 20);
		biCon.accept("Shyam", 25);
		
		BiConsumer<String, Integer> biCon2 = (s, i) -> System.out.println(s + " " + i);
		biCon2.accept("Peter", 28);
		
		Map<Integer, String> map = new HashMap<Integer,String>();  
        map.put(100, "Mohan");  
        map.put(110, "Sujeet");  
        map.put(115, "Tom");  
        map.put(120, "Danish");
        
        BiConsumer<Map<Integer, String>, String> biConsumerMap = BiConsumerClass3::showDetailsMap;
        biConsumerMap.accept(map, "Students");
	}
	
	static <T, U > void showDetails(T t, U u) {
		System.out.println(t + " " + u);
	}
	
	static void showDetailsMap(Map<Integer, String> map, String mapName) {
		System.out.println("-----------" + mapName + " records-------------");
		map.forEach((k, v) -> System.out.println(k + " " + v));
	}
}
