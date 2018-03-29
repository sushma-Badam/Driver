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

public class Main2Activity extends AppCompatActivity {

    private TextView reg1;
    private EditText user_name1;
    private EditText password1;
    private Button lgbt1;
    private FirebaseAuth mAuth1;
    private ProgressDialog prodia1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        reg1=(TextView)findViewById(R.id.driver_text);
        user_name1=(EditText) findViewById(R.id.driver_name);
        password1=(EditText)findViewById(R.id.driver_password);
        lgbt1=(Button)findViewById(R.id.driver_login_bt);
        mAuth1=FirebaseAuth.getInstance();
        prodia1=new ProgressDialog(this);
        FirebaseUser user=mAuth1.getCurrentUser();
        lgbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(user_name1.getText().toString(),password1.getText().toString());
                /*Intent intent=new Intent(Main6Activity.this,NavActivity.class);
                startActivity(intent);*/
            }
        });
        reg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main2Activity.this,Main3Activity.class));
            }
        });
    }
    private void validate(String username,String password)
    {
        prodia1.setMessage("please wait for login:)");
        prodia1.show();
        mAuth1.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    prodia1.dismiss();
                    Toast.makeText(Main2Activity.this,"Login success",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Main2Activity.this,NavActivity.class));
                }
                else
                {
                    Toast.makeText(Main2Activity.this,"Login failed",Toast.LENGTH_SHORT).show();
                }
            }
            //ghfg
        });
    }
}
