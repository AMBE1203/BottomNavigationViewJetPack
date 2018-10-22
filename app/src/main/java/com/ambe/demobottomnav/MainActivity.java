package com.ambe.demobottomnav;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    private PrefManager prefManager;
    private SwipeFragment swipeFragment;
    private BottomNavigationView navigation;

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    // UI updates must run on MainThread
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent event) {
        swipeFragment = SwipeFragment.show(getSupportFragmentManager());
        navigation.setVisibility(View.GONE);
        if (event.getMessage().equals("a")) {
            navigation.setVisibility(View.VISIBLE);
        } else if (event.getMessage().equals("b")) {
            navigation.setVisibility(View.GONE);

        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefManager = new PrefManager(this);
        setContentView(R.layout.activity_main);
        navigation = findViewById(R.id.navigation);
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
