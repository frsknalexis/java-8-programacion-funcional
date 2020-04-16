package com.dev.app.supplier;

import java.util.Date;
import java.util.function.Supplier;

public class SupplierClass2 {

	public static void main(String[] args) {
		//Supplier instance with lambda expression
		Supplier<String> helloStrSupplier = () -> new String("hello");
		String helloString = helloStrSupplier.get();
		
		System.out.println("String in helloStr is->" + helloString + "<-");
		
		//Supplier instance using method reference to default constructor
		Supplier<String> emptyStrSupplier = () -> "";
		String emptyString = emptyStrSupplier.get();
		
		System.out.println("String in emptyStr is->" + emptyString + "<-");
		
		//Supplier instance using method reference to a static method
		Supplier<Date> dateSupplier = SupplierClass2::getSystemDate;
		Date systemDate = dateSupplier.get();
		
		System.out.println("systemDate->" + systemDate);
	}
	
	static Date getSystemDate() {
		return new Date();
	}
}
