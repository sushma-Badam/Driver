package com.it.acumen.recurtingsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private Button cbt;
    private Button dbt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cbt=(Button)findViewById(R.id.customer);
        dbt=(Button)findViewById(R.id.driver);
       cbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte=new Intent(MainActivity.this,Main6Activity.class);
                startActivity(inte);
            }
        });
       dbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte1=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(inte1);
            }
        });
    }
}
