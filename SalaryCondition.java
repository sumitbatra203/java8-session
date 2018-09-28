package com.sumit.java8;

import java.util.List;

public class SalaryCondition implements Condition{

	@Override
	public boolean test(Employee emp) {
		return emp.sal>3000 && emp.sal<5000;
	}

}
