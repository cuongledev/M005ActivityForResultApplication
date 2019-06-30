package com.hstc.lengoccuong.m005activityforresultapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    public static final String KEY_USERNAME = "KEY_USERNAME";
    public static final String KEY_PASS = "KEY_PASS";
    EditText mUsername,mPass,mRePass;
    Button mBtnRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        initViews();
    }

    private void initViews() {

        mUsername = findViewById(R.id.user);
        mPass = findViewById(R.id.pass);
        mRePass = findViewById(R.id.re_pass);
        mBtnRegister = findViewById(R.id.bt_register);
        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doSendData();
            }
        });

    }

    private void doSendData() {

        Intent intent = new Intent();
        intent.putExtra(KEY_USERNAME, mUsername.getText().toString());
        intent.putExtra(KEY_PASS, mPass.getText().toString());
        setResult(RESULT_OK,intent);
        Log.i("TAG","doSendData"+ mUsername.getText().toString() + " - " + mPass.getText().toString());
        finish();
    }
}
