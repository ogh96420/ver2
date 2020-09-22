package com.example.ver1.ui.home.Astetic;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.app.Fragment;

import com.example.ver1.R;

public class Page1 extends Fragment {

    Button btn_move_page1_list1;
    Button btn_move_page1_list2;
    Button btn_move_page1_list3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page1, container, false);

        btn_move_page1_list1 = (Button) view.findViewById(R.id.btn_move_page2_list1);
        btn_move_page1_list2 = (Button) view.findViewById(R.id.btn_move_page2_list2);
        btn_move_page1_list3 = (Button) view.findViewById(R.id.btn_move_page2_list3);

        btn_move_page1_list1.setOnClickListener(myListener);
        btn_move_page1_list2.setOnClickListener(myListener);
        btn_move_page1_list3.setOnClickListener(myListener);
        movePage1List1();
        btn_move_page1_list1.setSelected(true);
        return view;
    }

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            btn_move_page1_list1.setSelected(false);
            btn_move_page1_list2.setSelected(false);
            btn_move_page1_list3.setSelected(false);


            switch (v.getId()) {
                case R.id.btn_move_page2_list1:
                    btn_move_page1_list1.setSelected(true);
                    movePage1List1();
                    break;
                case R.id.btn_move_page2_list2:
                    btn_move_page1_list2.setSelected(true);
                    movePage1List2();
                    break;

                case R.id.btn_move_page2_list3:
                    btn_move_page1_list3.setSelected(true);
                    movePage1List3();
                    break;

            }
        }
    };

    public void movePage1List1() {
        Page1_List1 page1_list1 = new Page1_List1();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ll_page_list1, page1_list1);
        fragmentTransaction.commit();
    }
    public void movePage1List2()
    {
        Page1_List2 page1_list2 = new Page1_List2();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ll_page_list1, page1_list2);
        fragmentTransaction.commit();
    }
    public void movePage1List3()
    {
        Page1_List3 page1_list3 = new Page1_List3();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ll_page_list1, page1_list3);
        fragmentTransaction.commit();
    }
}
