package com.ambe.demobottomnav;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ambe.demobottomnav.databinding.FragmentSwipeBinding;

import org.greenrobot.eventbus.EventBus;


/**
 * A simple {@link Fragment} subclass.
 */
public class SwipeFragment extends Fragment {

    private BottomSheetBehavior bottomSheetBehavior;
    private FragmentSwipeBinding binding;

    public SwipeFragment() {
        // Required empty public constructor
    }

    public static SwipeFragment show(FragmentManager fragmentManager) {
        SwipeFragment fragment = (SwipeFragment) fragmentManager.findFragmentByTag("player");
        if (fragment != null) {
            return fragment;
        }
        Bundle args = new Bundle();
        fragment = new SwipeFragment();
        fragment.setArguments(args);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.player_wrap, fragment, "player");
        transaction.commitAllowingStateLoss();
        transaction.show(fragment);
        return fragment;
    }

    private void animateChange(float slideOffset) {
        float mini = 1.0f - Math.min(1.0f, slideOffset * 2.0f);
        float maxi = Math.min(1.0f, (slideOffset * 2.0f) - 1.0f);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_swipe, container, false);
        bottomSheetBehavior = BottomSheetBehavior.from(binding.playerWrap);

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
                if (i == BottomSheetBehavior.STATE_EXPANDED) {
                    animateChange(1.0f);
                    EventBus.getDefault().postSticky(new MessageEvent("b"));

                } else if (i == BottomSheetBehavior.STATE_COLLAPSED) {
                    animateChange(0.0f);

                    EventBus.getDefault().postSticky(new MessageEvent("a"));

                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {
                animateChange(v);
            }
        });
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        return binding.getRoot();
    }

}
