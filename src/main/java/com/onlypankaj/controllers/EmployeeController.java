package com.onlypankaj.controllers;

import com.onlypankaj.model.Employee;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@SecurityRequirement(name = "onlypankajapi")
public class EmployeeController {
    private List<Employee> employees = createList();

    @RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
    public List<Employee> firstPage(){
        return employees;
    }

    @PostMapping
    public Employee create(@RequestBody Employee user){
        employees.add(user);
        System.out.println(employees);
        return user;
    }

    @DeleteMapping(path = {"/{id}"})
    public Employee delete(@PathVariable("id") int id){
        Employee deletedEmp = null;
        for(Employee emp : employees){
            if(emp.getEmpId().equals(id)){
                employees.remove(emp);
                deletedEmp=emp;
                break;
            }
        }
        return deletedEmp;
    }

    private static List<Employee> createList(){
        List<Employee> tempEmployees = new ArrayList<>(
                Arrays.asList(
                new Employee("emp1","manager","1",3000),
                new Employee("emp2","developer","2",3000)
                ));
        return tempEmployees;

    }


}
