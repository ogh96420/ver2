package com.example.ver1.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.ver1.ui.Admin.AdminActivityLogin;
import com.example.ver1.ui.home.Astetic.AsteticActivity;
import com.example.ver1.R;
import com.example.ver1.ui.Admin.AdminActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;


public class HomeFragment extends Fragment {

    private View view;
    private ImageButton btn_admin;
    private ImageButton btn1,btn2,btn3,btn4,btn5,btn6;
    private String result;
    private Intent intent1;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private FirebaseAuth mAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
        mAuth = FirebaseAuth.getInstance();

        ViewPager viewPager = (ViewPager)view.findViewById(R.id.tab_View);
        fragmentPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());


        TabLayout tabLayout = (TabLayout)view.findViewById(R.id.tab_home);
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        btn1 = view.findViewById(R.id.btn_ast);
        btn2 = view.findViewById(R.id.btn_half);
        btn3 = view.findViewById(R.id.btn_nail);
        btn4 = view.findViewById(R.id.btn_wax);
        btn5 = view.findViewById(R.id.btn_in);
        btn6 = view.findViewById(R.id.btn_store);
        btn_admin = view.findViewById(R.id.btn_admin);
        btn_admin.bringToFront(); // 뷰에서 자신 최상위

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            btn_admin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(getActivity() , AdminActivityLogin.class);
                    startActivity(intent);
                }
            });
        } else {
            btn_admin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(getActivity() , AdminActivity.class);
                    startActivity(intent);
                }
            });
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), AsteticActivity.class);
                startActivity(intent);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent in = new Intent(getActivity(), AsteticActivity.class);
                startActivity(in);

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent in = new Intent(getActivity(), StroeActivity.class);
                startActivity(in);

            }
        });


        return view;
    }


}
