package com.example.paginationtutorial;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.paginationtutorial.fragment.Home;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        home();
    }

    private void home(){
        Fragment fragment = new Home();
        transaction = manager.beginTransaction();
        transaction.add(R.id.group,fragment,"HOME");
        transaction.commit();
    }

}
