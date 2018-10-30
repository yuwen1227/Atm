package com.wen.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void login(View view){
        String userid = ((EditText)findViewById(R.id.userid)).getText().toString();
        String password =((EditText)findViewById(R.id.password)).getText().toString();
        if ("yuwen1227".equals(userid) && "8787".equals(password)){
            setResult(RESULT_OK);
            finish();
        }

    }
}
