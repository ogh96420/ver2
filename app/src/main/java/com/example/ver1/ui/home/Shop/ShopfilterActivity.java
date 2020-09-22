package com.example.ver1.ui.home.Shop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ver1.R;

public class ShopfilterActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopfilter);

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        CheckBox checkBox5 = (CheckBox) findViewById(R.id.checkBox5);
        CheckBox checkBox6 = (CheckBox) findViewById(R.id.checkBox6);
        CheckBox checkBox7 = (CheckBox) findViewById(R.id.checkBox7);

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
