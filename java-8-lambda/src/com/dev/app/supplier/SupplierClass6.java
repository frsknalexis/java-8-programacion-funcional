package com.dev.app.supplier;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierClass6<T> {

	public static void main(String[] args) {
		
		SupplierClass6<String> obj = new SupplierClass6<>();
		List<String> list = obj.supplier().get();
		System.out.println(list);
		
		Supplier<Developer> supplierDeveloper = Developer::new;
		
		Developer obj1 = factory(supplierDeveloper);
		Developer obj2 = factory(() -> new Developer("mkyong"));
		
		System.out.println(obj1);
		System.out.println(obj2);
	}
	
	Supplier<List<T>> supplier() {
		return ArrayList::new;
	}
	
	public static Developer factory(Supplier<? extends Developer> s) {

        Developer developer = s.get();
        if (developer.getName() == null || "".equals(developer.getName())) {
            developer.setName("default");
        }
        developer.setSalary(BigDecimal.ONE);
        developer.setStart(LocalDate.of(2017, 8, 8));

        return developer;

    }
}

class Developer {
	String name;
    BigDecimal salary;
    LocalDate start;
    
    public Developer() {
    	
    }
    
    public Developer(String name) {
    	this.name = name;
    }

    @Override
	public String toString() {
		return "Developer [name=" + name + ", salary=" + salary + ", start=" + start + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}
}
