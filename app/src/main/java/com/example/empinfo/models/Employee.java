package com.example.empinfo.models;


import android.graphics.Bitmap;

public class Employee {
    private String name;
    private String designation;
    private String field;
    private String email;
    private long phone;
    private double salary;
    private Bitmap photo;
    //public List<Employee> employees;



    public Employee(String name, String designation, String field, String email, long phone, double salary, Bitmap photo){
        this.name=name;
        this.designation=designation;
        this.field=field;
        this.email=email;
        this.phone=phone;
        this.salary=salary;
        this.photo=photo;
    }

    public Bitmap getPhoto() { return photo; }

    public void setPhoto(Bitmap photo) { this.photo = photo; }

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

    public void setName(String name) {
        this.name = name;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


}
