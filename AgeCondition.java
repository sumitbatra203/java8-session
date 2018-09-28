package com.sumit.java8;

public class AgeCondition implements Condition{

	@Override
	public boolean test(Employee emp) {
		return emp.age<24;
	}

}
