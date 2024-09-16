package com.company.java8;

import com.company.deutsche.sortEmployees.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RefactorIsPrime {

    public static boolean isPrime(int number){
        boolean isDivisible = false;

        for(int i=2; i<number; i++){
            if(number%i==0){
                isDivisible=true;
                break;
            }
        }

        return number>1 && !isDivisible;
    }

    public static void main(String[] args){
        boolean op = isPrime(2);
        System.out.println(op);

        List<Integer> l1 = Arrays.asList(2,1,3,6,4,7,8);

        //Stream s = l1.stream().filter(l -> l%2==0);
        //s.forEach(l -> System.out.println(l));
        l1.stream().filter(l -> l%2==0).forEach(l -> System.out.println(l));
        List<Integer> l2 = l1.stream().filter(l -> l%2==0).collect(Collectors.toList());
        System.out.println(l2);

        System.out.println("---------------------------------------");

        //map
        l1.stream().map(l -> l*l).forEach(j -> System.out.println(j));
        List<Integer> l3 = l1.stream().map(l -> l*l).collect(Collectors.toList());
        System.out.println(l3);
        System.out.println("---------------------------------------");

        //count
        long val = l1.stream().map(l -> l*l).count();
        System.out.println(val);
        System.out.println("---------------------------------------");

        //sort
        List<Integer> l4 = l1.stream().map(l -> l*l).sorted().collect(Collectors.toList());
        System.out.println(l4);
        System.out.println("---------------------------------------");

        List<Integer> l6 = l1.stream().map(l -> l*l).sorted((o1,o2) -> o1.compareTo(o2)).collect(Collectors.toList());
        System.out.println(l6);
        System.out.println("---------------------------------------");

        //sort desc using comparator
        List<Integer> l5 = l1.stream().map(l -> l*l).sorted((o1,o2) -> o2.compareTo(o1)).collect(Collectors.toList());
        System.out.println(l5);
        System.out.println("---------------------------------------");

        //min
        Integer val1 = l1.stream().map(l -> l*l).min((o1, o2) -> o1.compareTo(o2)).get();
        System.out.println(val1);
        System.out.println("---------------------------------------");

        //max
        Integer val2 = l1.stream().map(l -> l*l).max((o1, o2) -> o1.compareTo(o2)).get();
        System.out.println(val2);
        System.out.println("---------------------------------------");

        //toArray
        Object[] l7 = l1.stream().map(l -> l*l).sorted((o1,o2) -> o2.compareTo(o1)).toArray();
        for (Object i: l7)
            System.out.println(i);
        System.out.println("---------------------------------------");

        //of
        Stream.of(1,11,111).forEach(l -> System.out.println(l));
        System.out.println("---------------------------------------");

        List<Integer> l8 = Stream.of(1,11,111).toList();  //always immutable
        System.out.println(l8);
        System.out.println("---------------------------------------");

        List<Integer> l9 = Stream.of(1,11,111).collect(Collectors.toList());  //mutable ArrayList
        System.out.println(l9);
        System.out.println("---------------------------------------");

        Integer[] val3 = {1,11,111};
        List<Integer> l10 = Stream.of(val3).collect(Collectors.toList());  //mutable ArrayList
        System.out.println(l10);
        System.out.println("---------------------------------------");


        //get max salary of employee dept wise
        List<Employee> employeeList = new ArrayList<>(Arrays.asList(new Employee("1", "John", 214),
                new Employee("2", "Sheila", 654),new Employee("3", "Tom", 5678),
                new Employee("4", "Priya", 345)));


        //Map.Entry<String, Double> highestAvgSalary = employeeList.stream().collect(Collectors.groupingBy(
        //                Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary))
        //        .entrySet().stream()
        //        .max(Map.Entry.comparingByValue())
        //        .get();
        //Map.Entry<String, Double> highSal = employeeList.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.averagingDouble(Employee::getSalary)))
        //        .entrySet.stream().max(Map.Entry.comparingByValue()).get();

        //Map.Entry<String, List<Employee>> empByCity = employeeList.stream().collect(Collectors.groupingBy(Employee::getCity));

        /*
        Map<String, Long> noOfMaleAndFemaleEmployees = empList.stream().collect(Collectors.groupingBy
                        (Employee::getGender, Collectors.counting()));
        System.out.println("Count of male and female employees present in the organization:: \n" + noOfMaleAndFemaleEmployees);

        System.out.println("Names of all departments in the organization ");
        empList.stream().map(Employee::getDeptName).distinct().forEach(System.out::println);
                */



    }
}
