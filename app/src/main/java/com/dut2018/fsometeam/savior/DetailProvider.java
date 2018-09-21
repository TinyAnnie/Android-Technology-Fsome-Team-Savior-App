package com.dut2018.fsometeam.savior;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DetailProvider extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_provider);
    }

    public void back_to_listprovider(View view) {
        Intent intent = new Intent(DetailProvider.this, MainListProvider.class);
        startActivity(intent);
    }
}
