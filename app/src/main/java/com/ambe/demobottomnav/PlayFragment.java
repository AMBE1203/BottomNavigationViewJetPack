package com.ambe.demobottomnav;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ambe.demobottomnav.databinding.FragmentPlayBinding;

import org.greenrobot.eventbus.EventBus;

import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlayFragment extends Fragment {

    private FragmentPlayBinding binding;
    private SwipeFragment swipeFragment;


    public PlayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_play, container, false);
        binding.btnBackPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigateUp();
            }
        });

        binding.btnGoToPlaySwipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(new MessageEvent("Hey event subscriber!"));
            }
        });
        return binding.getRoot();
    }

}
