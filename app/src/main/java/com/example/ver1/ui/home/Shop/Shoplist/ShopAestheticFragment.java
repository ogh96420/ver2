package com.example.ver1.ui.home.Shop.Shoplist;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ver1.R;
import com.example.ver1.ui.home.Shop.Adapter.RecyclerViewDecoration;
import com.example.ver1.ui.home.Shop.Adapter.ShopAestheticAdapter;
import com.example.ver1.ui.home.Shop.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShopAestheticFragment extends Fragment {


    private View view;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    GridLayoutManager layoutManager;
    private ArrayList<User> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private ImageButton imageButton;

    public static ShopAestheticFragment newInstance() {
        ShopAestheticFragment shopaestheticFragment = new ShopAestheticFragment();
        return shopaestheticFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_shopaesthetic, container, false);
        recyclerView = view.findViewById(R.id.recyclerView_shopaesthetic); // 아디 연결
        recyclerView.setHasFixedSize(true); // 리사이클러뷰 기존성능 강화
        layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new RecyclerViewDecoration(25)); // 리사이클러뷰데코레이션 클래스에서 간격주기수정

        arrayList = new ArrayList<>(); // User 객체를 담을 어레이 리스트 (어댑터쪽으로)

        database = FirebaseDatabase.getInstance(); // 파이어베이스 데이터베이스 연동

        databaseReference = database.getReference("User"); // DB 테이블 연결
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // 파이어베이스 데이터베이스의 데이터를 받아오는 곳
                arrayList.clear(); // 기존 배열리스트가 존재하지않게 초기화
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    User user = snapshot.getValue(User.class); // 만들어뒀던 User 객체에 데이터를 담는다.
                    arrayList.add(user); // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비
                }
                adapter.notifyDataSetChanged(); // 리스트 저장 및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 디비를 가져오던중 에러 발생 시
                Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        adapter = new ShopAestheticAdapter(arrayList, getActivity());
        recyclerView.setAdapter(adapter); // 리사이클러뷰에 어댑터 연결
        return view;
    }
}

