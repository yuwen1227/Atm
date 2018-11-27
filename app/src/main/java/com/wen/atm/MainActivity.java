package com.wen.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity {
    private static final int RC_LOGIN = 8787;
    boolean logon = false;
    List<String> fruits = Arrays.asList("香蕉","蘋果","草莓");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!logon) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent, RC_LOGIN);
        }
        //ListView
        //listView();
        //RecyclerView(可儲存資料)
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//行列式清單
        //recyclerView.setAdapter(new FruitAdapter());//在class新建一個class FruitAdapter 繼承RecyclerView
        //data
        List<String> fruits = Arrays.asList("香蕉","蘋果","草莓");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,fruits);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_LOGIN){
            if(resultCode !=RESULT_OK){
                finish();
            }else{
                logon = true;
                if(!user.isValid()){
                    Intent nickname = new Intent(this, NickNameActivity.class);
                    startActivity(nickname);
                }
            }
        }
    }
}

                /*
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
                    */


