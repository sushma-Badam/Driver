package com.it.acumen.recurtingsystem;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main3Activity extends AppCompatActivity {
    private EditText dusername;
    private EditText duserpassword;
    private EditText duseremail;
    private EditText duseraddress;
    private EditText dphno;
    private Button rbtn;
    private FirebaseAuth firebaseAuth;
    FirebaseDatabase database1;
    DatabaseReference myref1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setupviews();
        database1=FirebaseDatabase.getInstance();
        firebaseAuth=FirebaseAuth.getInstance();
        rbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate())
                {
                    String child=dusername.getText().toString();
                    myref1=database1.getReference("users").child("drivers").child(child);
                    myref1.child("name").setValue(dusername.getText().toString());
                    myref1.child("email").setValue(duseremail.getText().toString());
                    myref1.child("password").setValue(duserpassword.getText().toString());
                    myref1.child("address").setValue(duseraddress.getText().toString());
                    myref1.child("phno").setValue(dphno.getText().toString());
                    String user_email=duseremail.getText().toString().trim();
                    String user_pass=duserpassword.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(Main3Activity.this,"registration succesfull",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(Main3Activity.this,"registration failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }


            }
        });
    }
    private boolean validate()
    {
        boolean res=false;
        String name=dusername.getText().toString();
        String password=duserpassword.getText().toString();
        String email=duseremail.getText().toString();
        if(name.isEmpty()&&password.isEmpty()&&email.isEmpty())
        {
            Toast.makeText(this,"enter all details",Toast.LENGTH_SHORT).show();
        }
        else
        {
            res=true;
        }
        return res;
    }
    private void setupviews(){
        dusername=(EditText)findViewById(R.id.dr_name);
        duserpassword=(EditText)findViewById(R.id.dr_password);
        duseremail=(EditText)findViewById(R.id.dr_email);
        duseraddress=(EditText)findViewById(R.id.dr_address);
        dphno=(EditText)findViewById(R.id.dr_phno);
        rbtn=(Button)findViewById(R.id.dr_button);
    }
}
