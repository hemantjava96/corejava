package com.hk.corejava.java8;

import java.util.ArrayList;

public class Employee {
    private String name;
    private String designation;
    private Double salary;
    private String dept;

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }


    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }



    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    public Employee(String dept, Double salary) {
        this.dept = dept;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Designation: " + designation;
    }

    public static ArrayList<Employee> dummyData() {
        // Creating dummy objects with given designations
        Employee employee1 = new Employee("John Doe", "Software Engineer");
        Employee employee2 = new Employee("John", "Software Engineer");
        Employee employee3 = new Employee("Johny", "Software Engineer");
        Employee employee4 = new Employee("Johnson", "Software Engineer");
        Employee employee5 = new Employee("Alice Smith", "Manager");
        Employee employee6 = new Employee("Bob", "Lead");
        Employee employee7 = new Employee("Bob Johnson", "Lead");

        // Creating an ArrayList and adding the dummy employees
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        employees.add(employee7);

        return employees;
    }
}
