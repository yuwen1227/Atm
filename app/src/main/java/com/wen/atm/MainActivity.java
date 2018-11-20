package com.wen.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends BaseActivity {
    private static final int RC_LOGIN = 8787;
    boolean logon = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!logon){
            Intent intent = new Intent(this,LoginActivity.class);
            startActivityForResult(intent,RC_LOGIN);


        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_LOGIN){
            if(resultCode !=RESULT_OK){
                finish();
            }else{
                logon = true;
                String nickname = getSharedPreferences("user",MODE_PRIVATE)
                        .getString("NICKNAME",null);
                int age = getSharedPreferences("user",MODE_PRIVATE)
                        .getInt("AGE",0);
                String gender = getSharedPreferences("user",MODE_PRIVATE)
                        .getString("GENDER",null);
                if(nickname == null || age == 0 || gender == null) {
                    //TODO: check nickname,age,gender exist
                    Intent nick = new Intent(this, NickNameActivity.class);
                    startActivity(nick);
                }
            }
        }
    }
}

