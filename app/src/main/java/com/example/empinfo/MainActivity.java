package com.example.empinfo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.empinfo.adapters.EmployeeAdapter;
import com.example.empinfo.models.Employee;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Employee> employeeList = new ArrayList<>();
    private RecyclerView recyclerView;
    private EmployeeAdapter employeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);


        employeeAdapter = new EmployeeAdapter(employeeList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, ((LinearLayoutManager) mLayoutManager).getOrientation());
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(employeeAdapter);
        populateEmployeeList();
    }


    /*public List<Bitmap> getImageList() {
        List<Bitmap> images = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image1);
            images.add(bitmap);
        }
        return images;
    }*/

    private void populateEmployeeList() {

        Employee employee1 = new Employee("Mahesh Kumar", "Associate","Marketing","mahesh_kumar@gmail.com",  9123456789L,22000, BitmapFactory.decodeResource(getResources(), R.drawable.emp1));
        employeeList.add(employee1);

        Employee employee2 = new Employee("Akhila Sahiti", "Team Lead","Technology","sahiti_akhila@yahoo.com",9893120883L,21000, BitmapFactory.decodeResource(getResources(), R.drawable.emp2));
        employeeList.add(employee2);

        Employee employee3 = new Employee("Ramya Singh", "Assistant Director","Design","ramya123@gmail.com",7587796811L,25000, BitmapFactory.decodeResource(getResources(), R.drawable.emp3));
        employeeList.add(employee3);

        Employee employee4 = new Employee("Anurag Paul", "Team Lead","Sales","anurag_paul@gmail.com",9789598769L,22000, BitmapFactory.decodeResource(getResources(), R.drawable.emp4));
        employeeList.add(employee4);

        Employee employee5 = new Employee("Abhay Joshi", "Senior Manager","Technology","abhay@yahoo.com",9012340079L,27000, BitmapFactory.decodeResource(getResources(), R.drawable.emp5));
        employeeList.add(employee5);

        Employee employee6 = new Employee("Lakshmi Bhadana", "Manager","Design","lksmi777@yahoo.com",9988123987L,23800, BitmapFactory.decodeResource(getResources(), R.drawable.emp6));
        employeeList.add(employee6);

        Employee employee7 = new Employee("Leela krishna", "Associate","Marketing","leela@gmail.com",7995887001L,21000, BitmapFactory.decodeResource(getResources(), R.drawable.emp7));
        employeeList.add(employee7);

        Employee employee8 = new Employee("Sai Kiran", "Directory","Sales","kiran987@email.com",9123456789L,22000, BitmapFactory.decodeResource(getResources(), R.drawable.emp8));
        employeeList.add(employee8);

        Employee employee9 = new Employee("Rajesh Khanna", "Junior Manager","Developer","rajesh@yahoo.com",9123456789L,29000, BitmapFactory.decodeResource(getResources(), R.drawable.emp9));
        employeeList.add(employee9);

        Employee employee10 = new Employee("Mayaa Rajput", "Team Lead","Marketing","mayarajput@yahoo.com",9993079099L,22500, BitmapFactory.decodeResource(getResources(), R.drawable.emp10));
        employeeList.add(employee10);
        employeeAdapter.notifyDataSetChanged();
        /*employee1.setName("Sahiti");
            employee1.setDesignation("Developer");
            employee1.setField("Technology");
            employee1.setEmail("sahiti@akhila.com");
            employee1.setPhone(9123456789L);
            employee1.setSalary(22000);
            EmpInfo.getInstance().add(employee1);*/


    }
}
