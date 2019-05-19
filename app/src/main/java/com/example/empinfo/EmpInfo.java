package com.example.empinfo;

import com.example.empinfo.models.Employee;

import java.util.ArrayList;
import java.util.List;

//Singleton
public class EmpInfo {
    private static final EmpInfo ourInstance = new EmpInfo();
    private List<Employee> employees = new ArrayList<>();

    public static EmpInfo getInstance() {
        return ourInstance;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee){
        employees.remove(employee);

    }

    public List<Employee> getEmployees() {
        return employees;
    }

}
