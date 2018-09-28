package com.sumit.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaThree {
	public static void main(String[] args) {
		String[] strArr={"abc","abcd","abcde","abcfedf","abdledff"};
		//normal way
		
		HashMap<String,Integer> hs=new HashMap<>();
		for(String str:strArr){
		hs.put(str, str.length());	
		}
		System.out.println(hs);

		HashMap<String,Integer> hsLamda=new HashMap<>();
		//map example
		
		//method reference
		Stream.of(strArr).forEach(System.out::println);
		
		List<String> str = Arrays.asList("a","b","A","B");
		str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
		System.out.println(str);

		str.sort(String::compareToIgnoreCase);
		System.out.println(str);
		
		
		//Constructor Reference
		Supplier<Employee> s=Employee::new;
		Employee emp=s.get();
		System.out.println(emp);
		
		FourValueFunctionalInterface<Integer,Integer,Integer,String,Employee> supplierForEmployee=Employee::new;
		Employee empWithValue=supplierForEmployee.apply(108,2000,22,"john");
		System.out.println(empWithValue);
		

		
		
	
	}
}
