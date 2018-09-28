package com.sumit.java8;

public class LambdaZero {
	
	public static void main(String[] args) {
		
		DemoInterface addition=new Add();
		int sum=addition.operate(10, 5);
		System.out.println(sum);
		
		DemoInterface sub=new DemoInterface(){
			@Override
			public int operate(int a, int b) {
				return a-b;
			}
		};
		int subResult=sub.operate(10,5);
		System.out.println(subResult);
		
		
		DemoInterface mul=(int a,int b)-> a*b;;
		System.out.println( mul.operate(5, 10));
		
		System.out.println("---behaviour paramertization---");
		operation(10,5,(a,b)->a*b);
		operation(10,5,(a,b)->a-b);
		operation(10,5,(a,b)->a/b);
		
	}
	
	static void  operation(int a,int b,DemoInterface demoInterface){
		System.out.println(demoInterface.operate(a, b));	
	}
	
}

class Add implements DemoInterface{
	@Override
	public int operate(int a, int b) {
		return a+b;
	}
}

interface DemoInterface{
	int operate(int a, int b);
}