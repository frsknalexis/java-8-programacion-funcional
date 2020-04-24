package com.dev.app.function;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionClass {
	
	/*
	 * 	In Java 8, Function is a functional interface; it takes an argument (object of type T) and returns 
	 * 	an object (object of type R). The argument and output can be a different type.
	 * 
	 * 	@FunctionalInterface
		public interface Function<T, R> {
			R apply(T t);
		}
		
		
		@FunctionalInterface
		public interface Function<T, R> {
			R apply(T t);
    		default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
    			Objects.requireNonNull(before);
        		return (V v) -> apply(before.apply(v));
    		}
    		default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        		Objects.requireNonNull(after);
        		return (T t) -> after.apply(apply(t));
    		}
    		static <T> Function<T, T> identity() {
        		return t -> t;
    		}
}
	 * 	
	 */

	public static void main(String[] args) {
		
		FunctionClass fC = new FunctionClass();
		
		List<String> list = Arrays.asList("node", "c++", "java", "javascript");
		
		Function<String, Integer> function = String::length;
		
		Map<String, Integer> map = fC.convertListToMap(list, function);
		System.out.println(map);
		
		// using metod reference
		Function<String, Integer> functionToInteger = fC::getLength;
		Map<String, Integer> map2 = fC.convertListToMap(list, functionToInteger);
		System.out.println(map2);
	}
	
	public <T, R> Map<T, R> convertListToMap(List<T> list, Function<T, R> function) {
		
		Map<T, R> result = list.stream()
					.collect(Collectors.toMap(Function.identity(), function::apply));
		return result;
	}
	
	public Integer getLength(String str) {
		return str.length();
	}
}