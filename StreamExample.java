package com.sumit.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
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
		
	//normal way to get list of names of all employee
	List<String> lsName=new ArrayList<>();
	for(Employee emp:ls){
		lsName.add(emp.getName());	
	}
	System.out.println(lsName);
	
	System.out.println("====Map of stream====");
	//using java8
	List<String> lsNameNew=ls.stream().map(emp->emp.getName()).collect(Collectors.toList());
	System.out.println(lsNameNew);
	

	System.out.println("====filter of stream====");
	//Filtering
	List<String> lsNameForEmplWithAgeLessThan24=ls.stream().filter(e->e.age<24).map(e->e.getName()).collect(Collectors.toList());
	System.out.println(lsNameForEmplWithAgeLessThan24);

	
	System.out.println("====Flattening of stream====");
	//flat map //unique characters
	ls.stream().map(emp->emp.getName().split(""))
			   .flatMap(t->Arrays.stream(t))
			   .distinct()
			   .forEach(System.out::print);

//	{ {1,2}, {3,4}, {5,6} } -> flatMap -> {1,2,3,4,5,6}	
 	 System.out.println();
	 String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"},{"a","d"}};
	 Arrays.stream(data).flatMap(Arrays::stream).filter(x->"a".equals(x)).forEach(System.out::print);
	 System.out.println();
	
	 System.out.println("====Reduce of stream====");
	 //reduce
	 int[] array={1,2,3,4,5,6,7,8};
	 OptionalInt opt=Arrays.stream(array).reduce(Integer::min);
	 System.out.println(opt.getAsInt());
	 //max
	 Arrays.stream(array).reduce(Integer::max).ifPresent(System.out::println);
	 
	 Arrays.stream(array).reduce((a,b)->Math.min(a, b)).ifPresent(System.out::println);
	 
	 System.out.println("====Sum of stream====");
	 System.out.println(IntStream.of(array).sum());
	 
	 
	 System.out.println("====Grouping of stream====");
	 Map<Object,List<Employee>> map= ls.stream().collect(Collectors.groupingBy((emp)->emp.sal<=4000));
	 System.out.println(map);
	 
	 System.out.println("====Grouping of stream====");
		Map<Object, List<Employee>> map2 = ls.stream().collect(
				Collectors.groupingBy((emp) -> {
					if (emp.sal <= 4000)
						return "Lower";
					else {
						return "Higher";
					}
				}));
	 System.out.println(map2);
	 System.out.println("====Grouping of stream====");
	 
		Map<Object, List<Employee>> map3 = ls.stream().collect(
				Collectors.groupingBy(StreamExample::getLevel));
		
		System.out.println(map3);
	 
	//infinite stream
	  System.out.println("====Infinite of stream====");
	  Stream.iterate(0, n -> n + 2)
	 .limit(10)
	 .forEach(System.out::println);
	

	  //fibonaci series
		Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] })
				.limit(5).forEach(t -> System.out.println(t[0] + "," + t[1]));
	  
	  //generate method
	   Stream.generate(Math::random)
	  .limit(5)
	  .forEach(System.out::println);				 
	
	   
	   
	}
	
	public static String getLevel(Employee emp){
		if (emp.sal <= 4000)
			return "Low";
		else {
			return "High";
		}	
	}
	
	
}

