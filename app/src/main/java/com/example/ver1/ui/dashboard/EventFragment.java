package com.example.ver1.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.ver1.R;
import com.example.ver1.ui.home.Astetic.AsteticActivity;
import com.example.ver1.ui.home.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class EventFragment extends Fragment {

    private FragmentPagerAdapter fragmentPagerAdapter;
    private View view;
    private Button btn1;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_eventpop, container, false);

        ViewPager viewPager = (ViewPager)view.findViewById(R.id.vp_event);
        fragmentPagerAdapter = new EventpopPager(getChildFragmentManager());

        btn1 = view.findViewById(R.id.button4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), ReviewEditActivity.class);
                startActivity(intent);

            }
        });


        TabLayout tabLayout = (TabLayout)view.findViewById(R.id.tab_eventpop);
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}