package com.wen.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
    }
    public void next(View view){
        EditText edgender = findViewById(R.id.ed_gender);
        String gender = edgender.getText().toString();
        getSharedPreferences("gender",MODE_PRIVATE)
                .edit()
                .putString("GENDER",gender)
                .apply();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
    public void back(View view){
        finish();
    }
}
