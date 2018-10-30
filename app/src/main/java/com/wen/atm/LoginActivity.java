package com.wen.atm;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
          new AlertDialog.Builder(this).setMessage("error")
                  .setTitle("Error!!!!")
                  .setMessage("Your Username or Password is incorrect")
                  .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialog, int which) {

                      }
                  })
        }

    }
}
