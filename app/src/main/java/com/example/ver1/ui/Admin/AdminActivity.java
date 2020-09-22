package com.example.ver1.ui.Admin;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ver1.MainActivity;
import com.example.ver1.R;
import com.example.ver1.ui.login.LoginActivity;
import com.example.ver1.ui.login.SignUpActivity;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);


        findViewById(R.id.btn_create).setOnClickListener(onClickListener);
        findViewById(R.id.btn_config).setOnClickListener(onClickListener);
        findViewById(R.id.btn_update).setOnClickListener(onClickListener);
        findViewById(R.id.btn_question).setOnClickListener(onClickListener);
        findViewById(R.id.gotoLoginButton).setOnClickListener(onClickListener);
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_create:
                    startMyActivity(SignUpActivity.class);
                    break;
                case R.id.btn_config:
                    startMyActivity(ConfigActivity.class);
                    break;
                case R.id.btn_update:
                    startMyActivity(UpdateActivity.class);
                    break;
                case R.id.btn_question:
                    startMyActivity(QuestionActivity.class);
                    break;
                case R.id.gotoLoginButton:
                    startMyActivity(LoginActivity.class);
                    break;

            }
        }
    };
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(AdminActivity.this, MainActivity.class);
        startActivity(intent);
    }
    private void startMyActivity(Class c) {
        Intent intent = new Intent(this, c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}
