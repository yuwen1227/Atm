package com.wen.atm;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText eduserid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        eduserid = findViewById(R.id.userid);
        String userid = getSharedPreferences("atm",MODE_PRIVATE)
                .getString("USERID"," ");
        eduserid.setText(userid);

    }
    public void login(View view){
        String userid = ((EditText)findViewById(R.id.userid)).getText().toString();
        String password =((EditText)findViewById(R.id.password)).getText().toString();
        if ("yuwen1227".equals(userid) && "8787".equals(password)){
            getSharedPreferences("atm",MODE_PRIVATE)
                    .edit()
                    .putString("USERID",userid)
                    .apply();
            setResult(RESULT_OK);
            finish();

        }

    }
}
