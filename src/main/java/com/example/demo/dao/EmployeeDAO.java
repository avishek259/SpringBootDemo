package com.example.demo.dao;

import com.example.demo.model.Employee;
import com.example.demo.utilis.Utilities;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class EmployeeDAO {
    private static List<Employee> list = new ArrayList<>();

    static {
        list.add(new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com",3500.00));
        list.add(new Employee(2, "Alex", "Kolenchiskey", "abc@gmail.com",1000.00));
        list.add(new Employee(3, "David", "Kameron", "titanic@gmail.com",7000.50));
        list.add(new Employee(4, "Ayaan", "Shah", "ayaans@gmail.com",7000.50));
    }

    public List<Employee> getAllEmployees() {
        list  = list.stream().map(temp -> {
            Employee obj = new Employee();
            obj.setId(temp.getId());
            obj.setFirstName(temp.getFirstName());
            obj.setLastName(temp.getLastName());
            if ("abc@gmail.com".equalsIgnoreCase(temp.getEmail())) {
                obj.setEmail("ahaan259@yahoo.com");
            }
            return obj;
        }).collect(Collectors.toList());
        return list;
    }

    public Employee getEmployee(Integer id) {
        Employee res = list.stream().filter(employee -> employee.getId() == id).findAny().orElse(Optional.<Employee>empty().get());
        return res;
    }

    public void addEmployee(Employee e) {
        Optional.ofNullable(e).ifPresent(em -> list.add(em));
    }

    public Map<String, String> getEmpEmailMap() {
        Map<String,String> empEmailMap;
        empEmailMap=list.stream().collect(Collectors.toMap(Employee::getFirstName,Employee::getEmail));
        /*empEmailMap=list.stream().collect(
                Collectors.toMap(x->x.getFirstName()+"1", x->x.getLastName()));*/
        empEmailMap = Optional.ofNullable(empEmailMap).orElse(new HashMap<String,String>());
        return empEmailMap;
    }

    public List<Employee> getEmpWithHighestSalary() {
        Optional<Double> highestSalary = Utilities.highestSalary.apply(list);
        return Utilities.composedList.apply(highestSalary,list);
    }
}
