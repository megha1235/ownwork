package com.example.megha.ownpjct;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e2,e1;
    Button b1,b2;
    String s1,s2;
    dbhelper dbhelper1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     e1=(EditText)findViewById(R.id.user);
        e2=(EditText)findViewById(R.id.pass);
        b1=(Button)findViewById(R.id.log);
        b2=(Button)findViewById(R.id.reg);
        dbhelper1=new dbhelper(this);
        dbhelper1.getWritableDatabase();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                Cursor cur=dbhelper1.searchdata(s1);
                if (cur.getCount()==0)

                {
                    Toast.makeText(getApplicationContext(),"invalid Username or password",Toast.LENGTH_LONG).show();
                }
                else
                {
                    while (cur.moveToNext())
                    {
                        String dbpass=cur.getString(5);
                        String dbname=cur.getString(4);
                        if (dbpass.equals(s2))
                        {

                            SharedPreferences.Editor editor=getSharedPreferences("welcome",MODE_PRIVATE).edit();
                            editor.putString("username",dbname);
                            editor.apply();
                            Intent i=new Intent(getApplicationContext(),welcome.class);
                            startActivity(i);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"invalid",Toast.LENGTH_LONG).show();
                        }
                    }
                }


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),register.class);
                startActivity(i);
            }
        });

    }
}
