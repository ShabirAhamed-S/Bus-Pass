package com.example.buspass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity_forget extends AppCompatActivity {

    int f=0;
    Button a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        a = (Button) findViewById(R.id.np);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f=0;
                final EditText Email = (EditText) findViewById(R.id.eml2);
                final String email = Email.getText().toString();
                final String ep = getString(R.string.email);
                if (email.isEmpty())
                {
                    f = 1;
                    Email.setError("Enter your Email Address");
                }
                else if(!email.matches(ep))
                {
                    f=1;
                    Email.setError("Enter your valid Email address");
                }
                if (f == 0) {
                    Intent i = new Intent(Activity_forget.this, userpass.class);
                    startActivity(i);
                }
            }
        });
    }
}
