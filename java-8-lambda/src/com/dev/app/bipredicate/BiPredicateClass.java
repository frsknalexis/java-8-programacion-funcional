package com.dev.app.bipredicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class BiPredicateClass {

	/*
	 * In Java 8, BiPredicate is a functional interface, which accepts two arguments and returns a boolean, 
	 * basically this BiPredicate is same with the Predicate, instead, it takes 2 arguments for the test.
	 * 	
	 * 		@FunctionalInterface
			public interface BiPredicate<T, U> {
    			boolean test(T t, U u);
			}
	 * 
	 */
	public static void main(String[] args) {
		BiPredicate<String, Integer> filter = (x, y) -> {
			return x.length() == y;
		};
		
		boolean result = filter.test("alexis", 6);
		System.out.println(result);
		
		boolean result2 = filter.test("java", 10);
		System.out.println(result2);
		
		
		List<Domain> domains = Arrays.asList(new Domain("google.com", 1),
                new Domain("i-am-spammer.com", 10),
                new Domain("mkyong.com", 0),
                new Domain("microsoft.com", 2));
		
		BiPredicate<String, Integer> biPredicate = (domain, score) -> {
			return (domain.equalsIgnoreCase("google.com") || score == 0);
		};
			
		List<Domain> resultList = filterBadDomain(domains, biPredicate);
		System.out.println(resultList);
		
		
		List<Domain> resultList2 = filterBadDomain(domains, (d, s) -> s == 0);
		System.out.println(resultList2);
		
		List<Domain> resultList3 = filterBadDomain(domains, (d, s) -> d.startsWith("i") && s > 5);
		System.out.println(resultList3);
		
		List<Domain> resultList4 = filterBadDomain(domains, biPredicate.or((d, s) -> d.equalsIgnoreCase("microsoft.com")));
		System.out.println(resultList4);
	}
	
	static <T extends Domain> List<T> filterBadDomain(List<T> list, BiPredicate<String, Integer> biPredicate) {
		return list.stream()
				.filter((x) -> biPredicate.test(x.getName(), x.getScore()))
				.collect(Collectors.toList());
	}
}

class Domain {
	String name;
	Integer score;
	
	public Domain() {
		
	}

	public Domain(String name, Integer score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Domain [name=" + name + ", score=" + score + "]";
	}
}