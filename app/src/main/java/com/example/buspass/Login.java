package com.example.buspass;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
    TextView a, b;
    Button bb;
    int f=0;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");
    DatabaseReference mcondition = myRef.child("user login");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        a = (TextView) findViewById(R.id.fp);
        b = (TextView) findViewById(R.id.nu);
        Toast.makeText(Login.this, "Firebase connection Successfully", Toast.LENGTH_LONG).show();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, Activity2NewUser.class);
                startActivity(i);
            }
        });

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, Activity_forget.class);
                startActivity(i);
            }
        });
        bb=(Button)findViewById(R.id.lg);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f = 0;
                final EditText Us = (EditText) findViewById(R.id.usrnme);
                final String us = Us.getText().toString();
                final EditText Pss = (EditText) findViewById(R.id.pass);
                final String pss = Pss.getText().toString();
                if (us.isEmpty()) {
                    f = 1;
                    Us.setError("Enter your Username");
                }
                if (pss.isEmpty()) {
                    f = 1;
                    Pss.setError("Enter your Password");
                }
                if (f == 0) {
                    Toast.makeText(Login.this,"Login Successfully!",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login.this, UserLogin.class);
                    startActivity(i);
                }
            }
        });

    }


}
/*
 myRef.setValue("Hello, World!");
        bb = (Button) findViewById(R.id.lb);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, Home.class);
                startActivity(i);
                Toast toast = Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

@Override
  protected void onStart() {
        super.onStart();
        mcondition.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                a.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.setText("PASSWORD");
            }
        });

        }
    }
*/