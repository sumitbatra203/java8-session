package com.sumit.java8;

public class DefaultInterfaceExample  implements A,B{
	
public static void main(String[] args) {
new DefaultInterfaceExample().sayHello();	
}
}

interface A{
	default void sayHello(){
		System.out.println("called from A");
	}
}


interface B extends A{
	default void sayHello(){
		System.out.println("called from B");
	}
}

interface C{
	default void sayHello(){
		System.out.println("called from C");
	}	
}

class D implements A{
	public void sayHello(){
		System.out.println("called from D");
	}
}	

