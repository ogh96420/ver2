package com.example.ver1.ui.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ver1.MainActivity;
import com.example.ver1.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class AdminActivityLogin extends AppCompatActivity {

    private TextView tv_name;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylogin);

        final TextView nameTextView = findViewById(R.id.tv_name);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


        findViewById(R.id.btn_config).setOnClickListener(onClickListener);
        findViewById(R.id.btn_update).setOnClickListener(onClickListener);
        findViewById(R.id.btn_question).setOnClickListener(onClickListener);
        findViewById(R.id.LogoutButton).setOnClickListener(onClickListener);

        DocumentReference documentReference = FirebaseFirestore.getInstance().collection("user")
                .document(FirebaseAuth.getInstance().getCurrentUser().getUid());
        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document != null) {
                        if (document.exists()) {
                            nameTextView.setText(document.getData().get("name").toString());

                        } else {

                        }
                    }
                } else {
                }
            }
        });
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_config:
                    startMyActivity(ConfigActivity.class);
                    break;
                case R.id.btn_update:
                    startMyActivity(UpdateActivity.class);
                    break;
                case R.id.btn_question:
                    startMyActivity(QuestionActivity.class);
                    break;
                case R.id.LogoutButton:
                    FirebaseAuth.getInstance().signOut();
                    startMyActivity(MainActivity.class);
                    finish();
                    break;
            }
        }
    };
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(AdminActivityLogin.this, MainActivity.class);
        startActivity(intent);
    }
    private void startMyActivity(Class c) {
        Intent intent = new Intent(this, c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}
