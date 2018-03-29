package com.it.acumen.recurtingsystem;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main6Activity extends AppCompatActivity {

    private TextView reg;
    private EditText user_name;
    private EditText password;
    private Button lgbt;
    private FirebaseAuth mAuth;
    private ProgressDialog prodia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        reg=(TextView)findViewById(R.id.register);
        user_name=(EditText) findViewById(R.id.name);
        password=(EditText)findViewById(R.id.password);
        lgbt=(Button)findViewById(R.id.lbutton);
        mAuth=FirebaseAuth.getInstance();
        prodia=new ProgressDialog(this);
        FirebaseUser user=mAuth.getCurrentUser();
        lgbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(user_name.getText().toString(),password.getText().toString());
                /*Intent intent=new Intent(Main6Activity.this,NavActivity.class);
                startActivity(intent);*/
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main6Activity.this,Main7Activity.class));
            }
        });
    }
    private void validate(String username,String password)
    {
        prodia.setMessage("please wait for login:)");
        prodia.show();
        mAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    prodia.dismiss();
                    Toast.makeText(Main6Activity.this,"Login success",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Main6Activity.this,NavActivity.class));
                }
                else
                {
                    Toast.makeText(Main6Activity.this,"Login failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
