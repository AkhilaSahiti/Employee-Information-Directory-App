package com.example.empinfo.models;


import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private String designation;
    private String field;
    private String email;
    private long phone;
    private double salary;
    private int photo;

    public Employee(String name, String designation, String field, String email, long phone, double salary, int photo) {
        this.name = name;
        this.designation = designation;
        this.field = field;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.photo = photo;
    }

    public int getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getField() {
        return field;
    }

    public String getEmail() {
        return email;
    }

    public long getPhone() {
        return phone;
    }

    public double getSalary() {
        return salary;
    }

}
