package com.dev.app.optional;

import java.util.Optional;

public class OptionalClass2 {

	public static void main(String... args) {
		Optional<String> gender = Optional.of("MALE");
		String answer1 = "Yes";
		String answer2 = null;
		
		System.out.println("Non-Empty Optional:" + gender);
        System.out.println("Non-Empty Optional: Gender value : " + gender.get());
        System.out.println("Empty Optional: " + Optional.empty());

        System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(answer1));
        System.out.println("ofNullable on Empty Optional: " + Optional.ofNullable(answer2));
		
	    /**
	     * NullPointerException
	     * 
	     * System.out.println("ofNullable on Non-Empty Optional: " + Optional.of(answer2));
	     **/
		
		Optional<String> nonEmptyGender = Optional.of("male");
        Optional<String> emptyGender = Optional.empty();
        
        System.out.println("Non-Empty Optional:: " + nonEmptyGender.map(String::toUpperCase));
        System.out.println("Empty Optional    :: " + emptyGender.map(String::toUpperCase));
        
        Optional<Optional<String>> nonEmptyOptionalGender = Optional.of(Optional.of("male"));
        System.out.println("Optional value   :: " + nonEmptyOptionalGender);
        Optional<Optional<String>> optionalOfOptionalString = nonEmptyOptionalGender.map((g) -> g.map(String::toUpperCase));
        System.out.println("Optional.map     :: " + optionalOfOptionalString);
        System.out.println("Optional.flatMap :: " + nonEmptyOptionalGender.flatMap((ge) -> ge.map(String::toUpperCase)));
	}
}
