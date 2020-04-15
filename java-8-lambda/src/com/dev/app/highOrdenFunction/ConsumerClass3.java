package com.dev.app.highOrdenFunction;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerClass3 {

	public static void main(String[] args) {
		
		
		Consumer<Integer> consumer = (i) -> System.out.println(" " + i);
		
		Consumer<Integer> consumerWithAndThen = consumer.andThen((i) -> System.out.println("(printed "+i+")"));
		
		List<Integer> integerList=Arrays.asList(new Integer(1), 
                new Integer(10), new Integer(200),
                new Integer(101), new Integer(-10),
                new Integer(0));
		
		printList(integerList, consumer);
		
		printList(integerList, consumerWithAndThen);
		
		Consumer<String> firstC = (x) -> System.out.println(x.toLowerCase());
		Consumer<String> secondC = (y) -> System.out.println(y.toUpperCase());
		
		Consumer<String> result = firstC.andThen(secondC);
		
		result.accept("Arpit");
	}
	
	static <T> void printList(List<T> list, Consumer<T> consumer) {
		list.stream()
			.forEach(consumer::accept);
	}
}
