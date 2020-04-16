package com.dev.app.supplier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class SupplierClass4 {

	public static void main(String[] args) {
	
		Supplier<String> simpleString = () -> "Hello Basic Supplier";
		System.out.println(simpleString.get());
		
		Map<Integer, String> personaMap = new HashMap<Integer, String>();
		personaMap.put(19, "Isha");
		personaMap.put(43, "Guarangee");
		personaMap.put(4, "Yashika");
		
		Supplier<Map<Integer, String>> supplierMap = () -> personaMap;
		
		printValue(supplierMap);
		
		List<String> studentsNames = new ArrayList<String>();
		studentsNames.add("Yogi");
		studentsNames.add("Yash");
		studentsNames.add("Yashika");
		studentsNames.add("Pulkit");
				
		studentsNames.stream()
					.forEach((s) -> {
						printValue(() -> s);
					});
	}
	
	static <T> void printValue(Supplier<T> supplier) {
		System.out.println(supplier.get());
	}
}
