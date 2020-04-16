package com.dev.app.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionClass2 {

	public static void main(String[] args) {
		
		Function<String, Integer> function = String::length;
		Integer applyFunction = function.apply("dev_alexis");
		System.out.println(applyFunction);
		
		/*
		 *	Chain Function<T, R>
			This example chains the Function with andThen().
		 * 
		 */
		
		Function<String, Integer> functionString = (s) -> s.length();
		Function<Integer, Integer> functionInteger = (i) -> i * 2;
		
		Integer result = functionString.andThen(functionInteger).apply("dev_alexis");
		System.out.println(result);
		
		List<Employee> employeeList= 
			     Arrays.asList(new Employee("Tom Jones", 45), 
			      new Employee("Harry Major", 25),
			      new Employee("Ethan Hardy", 65),
			      new Employee("Nancy Smith", 15),
			      new Employee("Deborah Sprightly", 29));
		
		Function<Employee, String> functionEmployeeToString = Employee::getNombre;
		
		List<String> resultList = convertListToNameList(employeeList, functionEmployeeToString);
		System.out.println(resultList);
		
		Function<String, String> initialFunction = (s) -> s.substring(0, 1);
		
		List<String> resulList2 = convertListToNameList(employeeList, functionEmployeeToString.andThen(initialFunction));
		System.out.println(resulList2);
		
		Function<Employee, Employee> functionEmployeeFirstName = (e) -> {
			int index = e.getNombre().indexOf(" ");
			String firstName = e.getNombre().substring(0, index);
			e.setNombre(firstName);
			return e;
		};
		
		List<String> resultList3 = convertListToNameList(employeeList, functionEmployeeToString.compose(functionEmployeeFirstName));
		System.out.println(resultList3);
		
		List<Employee> employeeListInitials = applyIdentityToEmployeeList(employeeList, Function.identity());
		System.out.println(employeeListInitials);
	}
	
	public static <T, R> List<R> convertListToNameList(List<T> list, Function<T, R> function) {
		List<R> result = list.stream()
							.map(function::apply)
							.collect(Collectors.toList());
		return result;
	}
	
	public static <T, R> List<R> applyIdentityToEmployeeList(List<T> list, Function<T, R> function) {
		List<R> result = list.stream()
					.map(function::apply)
					.collect(Collectors.toList());
		return result;
	}
}

class Employee {
	String nombre;
	Integer age;
	public Employee() {
	
	}
	
	public Employee(String nombre, Integer age) {
		this.nombre = nombre;
		this.age = age;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [nombre=" + nombre + ", age=" + age + "]";
	}
}