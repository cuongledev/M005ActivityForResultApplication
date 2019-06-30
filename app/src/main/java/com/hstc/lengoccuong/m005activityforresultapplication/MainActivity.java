package com.hstc.lengoccuong.m005activityforresultapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int REQUEST_CODE_LOGIN = 101;
    EditText mUsername, mPassword;
    Button mBtnLogin;
    TextView mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.pass);
        mBtnLogin = findViewById(R.id.login);
        mRegister = findViewById(R.id.register);
        mBtnLogin.setOnClickListener(this);
        mRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                break;
            case R.id.register:
                doRegister();
                break;
            default:
                break;
        }
    }

    private void doRegister() {
        Intent intent = new Intent();
        intent.setClass(this, RegisterActivity.class);
        startActivityForResult(intent, REQUEST_CODE_LOGIN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_CODE_LOGIN:

                if (resultCode==RESULT_OK){
                    Log.i("TAG_LOGIN","onActivityResult"+ data.getStringExtra(RegisterActivity.KEY_USERNAME) + " - " + data.getStringExtra(RegisterActivity.KEY_PASS));
                    mUsername.setText(data.getStringExtra(RegisterActivity.KEY_USERNAME));
                    mPassword.setText(data.getStringExtra(RegisterActivity.KEY_PASS));
                }

                break;
            default:
                break;
        }
    }
}
