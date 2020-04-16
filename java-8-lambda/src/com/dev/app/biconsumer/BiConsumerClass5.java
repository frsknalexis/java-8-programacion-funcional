package com.dev.app.biconsumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerClass5 {

	public static void main(String[] aegs) {
		BiConsumer<String, HashMap<Integer, String>> biConsumerHashMap = (s, map) -> {
			if (!map.containsValue(s)) {
				map.put(2, s);
			}
			System.out.println(map);
		};
		
		HashMap <Integer, String> hashMap = new HashMap <Integer, String> ();
        hashMap.put(1, "Isha");
        hashMap.put(3, "Noni");
        
        biConsumerHashMap.accept("Deepak", hashMap);
        
        BiConsumer<List<Integer>, List<Integer>> biConsumerList = (l1, l2) -> {
        	if (!l1.equals(l2)) {
        		System.out.println("Values of List 1:\n");
        		l1.stream().forEach(System.out::println);
        		
        		System.out.println("\nValues of List 2:\n");
        		l2.stream().forEach(System.out::println);
        	}
        };
        
        List <Integer> sampleList1 = new ArrayList<Integer>();
        
        sampleList1.add(3);
        sampleList1.add(44);
        sampleList1.add(91);
 
        List <Integer> sampleList2 = new ArrayList<Integer>();
 
        sampleList2.add(75);
        sampleList2.add(8);
        
        biConsumerList.accept(sampleList1, sampleList2);
        
        BiConsumer<String, Student> biConsumerStudent = (s, student) -> {
        	if (student.getName() != s) {
        		student.setName(s);
        		student.setAge(5);
        		 System.out.println("Newly added student details: \n" + "\nName: \n" + student.getName() + "\n\nAge:\n" + student.getAge());
        	} else {
        		System.out.println("Student with this name already exist.");
        	}
        };
        
        Student student = new Student(1, "Isha");
        biConsumerStudent.accept("Deepak", student);
        
        
        BiConsumer<String, String> biConsumerObj = (s1, s2) -> {
        	if (s1.length() == s2.length()) {
        		System.out.println("Both the strings are of equal length");
        	} else {
        		System.out.println("Both the strings are of unequal length");
        	}
        };
        
        biConsumerObj.andThen(biConsumerObj).accept("justanordinarywriter.com", "techndeck.com");
        
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
        BiConsumer <Integer, List<Integer>> updatedList = (i, l) -> {
        	for (int j = 0; j < l.size(); j++)
                l.set(j, i + l.get(j));
        };
        
        BiConsumer<Integer, List<Integer>> printList = (i, l) -> {
        	l.stream()
        		.forEach(System.out::println);
        };
       
        updatedList.andThen(printList).accept(10, list);
	}
}

class Student {
	int age;
	String name;
	
	public Student() {
		
	}
	
	public Student(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

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
}