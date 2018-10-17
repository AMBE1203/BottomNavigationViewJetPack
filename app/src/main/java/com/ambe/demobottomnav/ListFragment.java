package com.ambe.demobottomnav;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ambe.demobottomnav.databinding.FragmentListBinding;

import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    private FragmentListBinding binding;

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);

        binding.btnListGoToDetail.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_listFragment_to_detailFragment));
        binding.btnBackList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigateUp();
            }
        });
        return binding.getRoot();
    }

}
