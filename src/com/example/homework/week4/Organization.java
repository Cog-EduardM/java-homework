package com.example.homework.week4;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Organization {
    private Map<Integer, Employee> employees;
    private Integer nextId;

    public Organization() {
        this.employees = new HashMap<>();
        this.nextId = 1;
    }

    public Map<Integer, Employee> getEmployees() {
        return this.employees;
    }

    public int getNextId() {
        return this.nextId;
    }

    public void addEmployee(Employee e) {
        this.employees.put(nextId++, e);
    }

    public void addEmployees(List<Employee> employeeList) {
        for (Employee e : employeeList) {
            this.addEmployee(e);
        }
    }

    public void removeEmployee(int id) {
        this.employees.remove(id);
    }

    public Employee searchEmployee(int id) {
        return this.employees.get(id);
    }

    public List<Employee> searchEmployees(String partialName) {
        Predicate<Employee> byName = (partialName == null)
                ? e -> e.getName() == null
                : e -> e.getName() != null && e.getName()
                .toLowerCase()
                .contains(partialName.toLowerCase());

        return this.employees.values()
                .stream()
                .filter(byName)
                .collect(Collectors.toList());
    }

    public List<Employee> searchEmployees(int age) {
        Predicate<Employee> byAge = e -> e.getAge() == age;

        return this.employees.values()
                .stream()
                .filter(byAge)
                .collect(Collectors.toList());
    }

    public List<Employee> searchEmployees(Gender gender) {
        Predicate<Employee> byGender = e -> e.getGender() == gender;

        return this.employees.values()
                .stream()
                .filter(byGender)
                .collect(Collectors.toList());
    }

    public List<Employee> searchEmployees(String partialDepartment, String partialJobTitle) {
        Predicate<Employee> byDepartment = (partialDepartment == null)
                ? e -> e.getDepartment() == null
                : e -> e.getDepartment() != null && e.getDepartment()
                        .toLowerCase()
                        .contains(partialDepartment.toLowerCase());
        Predicate<Employee> byJobTitle = (partialJobTitle == null)
                ? e -> e.getJobTitle() == null
                : e -> e.getJobTitle() != null && e.getJobTitle()
                        .toLowerCase()
                        .contains(partialJobTitle.toLowerCase());

        return this.employees.values()
                .stream()
                .filter(byDepartment)
                .filter(byJobTitle)
                .collect(Collectors.toList());
    }

    public List<Employee> searchEmployees(String partialName, int age, Gender gender, String partialDepartment, String partialJobTitle) {
        Predicate<Employee> byName = (partialName == null)
                ? e -> e.getName() == null
                : e -> e.getName() != null && e.getName()
                .toLowerCase()
                .contains(partialName.toLowerCase());
        Predicate<Employee> byDepartment = (partialDepartment == null)
                ? e -> e.getDepartment() == null
                : e -> e.getDepartment() != null && e.getDepartment()
                .toLowerCase()
                .contains(partialDepartment.toLowerCase());
        Predicate<Employee> byJobTitle = (partialJobTitle == null)
                ? e -> e.getJobTitle() == null
                : e -> e.getJobTitle() != null && e.getJobTitle()
                .toLowerCase()
                .contains(partialJobTitle.toLowerCase());
        Predicate<Employee> byGender = e -> e.getGender() == gender;
        Predicate<Employee> byAge = e -> e.getAge() == age;

        return this.employees.values()
                .stream()
                .filter(byAge)
                .filter(byGender)
                .filter(byName)
                .filter(byDepartment)
                .filter(byJobTitle)
                .collect(Collectors.toList());
    }

    public void updateEmployeeAge(int id, int age) {
        if (this.employees.containsKey(id))
            this.employees.get(id).setAge(age);
    }

    public void updateEmployeeName(int id, String name) {
        if (this.employees.containsKey(id))
            this.employees.get(id).setName(name);
    }

    public void updateEmployeeGender(int id, Gender gender) {
        if (this.employees.containsKey(id))
            this.employees.get(id).setGender(gender);
    }

    public void updateEmployeeDepartment(int id, String department) {
        if (this.employees.containsKey(id))
            this.employees.get(id).setDepartment(department);
    }

    public void updateEmployeeJobTitle(int id, String jobTitle) {
        if (this.employees.containsKey(id))
            this.employees.get(id).setJobTitle(jobTitle);
    }
}