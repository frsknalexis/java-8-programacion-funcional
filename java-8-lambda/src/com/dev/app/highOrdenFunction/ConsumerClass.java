package com.dev.app.highOrdenFunction;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerClass {

	public static void main(String[] args) {
		
		/*In Java 8, Consumer is a functional interface; it takes an argument and returns nothing.
		 * 
		 * 	@FunctionalInterface
			public interface Consumer<T> {
				void accept(T t);
			}
		 * 
		 */
		
		Consumer<String> print = (x) -> System.out.println(x);
		print.accept("Hello Java");
		
		List<Integer> listNumber = Arrays.asList(1, 2, 3, 4, 5);
		
		Consumer<Integer> consumer = (i) -> System.out.println(i);
		forEach(listNumber, consumer);
		
		//call this directly
		forEach(listNumber, (e) -> System.out.println(e));
		
		List<String> listString = Arrays.asList("a", "ab", "abc");
		
		forEach(listString, (s) -> System.out.println(s.length()));
	}
	
	static <T> void forEach(List<T> list, Consumer<T> consumer) {
		list.stream()
			.forEach(consumer::accept);
	}
}
