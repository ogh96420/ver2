package com.example.ver1.ui.home.Astetic;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.example.ver1.R;

public class AsteticActivity extends AppCompatActivity {
    Button btn_move_page1;
    Button btn_move_page2;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astetic);
        setup();
        movePage1();
    }

    private void setup()
    {
        btn_move_page1 = (Button) findViewById(R.id.btn_move_page1);
        btn_move_page2 = (Button) findViewById(R.id.btn_move_page2);

        btn_move_page1.setOnClickListener(myListener);
        btn_move_page2.setOnClickListener(myListener);
        btn_move_page1.setSelected(true);
    }



    View.OnClickListener myListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            btn_move_page1.setSelected(false);
            btn_move_page2.setSelected(false);
            switch (v.getId())
            {
                case R.id.btn_move_page1 :
                    btn_move_page1.setSelected(true);
                    movePage1();
                    break;

                case R.id.btn_move_page2 :
                    btn_move_page2.setSelected(true);
                    movePage2();
                    break;
            }
        }
    };

    public void movePage1()
    {
        Page1 page1 = new Page1();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ll_page, page1);
        fragmentTransaction.commit();
    }

    public void movePage2()
    {
        Page2 page2 = new Page2();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ll_page, page2);
        fragmentTransaction.commit();
    }

}