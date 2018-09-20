package com.dut2018.fsometeam.savior;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_app);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent signin = new Intent(MainActivity.this,SignIn.class);
                startActivity(signin);
            }
        },1000);

    }
}
