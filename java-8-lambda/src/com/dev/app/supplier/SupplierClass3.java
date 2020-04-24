package com.dev.app.supplier;

import java.util.Objects;
import java.util.function.Supplier;

public class SupplierClass3 {

	public static void main(String[] args) {
		Supplier<String> string = () -> "java2s.com";
		
		System.out.println(string.get());
		
		SunPower power = new SunPower();
		
		Supplier<SunPower> supplier1 = () -> power;
		
		SunPower p1 = produce(supplier1);
		SunPower p2 = produce(supplier1);
		
		System.out.println("Check the same object?" + Objects.equals(p1, p2));
		
		Supplier<Employee> supplierEmployee = () -> new Employee();
		
		Employee result = maker(supplierEmployee);
		
		System.out.println(result);
	}
	
	static <T> T produce(Supplier<T> supplier) {
		return supplier.get();
	}
	
	static <T> T maker(Supplier<T> supplier) {
		return supplier.get();
	}
}

class SunPower {
	
	public SunPower() {
		System.out.println("Sun Power initialized..");
	}
}

class Employee {

	@Override
	public String toString() {
		return "A EMPLOYEE";
	}
}
