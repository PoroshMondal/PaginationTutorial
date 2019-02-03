package com.example.paginationtutorial.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.paginationtutorial.R;
import com.example.paginationtutorial.pojos.ModelEmployee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeHolder> {

    private LayoutInflater inflater;
    private Context context;
    private List<ModelEmployee> list;
    public EmployeeAdapter(Context context, List<ModelEmployee> list){
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.employee_row,viewGroup,false);
        return new EmployeeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder holder, int i) {
        String id = "ID: " + list.get(i).getId();
        String name = "Name: " + list.get(i).getEmployeeName();
        String age = "Age: " + list.get(i).getEmployeeAge();
        String salary = "Salary: " + list.get(i).getEmployeeSalary();

        holder.txtID.setText(id);
        holder.txtName.setText(name);
        holder.txtAge.setText(age);
        holder.txtSalary.setText(salary);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class EmployeeHolder extends RecyclerView.ViewHolder {

        TextView txtID,txtName,txtAge,txtSalary;
        public EmployeeHolder(@NonNull View itemView) {
            super(itemView);
            txtID = itemView.findViewById(R.id.txt_id);
            txtName = itemView.findViewById(R.id.txt_name);
            txtAge = itemView.findViewById(R.id.txt_age);
            txtSalary = itemView.findViewById(R.id.txt_salary);
        }
    }

}
