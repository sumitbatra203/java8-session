package com.sumit.java8;

import java.util.Optional;

public class OptionalExample {
public static void main(String[] args) {
	Optional<String> optionalString=Optional.ofNullable("Hello");
	if(optionalString.isPresent()){
		System.out.println(optionalString.get());
	}
	
}
}
