package com.it.acumen.recurtingsystem;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

public class faActivity extends TutorialActivity {


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addFragment(new Step.Builder().setTitle("HIRE A DRIVER")
                .setContent("Drive around in the comfort of your car without worrying about driving or parking. Wherever you are headed and whatever be the occasion, our experienced, trained and background verified drivers will drive you around safely and securely at your convenience.")
                .setBackgroundColor(Color.parseColor("#072942")) // int background color
                .setDrawable(R.drawable.img0) // int top drawable
                .setSummary("We drive you so that you may go ahead and enjoy your life.")
                .build());
        addFragment(new Step.Builder().setTitle("Sit back and relax")
                .setContent("Relax as you get driven through the traffic in peace")
                .setBackgroundColor(Color.parseColor("#072942")) // int background color
                .setDrawable(R.drawable.img62) // int top drawable
                .setSummary("")
                .build());

        addFragment(new Step.Builder().setTitle("Driver arrives on time")
                .setContent("We take utmost care to ensure that you will never have to wait to start your ride.")
                .setBackgroundColor(Color.parseColor("#072942")) // int background color
                .setDrawable(R.drawable.img5) // int top drawable
                .setSummary("")
                .build());

        addFragment(new Step.Builder().setTitle("Make a booking")
                .setContent("Use our Android app to get a driver near you.")
                .setBackgroundColor(Color.parseColor("#072942")) // int background color
                .setDrawable(R.drawable.img4) // int top drawable
                .setSummary("")
                .build());

    }

    @Override
    public void finishTutorial() {
        Intent i = new Intent(faActivity.this,MainActivity.class);
        startActivity(i);
        // Your implementation
    }
}
