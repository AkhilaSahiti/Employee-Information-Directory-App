package com.example.empinfo;

import com.example.empinfo.models.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpInfo {
    private static final EmpInfo ourInstance = new EmpInfo();
    private List<Employee> employees = new ArrayList<>();

    public static EmpInfo getInstance() {
        return ourInstance;
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() { return employees; }

}
