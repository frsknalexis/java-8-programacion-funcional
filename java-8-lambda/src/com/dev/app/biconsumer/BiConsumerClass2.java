package com.dev.app.biconsumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class BiConsumerClass2 {

	public static void main(String[] args) {
		
		BiConsumer<String, String> biConsumerString = BiConsumerClass2::concatAtPrint;
		biConsumerString.accept("one", "two");
		
		List<List<Integer>> list = Arrays.asList(
					new ArrayList<>(Arrays.asList(1, 3)),
					new ArrayList<>(Arrays.asList(2, 4))
				);
		
		visitList(list, new Integer[]{10, 12}, Collections::addAll);
		System.out.println(list);
		
		visitList(list, 0, Collections::fill);
		System.out.println(list);
		
		List<String> listString = Arrays.asList("one", "|", "two");
		StringBuilder sb = visitList(listString, () -> new StringBuilder(), (x, y) -> y.append(x));
		System.out.println(sb.toString());
	}
	
	static <T,U> void concatAtPrint(T s1, U s2) {
		System.out.println(s1 + " | " + s2);
	}
	
	private static <T, U> void visitList(List<T> list, U userObject, BiConsumer<T, U> bc) {
        list.forEach(t -> bc.accept(t, userObject));
    }
	
	private static <T, U> U visitList(List<T> list, Supplier<U> supplier, BiConsumer<T, U> biConsumer) {
		U u = supplier.get();
		list.forEach((t) -> biConsumer.accept(t, u));
		return u;
	}
}
