package com.dev.app.supplier;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

public class SupplierClass5 {

	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public static void main(String[] args) {
		
		Supplier<LocalDateTime> supplierDate = LocalDateTime::now;
		LocalDateTime time = supplierDate.get();
		
		System.out.println(time);
		
		Supplier<String> supplierDateToString = () -> dtf.format(LocalDateTime.now());
		String timeToString = supplierDateToString.get();
		
		System.out.println(timeToString);
	}
}
