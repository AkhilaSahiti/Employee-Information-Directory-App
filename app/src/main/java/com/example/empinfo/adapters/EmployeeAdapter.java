package com.example.empinfo.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.empinfo.EmpInfo;
import com.example.empinfo.R;
import com.example.empinfo.models.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    private List<Employee> employeeList;
    private EmployeeAdapterCallback listener;

    public interface EmployeeAdapterCallback {
        void onEmployeeClicked(Employee employee);
    }

    public EmployeeAdapter(List<Employee> employeeList, EmployeeAdapterCallback listener) {
        this.employeeList = employeeList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employee_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {
        Employee employee = employeeList.get(viewHolder.getAdapterPosition());
        viewHolder.name.setText(employee.getName());
        viewHolder.designation.setText(employee.getDesignation());
        viewHolder.field.setText(employee.getField());
        viewHolder.imageView.setImageResource(employee.getPhoto());

        viewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Employee removedEmployee = employeeList.get(viewHolder.getAdapterPosition());
                employeeList.remove(viewHolder.getAdapterPosition());
                notifyItemRemoved(viewHolder.getAdapterPosition());
                EmpInfo.getInstance().removeEmployee(removedEmployee);
            }
        });

        viewHolder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onEmployeeClicked(employeeList.get(viewHolder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name, designation, field;
        ImageButton delete;
        Button click;
        LinearLayout mainLayout;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            name = (TextView) itemView.findViewById(R.id.name);
            designation = (TextView) itemView.findViewById(R.id.designation);
            field = (TextView) itemView.findViewById(R.id.field);
            delete = (ImageButton) itemView.findViewById(R.id.delete);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            mainLayout = (LinearLayout) itemView.findViewById(R.id.on_click);
        }
    }
}
