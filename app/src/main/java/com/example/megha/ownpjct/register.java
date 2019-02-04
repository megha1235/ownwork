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

public class register extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    Button b1,b2;
    dbhelper dbhelper1;
    String s1,s2,s3,s4,s5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        e1=(EditText)findViewById(R.id.name);
        e2=(EditText)findViewById(R.id.email);
        e3=(EditText)findViewById(R.id.ph);
        e4=(EditText)findViewById(R.id.username);
        e5=(EditText)findViewById(R.id.password);
        b1=(Button) findViewById(R.id.reg);
        b2=(Button)findViewById(R.id.btl);
        dbhelper1=new dbhelper(this);
        dbhelper1.getWritableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();
                s4=e4.getText().toString();
                s5=e5.getText().toString();

                       // Cursor cur=dbhelper1.searchdata(s4);
                boolean status=dbhelper1.insertdata(s1,s2,s3,s4,s5);
                if (status==true)
                {
                    Toast.makeText(getApplicationContext(),"inserted",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_LONG).show();
                }

               // if (cur.getCount()==0)

               // {
                //    Toast.makeText(getApplicationContext(),"invalid Username or password",Toast.LENGTH_LONG).show();
               // }
              //  else
               // {
                 //   while (cur.moveToNext())
                 //   {
                  //      String dbpass=cur.getString(5);
                  //      String dbname=cur.getString(4);
                    //    if (dbpass.equals(s5))
                   //     {
                    //        Intent i=new Intent(getApplicationContext(),welcome.class);
                    //        startActivity(i);

                    //    }
                     //   else
                     //   {
                       //     Toast.makeText(getApplicationContext(),"invalid",Toast.LENGTH_LONG).show();
                      //  }
                   // }
               // }


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent f=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(f);
            }

        });

    }
}
