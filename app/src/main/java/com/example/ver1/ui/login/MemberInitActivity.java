package com.example.ver1.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ver1.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class MemberInitActivity extends AppCompatActivity {

    private static final  String TAG = "MemberInitActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_info);


        findViewById(R.id.checkButton).setOnClickListener(onClickListener);
    }

    @Override
    public void onBackPressed() {   //뒤로가기 못하게하는 메소드
        super.onBackPressed();
        finish();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.checkButton:
                    profileUpdate();
                    break;
            }
        }
    };

        private void profileUpdate() {
            String name = ((EditText) findViewById(R.id.name)).getText().toString();
            String phoneNumber = ((EditText) findViewById(R.id.phoneNumber)).getText().toString();
            String birthDay = ((EditText) findViewById(R.id.birthDay)).getText().toString();
            String address = ((EditText) findViewById(R.id.address)).getText().toString();


        if (name.length() > 0 && phoneNumber.length() > 9 && birthDay.length() > 5 && address.length() > 0) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            FirebaseFirestore db = FirebaseFirestore.getInstance();

            final MemberInfo memberInfo = new MemberInfo(name, phoneNumber, birthDay, address);

            if (user != null) {
                db.collection("user").document(user.getUid()).set(memberInfo)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getApplicationContext(), "회원정보 등록 성공", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MemberInitActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(), "회원정보 등록 실패", Toast.LENGTH_SHORT).show();
                                Log.w(TAG, "Error writing document", e);
                            }
                        });
            }
        }else {
            Toast.makeText(getApplicationContext(), "회원정보를 입력해주세요.", Toast.LENGTH_SHORT).show();}
        }
}