package com.dev.app.bipredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class BiPredicateClass5 {

	public static void main(String[] args) {
		BiPredicate<Integer, List<Integer>> listPredicatesContainsSpecificInteger = (i, l) -> l.contains(i);
		
		List <Integer> list = new ArrayList<Integer>();	 
        list.add(19);
        list.add(4);
        list.add(83);
        list.add(5);
        list.add(63);
       
        checkIfValuePresentList(10, list, listPredicatesContainsSpecificInteger);
        
        BiPredicate<Integer, Employee> employeePredicate = (i, e) -> e.getAge() > i;
        
        Employee e1 = new Employee(15, "Tom");
        Employee e2 = new Employee(6, "Sam");
        Employee e3 = new Employee(88, "Mark");
        
        System.out.println("Age of First Employee greater than 33? : " + employeePredicate.test(33, e1));
        System.out.println("Age of Second Employee greater than 15? : " + employeePredicate.test(15, e2));
        System.out.println("Age of Third Employee greater than 45? : " + employeePredicate.test(45, e3));
	}
	
	static void checkIfValuePresentList(Integer i, List<Integer> list, BiPredicate<Integer, List<Integer>> biPredicate) {
		if (biPredicate.test(i, list)) {
			System.out.println("Success: List contains the expected value which is number " + i);
		} else {
			System.out.println("Failure: List doens't contains the expected value which is number " + i);
		}
	}
}

class Employee {
	int age;
    String name;
 
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
 
    public Employee(int age, String name) {
        this.age = age;
        this.name = name;
    }
    
    public Employee() {
    	
    }
}