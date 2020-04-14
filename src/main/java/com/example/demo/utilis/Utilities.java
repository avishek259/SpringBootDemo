package com.example.demo.utilis;

import com.example.demo.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Utilities {

    public static Function<List<Employee>, Optional<Double>> highestSalary = (empList)->empList.stream()
            .map(Employee::getSalary)
            .reduce((x,y)->x>y?x:y);

    public static BiFunction<Optional<Double>,List<Employee>,List<Employee>> findEmployeesWithHighestSalary = (highestSal,list)->list.parallelStream()
            .filter(emp->emp.getSalary().doubleValue()==highestSal.get().doubleValue()).collect(Collectors.toList());

    public static Function<List<Employee>,List<Employee>> sortedEmp = (list)->list.stream()
            .sorted(Comparator.comparing(Employee::getFirstName).reversed()).limit(1).collect(Collectors.toList());

    public static BiFunction<Optional<Double>,List<Employee>,List<Employee>> composedList = findEmployeesWithHighestSalary
            .andThen(sortedEmp);


}
