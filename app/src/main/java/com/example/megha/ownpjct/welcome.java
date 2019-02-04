package com.example.megha.ownpjct;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class welcome extends AppCompatActivity {
    TextView tv;
    String getusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        tv=(TextView)findViewById(R.id.tv);
        SharedPreferences editor=getSharedPreferences("welcome",MODE_PRIVATE);
                getusername=editor.getString("username",null);
        tv.setText("welcome "+getusername);
    }
}
