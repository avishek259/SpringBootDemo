package com.example.demo;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping(path = "/", produces = "application/json")
    public List<Employee> getEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @GetMapping(path="/empEmails", produces = "application/json")
    public Map<String,String> getEmpEmailMap(){
        return employeeDAO.getEmpEmailMap();
    }

    @GetMapping(path="/empWithHighestSalary", produces = "application/json")
    public List<Employee> getEmpWithHighestSalary(){
        return employeeDAO.getEmpWithHighestSalary();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Employee getEmployee(@PathVariable("id") Integer id){
        return employeeDAO.getEmployee(id);
    }
    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee emp){
        Integer id = employeeDAO.getAllEmployees().size() +1;
        emp.setId(id);
        employeeDAO.addEmployee(emp);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(emp.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
