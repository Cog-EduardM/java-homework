package com.example.homework.week4;

enum Gender {
    FEMALE,
    MALE,
    OTHER
}

public class Employee {
    private int age;
    private String name;
    private String department;
    private String jobTitle;
    private Gender gender;

    public Employee (int age) {
        checkAge(age);
        this.age = age;
    }

    public Employee (String name, int age) {
        checkAge(age);
        this.name = name;
        this.age = age;
    }

    public Employee (String name, int age, Gender gender) {
        checkAge(age);
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Employee (String name, int age, String department, String jobTitle) {
        checkAge(age);
        this.name = name;
        this.age = age;
        this.department = department;
        this.jobTitle = jobTitle;
    }

    public Employee(String name, int age, Gender gender, String department, String jobTitle) {
        checkAge(age);
        this.name =  name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.jobTitle =  jobTitle;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void clearName() {
        this.name = null;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        checkAge(age);
        this.age = age;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void clearGender() {
        this.gender = null;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void clearDepartment() {
        this.department = null;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void clearJobTitle() {
        this.jobTitle = null;
    }

    private static void checkAge(int age) {
        if (age < 18 || age > 65)
            throw new IllegalArgumentException("Cannot be an Employee at " + age);
    }
}