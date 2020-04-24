package com.dev.app.biconsumer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerClass {

	public static void main(String[] args) {
		
		/*In Java 8, BiConsumer is a functional interface; it takes two arguments and returns nothing.
		 * 		@FunctionalInterface
		 * 		public interface BiConsumer<T, U> {
  					void accept(T t, U u);
				}
		 */
		// BiConsumer
		BiConsumer<Integer, Integer> biConsumerInteger = (x, y) -> System.out.println(x + y);
		biConsumerInteger.accept(1, 2);
		
		/*	Higher Order Function 
		   	This example accepts BiConsumer as an argument, create a generic addTwo to join two objects.
		*/
		
		BiConsumer<String, String> biConsumerString = (s1, s2) -> System.out.println(s1 + s2);
		
		addTwo(1, 2, biConsumerInteger);
		addTwo("Node", ".js", biConsumerString);
		
		math(1, 1, (x, y) -> System.out.println(x + y));
		math(1, 1, (x, y) -> System.out.println(x - y));
		math(1, 1, (x, y) -> System.out.println(x * y));
		math(1, 1, (x, y) -> System.out.println(x / y));
		
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();  
		map.put(1, "Java");
        map.put(2, "C++");
        map.put(3, "Rust");
        map.put(4, "JavaScript");
        map.put(5, "Go");
        
        map.forEach((k, v) -> System.out.println(k + " : " + v));
        
        BiConsumer<String, String> bc = (a, b) -> System.out.println(a + " | " + b);
        bc.accept("one", "two");
	}
	
	static <T, U> void addTwo(T a1, U a2, BiConsumer<T, U> biConsumer) {
		biConsumer.accept(a1, a2);
	}
	
	static <T, U> void math(T a1, U a2, BiConsumer<T, U> biConsumer) {
		biConsumer.accept(a1, a2);
	}
}
