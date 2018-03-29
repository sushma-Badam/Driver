package com.it.acumen.recurtingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.sql.Driver;

public class DriverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);
        Button s=(Button)findViewById(R.id.button2);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DriverActivity.this,saiActivity.class);
                startActivity(intent);
            }
        });
        Button s1=(Button)findViewById(R.id.button3);
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DriverActivity.this,saiActivity.class);
                startActivity(intent);
            }
        });

    }
}
