package com.company.deutsche.sortEmployees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainEmployee {

    public static void main(String[] args){
        List<Employee> listE = new ArrayList<>(Arrays.asList(new Employee("1", "John", 214),
                new Employee("2", "Sheila", 654),new Employee("3", "Tom", 5678),
        new Employee("4", "Priya", 345)));

        //List<Employee> listE1 = listE.stream().sorted((o1, o2) -> o1.getSalary().compareTo(o2.getSalary())).collect(Collectors.toList());

        //List<Employee> listE1 = listE.stream().sorted((o1, o2) -> o2.getSalary() - o1.getSalary()).limit(3).collect(Collectors.toList());

        List<Employee> listE1 = listE.stream().sorted((o1, o2) -> o2.getSalary() - o1.getSalary()).skip(3).collect(Collectors.toList()); //skips to 3


        for (Employee e: listE1){
            System.out.println(e.toString());
        }
    }
}
