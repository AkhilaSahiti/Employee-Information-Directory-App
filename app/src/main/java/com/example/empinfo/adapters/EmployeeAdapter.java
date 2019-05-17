package com.example.empinfo.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.empinfo.EmployeeDetailsActivity;
import com.example.empinfo.R;
import com.example.empinfo.models.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    private Context context;
    private List<Employee> employeeList;



    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView name, designation, field, email, phone, salary;
        public ImageButton delete;
        public Button click;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            name =(TextView) itemView.findViewById(R.id.name);
            designation =(TextView) itemView.findViewById(R.id.designation);
            field = (TextView) itemView.findViewById(R.id.field);
            email = (TextView) itemView.findViewById(R.id.email);
            phone = (TextView) itemView.findViewById(R.id.phone);
            salary = (TextView) itemView.findViewById(R.id.salary);
            delete = (ImageButton) itemView.findViewById(R.id.delete);
            click = (Button) itemView.findViewById(R.id.click);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);



        }
    }
    public EmployeeAdapter(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employee_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        Employee employee = employeeList.get(position);
        viewHolder.name.setText(employee.getName());
        viewHolder.designation.setText(employee.getDesignation());
        viewHolder.field.setText(employee.getField());
        viewHolder.email.setText(employee.getEmail());
        viewHolder.phone.setText(String.valueOf(employee.getPhone()));
        viewHolder.salary.setText(String.valueOf(employee.getSalary()));
        viewHolder.imageView.setImageBitmap(employee.getPhoto());
        viewHolder.delete.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Employee removedItem = employeeList.get(position);
               employeeList.remove(position);
               notifyItemRemoved(position);
           }
       });
       viewHolder.click.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Employee employee = employeeList.get(position);
               Intent intent = new Intent(v.getContext(), EmployeeDetailsActivity.class);
               intent.putExtra("urname",employee.getName());
               intent.putExtra("urdesignation",employee.getDesignation());
               intent.putExtra("urfield",employee.getField());
               intent.putExtra("uremail",employee.getEmail());
               intent.putExtra("urphone",String.valueOf(employee.getPhone()));
               intent.putExtra("ursalary",String.valueOf(employee.getSalary()));
              // intent.putExtra("urphoto",employee.getPhoto());
               v.getContext().startActivity(intent);
           }
       });
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }


}
