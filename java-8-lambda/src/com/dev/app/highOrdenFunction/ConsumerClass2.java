package com.dev.app.highOrdenFunction;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerClass2 {

	public static void main(String[] args) {
		
		//Consumer to display a number
		Consumer<Integer> display = (i) -> {
			System.out.println(i);
		};
		
		display.accept(10);
		
		//Consumer to multiply 2 to every integer of a list
	
		
		Consumer<List<Integer>> modifyList = (list) -> {
			list.stream()
				.map((i) -> i * 2);
		};
		
		Consumer<List<Integer>> displayList = (list) -> {
			list.stream()
				.forEach(System.out::println);
		};
		
		List<Integer> listInteger = Arrays.asList(1, 2, 3);
	
		modifyList.accept(listInteger);
		displayList.accept(listInteger);
		
		// other operation
		modifyList.andThen(displayList).accept(listInteger);
	}
}
