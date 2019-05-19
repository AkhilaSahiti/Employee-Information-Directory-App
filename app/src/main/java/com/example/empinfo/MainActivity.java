package com.example.empinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.empinfo.adapters.EmployeeAdapter;
import com.example.empinfo.models.Employee;

public class MainActivity extends AppCompatActivity implements EmployeeAdapter.EmployeeAdapterCallback {

    private RecyclerView recyclerView;
    private EmployeeAdapter employeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        populateEmployeeList();
        employeeAdapter = new EmployeeAdapter(EmpInfo.getInstance().getEmployees(), this);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, mLayoutManager.getOrientation());
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(employeeAdapter);


    }

    private void populateEmployeeList() {

        Employee employee1 = new Employee("Mahesh Kumar", "Associate", "Marketing", "mahesh_kumar@gmail.com", 9123456789L, 22000, R.drawable.emp1);
        EmpInfo.getInstance().addEmployee(employee1);

        Employee employee2 = new Employee("Akhila Sahiti", "Team Lead", "Technology", "sahiti_akhila@yahoo.com", 9893120883L, 21000, R.drawable.emp2);
        EmpInfo.getInstance().addEmployee(employee2);

        Employee employee3 = new Employee("Ramya Singh", "Assistant Director", "Design", "ramya123@gmail.com", 7587796811L, 25000, R.drawable.emp3);
        EmpInfo.getInstance().addEmployee(employee3);

        Employee employee4 = new Employee("Anurag Paul", "Team Lead", "Sales", "anurag_paul@gmail.com", 9789598769L, 22000, R.drawable.emp4);
        EmpInfo.getInstance().addEmployee(employee4);

        Employee employee5 = new Employee("Abhay Joshi", "Senior Manager", "Technology", "abhay@yahoo.com", 9012340079L, 27000, R.drawable.emp5);
        EmpInfo.getInstance().addEmployee(employee5);

        Employee employee6 = new Employee("Lakshmi Bhadana", "Manager", "Design", "lksmi777@yahoo.com", 9988123987L, 23800, R.drawable.emp6);
        EmpInfo.getInstance().addEmployee(employee6);

        Employee employee7 = new Employee("Leela krishna", "Associate", "Marketing", "leela@gmail.com", 7995887001L, 21000, R.drawable.emp7);
        EmpInfo.getInstance().addEmployee(employee7);

        Employee employee8 = new Employee("Sai Kiran", "Directory", "Sales", "kiran987@email.com", 9123456789L, 22000, R.drawable.emp8);
        EmpInfo.getInstance().addEmployee(employee8);

        Employee employee9 = new Employee("Rajesh Khanna", "Junior Manager", "Developer", "rajesh@yahoo.com", 9123456789L, 29000, R.drawable.emp9);
        EmpInfo.getInstance().addEmployee(employee9);

        Employee employee10 = new Employee("Mayaa Rajput", "Team Lead", "Marketing", "mayarajput@yahoo.com", 9993079099L, 22500, R.drawable.emp10);
        EmpInfo.getInstance().addEmployee(employee10);
    }

    @Override
    public void onEmployeeClicked(Employee employee) {
        Intent intent = new Intent(this, EmployeeDetailsActivity.class);
        intent.putExtra("employee", employee);
        startActivity(intent);
    }
}
