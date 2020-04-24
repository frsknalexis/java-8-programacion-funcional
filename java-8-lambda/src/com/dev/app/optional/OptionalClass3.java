package com.dev.app.optional;

import java.util.Optional;

public class OptionalClass3 {

	public static void main(String...strings) {
		Optional<String> gender = Optional.of("MALE");
		Optional<String> emptyGender = Optional.empty();
		
		//Filter on Optional
		System.out.println(gender.filter((s) -> s.equals("male"))); 
		System.out.println(gender.filter((s) -> s.equalsIgnoreCase("MALE")));
		System.out.println(emptyGender.filter((s) -> s.equalsIgnoreCase("MALE")));
		
		if (gender.isPresent())
			System.out.println("Value available.");
		else 
			System.out.println("Value not available.");
		
		gender.ifPresent((g) -> System.out.println("In gender Option, value available."));
		emptyGender.ifPresent((g) -> System.out.println("In emptyGender Option, value available."));
		
		System.out.println(gender.orElse("<N/A>"));
		System.out.println(emptyGender.orElse("<N/A>"));
		
		System.out.println(gender.orElseGet(() -> "<N/A>"));
		System.out.println(emptyGender.orElseGet(() -> "<N/A>"));
		
		String[] words = new String[10];
		Optional<String> checkNull = Optional.ofNullable(words[5]);
		
		String word = "";
		if (checkNull.isPresent()) {
			word = words[5].toLowerCase();
			System.out.println(word);
		}
		else {
			System.out.println("Word is null");
		}
		
		String[] str = new String[5];
		str[2] = "Geeks Classes are coming soon";
		
		Optional<String> emptyString = Optional.empty();
		System.out.println(emptyString);
		
		Optional<String> value = Optional.of(str[2]);
		System.out.println(value);
		
		String[] stringArray = new String[5];
		stringArray[2] = "Geeks Classes are coming soon";
		
		Optional<String> optionalString = Optional.of(stringArray[2]);
		System.out.println(optionalString.get());
		
		System.out.println(optionalString.hashCode());
		
		System.out.println(optionalString.isPresent());
	}
}
