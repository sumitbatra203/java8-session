package com.sumit.java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTwo {

	public static void main(String[] args) {

		int number=10;
		Runnable r=new Runnable(){
			@Override
			public void run() {
				System.out.println("created from annonymous");				
			}
		};
		r.run();
		
		Runnable r2=()->System.out.println("created from lambda"+number);
		r2.run();
		//number=15;
		
		//T->void
		Consumer<String> consumer1=(str)->System.out.println("hello "+str);
		consumer1.accept("alan");
		
		Consumer<String> consumer2=(str)->System.out.println("hello again "+str);
		consumer1.andThen(consumer2).accept("people");
		
		
		Supplier<Employee> supplier=()->new Employee(101, 1000, 21,"Example2");
		System.out.println(supplier.get());
		
		
		Predicate<Employee> predicate=(Employee emp)->emp.age<22;
		System.out.println(predicate.test(supplier.get()));
		
		//IntSupplier,LongSupplier,DoubleSupplier,BooleanSupplier
		
		//chaining of lamda functions
		Function<Integer,Integer> f= x->x+1;
		Function<Integer,Integer> g= x->x*2;
		//g(f(x))
		Function<Integer,Integer> h=f.andThen(g);
		//f(g(x))
		//Function<Integer,Integer> h=f.compose(g);
		int result =h.apply(2);
		System.out.println(result);
	}
	
}
