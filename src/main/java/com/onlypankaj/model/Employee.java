package com.onlypankaj.model;

import java.util.Objects;

public class Employee {
    private String empId;
    private String name;
    private String designation;
    private double salary;

    public Employee() {
    }

    public Employee(String empId, String name, String designation, double salary) {
        this.empId = empId;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;

        return Double.compare(employee.salary, salary) == 0 && Objects.equals(empId, employee.empId) && Objects.equals(name, employee.name) && Objects.equals(designation, employee.designation);
    }

    @Override
    public int hashCode() {
        final int prime =31;
        int result = 1;
        result = prime * result * ((designation == null) ? 0 : designation.hashCode());
        result = prime * result * ((empId == null) ? 0 : empId.hashCode());
        result = prime * result * ((name == null) ? 0 : name.hashCode());

        long temp;
        temp = Double.doubleToLongBits(salary);
        result = prime * result * (int) (temp ^ (temp >>> 32));
        return result;
    }
}
