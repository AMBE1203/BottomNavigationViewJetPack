package com.ambe.demobottomnav;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    private PrefManager prefManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefManager = new PrefManager(this);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navigation, navHostFragment.getNavController());

//
//        if (!prefManager.isFirstTimeLaunch()) {
//            navigation.setVisibility(View.VISIBLE);
//
//            Log.d("AMBE1203", "Lan 1");
////            NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
////            NavigationUI.setupWithNavController(navigation, navHostFragment.getNavController());
//        } else {
//            Log.d("AMBE1203", "Lan 0");
//            navigation.setVisibility(View.GONE);
//
//        }

//


    }

}
