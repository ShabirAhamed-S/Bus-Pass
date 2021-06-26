package com.example.buspass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class userpass extends AppCompatActivity {

    Button a;
    int f=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userpass);
        a=(Button)findViewById(R.id.np);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText Us = (EditText) findViewById(R.id.usrnme2);
                final String us = Us.getText().toString();
                final EditText Pss = (EditText) findViewById(R.id.pass1);
                final String pss = Pss.getText().toString();
                final EditText Rpss = (EditText) findViewById(R.id.pass2);
                final String rpss = Rpss.getText().toString();
                if (us.isEmpty()) {
                    f = 1;
                    Us.setError("Enter your Username");
                }
                if (pss.isEmpty()) {
                    f = 1;
                    Pss.setError("Enter your Password");
                }
                if (rpss.isEmpty()) {
                    f = 1;
                    Rpss.setError("Re-enter your Password");
                }
                else if(pss!=rpss){
                    f=1;
                    Rpss.setError("Incorrect Password");
                }

                if (f == 0) {
                    Toast.makeText(userpass.this,"Created Uername Successfully!",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(userpass.this, Login.class);
                    startActivity(i);
                }
            }
        });

    }
}
