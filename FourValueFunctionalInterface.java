package com.sumit.java8;

@FunctionalInterface
public interface FourValueFunctionalInterface<A,B,C,D,R> {
	R apply(A a,B b,C c,D d);
}
