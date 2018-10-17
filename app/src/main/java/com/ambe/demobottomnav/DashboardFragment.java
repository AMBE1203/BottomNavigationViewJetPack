package com.ambe.demobottomnav;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ambe.demobottomnav.databinding.FragmentDashboardBinding;

import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;


    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false);
        binding.btnGoToDetail.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_dashboardFragment_to_detailFragment));
        binding.btnGoToList.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_dashboardFragment_to_listFragment));

        return binding.getRoot();
    }

}
