package com.example.homework.week4;

import com.example.homework.Homework;
import com.example.utils.HomeworkUtils;

import java.util.*;

public class Week4Homework extends HomeworkUtils implements Homework {
    public void runHomework() {
        this.printHomeworkHeading(4);

        //       TESTING EMPLOYEE CLASS
        //Testing Employee Constructors
        this.printExerciseHeading("TESTING EMPLOYEE CONSTRUCTORS");

        Employee e1 = new Employee(21);
        printEmployee(e1,"e1");

        Employee e2 = new Employee("Alex", 28);
        printEmployee(e2,"e2");

        Employee e3 = new Employee("Albert", 50, Gender.MALE);
        printEmployee(e3,"e3");

        Employee e4 = new Employee("Julia", 45, "Management", "Department Manager");
        printEmployee(e4,"e4");

        Employee e5 = new Employee("Anna", 50, Gender.FEMALE, "Human Resources", "HR Specialist");
        printEmployee(e5,"e5");

        //Testing Employee Getters
        this.printExerciseHeading("TESTING EMPLOYEE GETTERS");

        System.out.println("e5 Name: " + e5.getName());
        System.out.println("e5 Age: " + e5.getAge());
        System.out.println("e5 Gender: " + e5.getGender());
        System.out.println("e5 Department: " + e5.getDepartment());
        System.out.println("e5 JobTitle: " + e5.getJobTitle());

        //Testing Employee Setters
        this.printExerciseHeading("TESTING EMPLOYEE SETTERS");

        System.out.println("e1 Name (Before): " + e1.getName());
        e1.setName("Maria");
        System.out.println("e1 Name (After): " + e1.getName());

        System.out.println("\ne1 Age (Before): " + e1.getAge());
        e1.setAge(42);
        System.out.println("e1 Age (After): " + e1.getAge());

        System.out.println("\ne1 Gender (Before): " + e1.getGender());
        e1.setGender(Gender.FEMALE);
        System.out.println("e1 Gender (After): " + e1.getGender());

        System.out.println("\ne1 Department (Before): " + e1.getDepartment());
        e1.setDepartment("Sales");
        System.out.println("e1 Department (After): " + e1.getDepartment());

        System.out.println("\ne1 Job Title (Before): " + e1.getJobTitle());
        e1.setJobTitle("Sales Person");
        System.out.println("e1 Job Title (After): " + e1.getJobTitle());

        //Testing Employee Clear Methods
        this.printExerciseHeading("TESTING EMPLOYEE CLEAR METHODS");

        System.out.println("e1 Name (Before): " + e1.getName());
        e1.clearName();
        System.out.println("e1 Name (After): " + e1.getName());

        System.out.println("\ne1 Gender (Before): " + e1.getGender());
        e1.clearGender();
        System.out.println("e1 Gender (After): " + e1.getGender());

        System.out.println("\ne1 Department (Before): " + e1.getDepartment());
        e1.clearDepartment();
        System.out.println("e1 Department (After): " + e1.getDepartment());

        System.out.println("\ne1 Job Title (Before): " + e1.getJobTitle());
        e1.clearJobTitle();
        System.out.println("e1 Job Title (After): " + e1.getJobTitle());

        //       ORGANIZATION CLASS
        //Testing Organization Constructor;
        this.printExerciseHeading("TESTING ORGANIZATION CONSTRUCTOR");

        Organization org1 = new Organization();
        printOrganization(org1, "org1");

        //Testing Organization Add Methods
        this.printExerciseHeading("TESTING ORGANIZATION ADD METHODS");

        org1.addEmployee(e1);
        printOrganization(org1, "org1");


        List<Employee> employeeList = new ArrayList<>(Arrays.asList(e1, e2, e3, e4, e5));
        Organization org2 = new Organization();
        org2.addEmployees(employeeList);
        printOrganization(org2, "org2");

        //Testing Organization Remove Method
        this.printExerciseHeading("TESTING ORGANIZATION REMOVE METHOD");

        System.out.println("Removing id 8...");
        org2.removeEmployee(8);

        System.out.println("Removing id 0...\n");
        org2.removeEmployee(0);

        printOrganization(org2, "org2");

        //Testing Organization Getters
        this.printExerciseHeading("TESTING ORGANIZATION GETTERS");

        Organization org3 = new Organization();
        org3.addEmployees(employeeList);

        Map<Integer,Employee> employees = org3.getEmployees();
        for (Map.Entry<Integer, Employee> e : employees.entrySet()) {
                System.out.print(e.getKey() + ": ");
                printEmployee(e.getValue());
        }

        System.out.println("Next ID: " + org3.getNextId());

        //Testing Organization Search Methods
        this.printExerciseHeading("TESTING ORGANIZATION SEARCH METHODS");

        System.out.println("\nSearching employee by Id - 1...");
        printEmployee(org3.searchEmployee(1), "ID 1");

        System.out.println("\nSearching employee by Id - 9...");
        printEmployee(org3.searchEmployee(9));

        System.out.println("\nSearching employees by Name - \"a\"...");
        printEmployeesList(org3.searchEmployees("a"));

        System.out.println("\nSearching employees by Name - \"\"...");
        printEmployeesList(org3.searchEmployees(""));

        System.out.println("\nSearching employees by Name - \"nn\"...");
        printEmployeesList(org3.searchEmployees("nn"));

        System.out.println("\nSearching employees by Name - null...");
        printEmployeesList(org3.searchEmployees((String) null));

        System.out.println("\nSearching employees by Age - 50...");
        printEmployeesList(org3.searchEmployees(50));

        System.out.println("\nSearching employees by Age - 42...");
        printEmployeesList(org3.searchEmployees(42));

        System.out.println("\nSearching employees by Age - 19...");
        printEmployeesList(org3.searchEmployees(19));

        System.out.println("\nSearching employees by Gender - FEMALE...");
        printEmployeesList(org3.searchEmployees(Gender.FEMALE));

        System.out.println("\nSearching employees by Gender - null...");
        printEmployeesList(org3.searchEmployees((Gender) null));

        System.out.println("\nSearching employees by Department - \"\", Job Title - \"\"...");
        printEmployeesList(org3.searchEmployees("",""));

        System.out.println("\nSearching employees by Department - null, Job Title - null...");
        printEmployeesList(org3.searchEmployees(null,null));

        System.out.println("\nSearching employees by Department - \"man\", Job Title - \"manager\"...");
        printEmployeesList(org3.searchEmployees("man","manager"));

        System.out.println("\nSearching employees by Department - \"man\", Job Title - \"manager\"...");
        printEmployeesList(org3.searchEmployees("man","manager"));

        System.out.println("\nSearching employees by Name - \"a\", Age - 50, Gender - FEMALE, Department - \"Human\", Job Title - \"Specialist\"...");
        printEmployeesList(org3.searchEmployees("a", 50, Gender.FEMALE, "Human", "Specialist"));

        System.out.println("\nSearching employees by Name - \"alex\", Age - 50, Gender - FEMALE, Department - \"Human\", Job Title - \"Specialist\"...");
        printEmployeesList(org3.searchEmployees("alex", 50, Gender.FEMALE, "Human", "Specialist"));

        System.out.println("\nSearching employees by Name - \"a\", Age - 51, Gender - FEMALE, Department - \"Human\", Job Title - \"Specialist\"...");
        printEmployeesList(org3.searchEmployees("a", 51, Gender.FEMALE, "Human", "Specialist"));

        System.out.println("\nSearching employees by Name - \"a\", Age - 50, Gender - MALE, Department - \"Human\", Job Title - \"Specialist\"...");
        printEmployeesList(org3.searchEmployees("a", 50, Gender.MALE, "Human", "Specialist"));

        System.out.println("\nSearching employees by Name - \"a\", Age - 50, Gender - FEMALE, Department - null, Job Title - \"Specialist\"...");
        printEmployeesList(org3.searchEmployees("a", 50, Gender.FEMALE, null, "Specialist"));

        System.out.println("\nSearching employees by Name - \"a\", Age - 50, Gender - FEMALE, Department - \"Human\", Job Title - \"Senior\"...");
        printEmployeesList(org3.searchEmployees("a", 50, Gender.FEMALE, "Human", "Senior"));

        //Testing Organization Update Methods
        this.printExerciseHeading("TESTING ORGANIZATION UPDATE METHODS");

        System.out.println("Before updates:");
        printEmployee(org3.searchEmployee(3), "ID 3");

        System.out.println("\nUpdating age to 19...");
        org3.updateEmployeeAge(3, 19);
        printEmployee(org3.searchEmployee(3), "ID 3");

        System.out.println("\nUpdating name to George...");
        org3.updateEmployeeName(3, "George");
        printEmployee(org3.searchEmployee(3), "ID 3");

        System.out.println("\nUpdating gender to OTHER...");
        org3.updateEmployeeGender(3, Gender.OTHER);
        printEmployee(org3.searchEmployee(3), "ID 3");

        System.out.println("\nUpdating department to R&D...");
        org3.updateEmployeeDepartment(3, "R&D");
        printEmployee(org3.searchEmployee(3), "ID 3");

        System.out.println("\nUpdating job title to Researcher...");
        org3.updateEmployeeJobTitle(3, "Researcher");
        printEmployee(org3.searchEmployee(3), "ID 3");
    }

