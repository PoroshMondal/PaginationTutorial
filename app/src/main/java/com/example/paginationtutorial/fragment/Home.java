package com.example.paginationtutorial.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.paginationtutorial.R;
import com.example.paginationtutorial.adapter.EmployeeAdapter;
import com.example.paginationtutorial.interfaces.VolleyCallback;
import com.example.paginationtutorial.pojos.ModelEmployee;
import com.example.paginationtutorial.utils.NetworkCall;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class Home extends Fragment implements VolleyCallback {

    private Activity activity;
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        progressDialog = new ProgressDialog(activity);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        recyclerView = view.findViewById(R.id.list_employee);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        requestDataAndCreateView();
    }

    private void requestDataAndCreateView(){
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        NetworkCall networkCall = new NetworkCall(activity);
        networkCall.setVolleyCallbackListener(this);
        networkCall.requestToServer(getResources().getString(R.string.url));
    }

    @Override
    public void onSuccessResponse(String response) {

        ModelEmployee[] modelEmployees = new Gson().fromJson(response,ModelEmployee[].class);
        List<ModelEmployee> list = Arrays.asList(modelEmployees);

        EmployeeAdapter adapter = new EmployeeAdapter(activity,list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        //Toast.makeText(activity, ""+list.get(0).getEmployeeName(), Toast.LENGTH_SHORT).show();

        progressDialog.dismiss();
    }
}
