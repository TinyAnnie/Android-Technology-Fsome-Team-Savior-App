package com.dut2018.fsometeam.savior;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainListProvider extends AppCompatActivity {

    ListView listView;
    ArrayList<provider> listDataProvider;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_provider);

        show_listProvider();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void show_listProvider(){
        listView = (ListView) findViewById(R.id.listViewProvider);
        createData();
        providerAdapter adapter = new providerAdapter(this, listDataProvider);

        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void createData() {
        listDataProvider = new ArrayList<provider>();
        listDataProvider.add(new provider("Honda", "Hòa Khánh", "6.7 km", getDrawable(R.drawable.honda)));
        listDataProvider.add(new provider("Yamaha", "Sơn Trà", "16.7 km", getDrawable(R.drawable.yamaha)));
        listDataProvider.add(new provider("Suzuki", "Hải Vân", "2 km", getDrawable(R.drawable.suzuki)));
        listDataProvider.add(new provider("Toyota", "Điện Biên Phủ", "10 km", getDrawable(R.drawable.toyota)));
    }

//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    public void back_to_listprovider(View view) {
//
//        setContentView(R.layout.activity_main_list_provider);
//        show_listProvider();
//
//    }
//
//
//
    public void back_to_mainScreen(View view) {
        Intent intent = new Intent(MainListProvider.this, DetailProvider.class);
        startActivity(intent);
    }
}
