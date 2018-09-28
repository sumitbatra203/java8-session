package com.sumit.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaOne {
	static List<Employee> ls=new ArrayList<>();
	
	static{
		Employee emp1=new Employee(101, 1000, 21,"TEST1");
		Employee emp2=new Employee(102, 2000, 21,"TEST2");
		Employee emp3=new Employee(103, 3000, 20,"TEST3");
		Employee emp4=new Employee(104, 4000, 23,"TEST4");
		Employee emp5=new Employee(105, 5000, 24,"TEST5");
		ls.add(emp1);
		ls.add(emp2);
		ls.add(emp3);
		ls.add(emp4);
		ls.add(emp5);
	}
	
	public static void main(String[] args) {
		
		System.out.println("without lambda");
		printEmployeeWithoutLambda();
		
		System.out.println("with lambda");
		ls.forEach((emp)->System.out.println(emp));
		
		System.out.println("===salary more than 2000====");
		List<Employee> moreThanTwoThousand=getEmployeesMoreThanTwoThousand();
		printEmployee(moreThanTwoThousand);
		System.out.println("===========================");
		
		
		System.out.println("===salary more than 2000 and less than 4000====");
		List<Employee> moreThanTwoLessThanFourThousand=getEmployeesMoreThanTwoLessThanFourThousand();
		printEmployee(moreThanTwoLessThanFourThousand);
		System.out.println("===========================");
		
		System.out.println("===========Behaviour Parameterization================");
		
		System.out.println("===Age Condition===");
		List<Employee> conditionOneList=getEmployeeBasedOnCondition(ls,new AgeCondition());
		printEmployee(conditionOneList);
		System.out.println("===========================");
		System.out.println("===========================");
		
		System.out.println("===Salary Condition===");
		List<Employee> conditionTwoList=getEmployeeBasedOnCondition(ls,new SalaryCondition());
		printEmployee(conditionTwoList);
		System.out.println("===========================");
		System.out.println("===========================");
		
		System.out.println("===========Using Anonymous Class Behaviour Parameterization================");
		List<Employee> conditionThreeList=getEmployeeBasedOnCondition(ls,new Condition(){
			@Override
			public boolean test(Employee emp) {
				return emp.sal>3000 && emp.sal<5000;
			}
		});
		printEmployee(conditionThreeList);
		System.out.println("===========Ends Anonymous Class Behaviour Parameterization================");
		
		System.out.println("===========================");
		System.out.println("===========================");
		
		System.out.println("===========Using Lambda================");
		List<Employee> conditionFourList=getEmployeeBasedOnCondition(ls,emp->emp.sal<=3000);
		printEmployee(conditionFourList);
		System.out.println("===========Using Lambda Second================");
		List<Employee> conditionFiveList=getEmployeeBasedOnCondition(ls,emp->emp.sal<=4000);
		printEmployee(conditionFiveList);
		
		System.out.println("===========Using Lambda Third================");
		ls.stream().filter(emp->emp.sal<=4000).forEach(emp->System.out.println(emp));
		
		System.out.println("===========Using Lambda Four================");
		ls.sort((emp1,emp2)->Integer.compare(emp1.age, emp2.age));
		printEmployee(ls);
	}

	private static void printEmployeeWithoutLambda() {
		for(Employee emp:ls){
			System.out.println(emp);
		}
	}

	
	private static List<Employee> getEmployeesMoreThanTwoThousand(){
		List<Employee> list=new ArrayList<>();
		for(Employee emp:ls){
		if(emp.sal>2000){
			list.add(emp);
		}
		}
		return list;
	}
	
	
	private static List<Employee> getEmployeesMoreThanTwoLessThanFourThousand(){
		List<Employee> list=new ArrayList<>();
		for(Employee emp:ls){
		if(emp.sal>2000 && emp.sal<4000){
			list.add(emp);
		}
		}
		return list;
	}
	
	private static void printEmployee(List<Employee> list){
		for(Employee emp:list){
			System.out.println(emp);
		}
	}
	
	
	private static List<Employee> getEmployeeBasedOnCondition(List<Employee> inputList,Condition condition){
		List<Employee> outPutList=new ArrayList<>();
		for(Employee emp:inputList){
			if(condition.test(emp)){
				outPutList.add(emp);
			}
		}
		return outPutList;
	}
	
}