    private void printOrganization(Organization o, String objectName) {
        System.out.println("Organization " + objectName + " {");
        System.out.println("EMPLOYEES: [");

        for (Map.Entry<Integer, Employee> e : o.getEmployees().entrySet()) {
            System.out.print(e.getKey() + ": ");
            printEmployee(e.getValue());
        }

        System.out.println("]");
        System.out.println("NEXT ID: " + o.getNextId());
        System.out.println("}\n");
    }

    private static void printEmployee(Employee e, String objectName) {
        if (e==null) {
            System.out.println("Employee does not exist");
        } else {
            System.out.println("Employee " + objectName + " {");
            System.out.println(" - NAME: " + e.getName());
            System.out.println(" - AGE: " + e.getAge());
            System.out.println(" - GENDER: " + e.getGender());
            System.out.println(" - DEPARTMENT: " + e.getDepartment());
            System.out.println(" - JOB TITLE: " + e.getJobTitle());
            System.out.println("}");
        }
    }

    private static void printEmployee(Employee e) {
        printEmployee(e, "");
    }

    private static void printEmployeesList(List<Employee> employeeList) {
        if (employeeList == null || employeeList.size() == 0) {
            System.out.println("No employee was found");
        } else {
            for (Employee e : employeeList) {
                System.out.println("Employee {");
                System.out.println(" - NAME: " + e.getName());
                System.out.println(" - AGE: " + e.getAge());
                System.out.println(" - GENDER: " + e.getGender());
                System.out.println(" - DEPARTMENT: " + e.getDepartment());
                System.out.println(" - JOB TITLE: " + e.getJobTitle());
                System.out.println("}");
            }
        }
    }
}