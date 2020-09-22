package com.example.ver1.ui.home.Shop;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.example.ver1.R;
import com.example.ver1.ui.home.Shop.Adapter.Shoplistpager;
import com.google.android.material.tabs.TabLayout;


public class ShopActivity extends AppCompatActivity {
    private Spinner spinner;
    private Shoplistpager fragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        getSupportActionBar().hide(); // 액션바 삭제


        ViewPager viewPager = findViewById(R.id.vp_shoplist);
        fragmentPagerAdapter = new Shoplistpager(getSupportFragmentManager());


        TabLayout tabLayout = findViewById(R.id.tab_shoplist);
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        spinner = (Spinner)findViewById(R.id.spinner_shop_filter1);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
}

