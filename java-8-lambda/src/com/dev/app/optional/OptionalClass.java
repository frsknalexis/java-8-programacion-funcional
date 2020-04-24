package com.dev.app.optional;

import java.util.Optional;

public class OptionalClass {

	public static void main(String... args) {
		
		Integer value1 = null;
		Integer value2 = new Integer(10);
		
		Optional<Integer> a = Optional.ofNullable(value1);
		Optional<Integer> b = Optional.of(value2);
		System.out.println(sumar(a, b));
	}
	
	static Integer sumar(Optional<Integer> a, Optional<Integer> b) {
		System.out.println("First parameter is present: " + a.isPresent());
	    System.out.println("Second parameter is present: " + b.isPresent());
	    
	    Integer value1 = a.orElse(new Integer(0));
	    Integer valu2 = b.get();
	    return value1 + valu2;
	}
}
