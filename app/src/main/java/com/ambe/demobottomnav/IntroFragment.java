package com.ambe.demobottomnav;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ambe.demobottomnav.databinding.FragmentIntroBinding;

import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class IntroFragment extends Fragment {

    private PrefManager prefManager;
    private FragmentIntroBinding binding;


    public IntroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_intro, container, false);
        prefManager = new PrefManager(getContext());
        binding.btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.homeFragment);
                prefManager.setFirstTimeLaunch(false);
            }
        });
        return binding.getRoot();
    }

}
