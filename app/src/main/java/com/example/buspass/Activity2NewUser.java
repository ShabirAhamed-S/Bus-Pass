package com.example.buspass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Activity2NewUser extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button sub;
    int f=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState);
        setContentView(R.layout.activity_activity2_new_user);
        Spinner spinner=(Spinner) findViewById(R.id.state);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.State,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        sub=(Button)findViewById(R.id.reg);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText Fname=(EditText) findViewById(R.id.fn);
                final String fname=Fname.getText().toString();
                final EditText Lname=(EditText) findViewById(R.id.ln);
                final String lname=Lname.getText().toString();
                final EditText Fatname=(EditText) findViewById(R.id.fan);
                final String fatname=Fatname.getText().toString();
                final EditText Motname=(EditText) findViewById(R.id.mn);
                final String motname=Motname.getText().toString();
                final EditText Addr=(EditText) findViewById(R.id.addr);
                final String addr=Addr.getText().toString();
                final EditText Potaddr=(EditText) findViewById(R.id.potadd);
                final String potaddr=Potaddr.getText().toString();
                final EditText Phnum=(EditText) findViewById(R.id.pn);
                final String phnum=Phnum.getText().toString();
                final EditText Email=(EditText) findViewById(R.id.eml);
                final String email=Email.getText().toString();
                final String ep=getString(R.string.email);
                f=0;
                if (fname.isEmpty()) {
                    f = 1;
                    Fname.setError("Enter your First Name");
                }
                if (lname.isEmpty())
                {
                    f=1;
                    Lname.setError("Enter your Last Name");
                }
                if (fatname.isEmpty())
                {
                    f=1;
                    Fatname.setError("Enter your Father Name");
                }
                if (motname.isEmpty())
                {
                    f = 1;
                    Motname.setError("Enter your Mother Name");
                }
                if (addr.isEmpty()) {
                    f = 1;
                    Addr.setError("Enter your Address");
                }
                if (potaddr.isEmpty())
                {
                    f=1;
                    Potaddr.setError("Enter your Postal Address");
                }
                if (phnum.isEmpty()) {
                    f = 1;
                    Phnum.setError("Enter your Phone Number");
                }
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
                if(f==0){
                    Toast.makeText(Activity2NewUser.this,"Registration successfully!",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Activity2NewUser.this,Login.class);
                    startActivity(i);
                }

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text=parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
