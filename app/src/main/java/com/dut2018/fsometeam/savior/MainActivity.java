package com.dut2018.fsometeam.savior;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    EditText edtUser,edtPass;
    Button btnSignIn,btnexit;
    TextView textSignUp;

    //code by NVL

    ListView listView;
    ArrayList<provider> listDataProvider;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //gach chan txt
        TextView txt = (TextView) findViewById(R.id.btn_sign_up);
        txt.setPaintFlags(txt.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        /////
        Anhxa();
        ////
        ControlButton();

    }


    private void ControlButton() {
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder exit_app = new AlertDialog.Builder(MainActivity.this,android.R.style.Theme_DeviceDefault_Dialog);
                exit_app.setTitle("Exit Savior?");
                exit_app.setIcon(android.R.drawable.ic_dialog_alert);
                exit_app.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
                exit_app.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                exit_app.show();
            }
        });

        textSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(MainActivity.this, SignUp.class);
                startActivity(m);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText a = (EditText)findViewById(R.id.edt_email);
                String str = a.getText().toString();

                EditText p = (EditText)findViewById(R.id.edt_pass);
                String pass = p.getText().toString();

                String password = helper.searchPass(str);
                if(pass.equals(password))
                {
                    Intent i = new Intent(MainActivity.this, Display.class);
                    //i.putExtra("Username",str);
                    startActivity(i);
                }
                else
                {
                    Toast pass_popup = Toast.makeText(MainActivity.this, "Phone number or Password don't match!", Toast.LENGTH_SHORT);
                    pass_popup.show();
                }

            }
        });
    }

    private void Anhxa()
    {
        btnexit = (Button)findViewById(R.id.btn_exit_app);
        edtUser = (EditText)findViewById(R.id.edt_email);
        edtPass = (EditText)findViewById(R.id.edt_pass);
        btnSignIn = (Button)findViewById(R.id.btn_sign_in);
        textSignUp = (TextView)findViewById(R.id.btn_sign_up);



    }

    public void to_NVL(View view) {
        setContentView(R.layout.activity_list_provider);
    }

    //code by NVL

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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void back_to_listprovider(View view) {

        setContentView(R.layout.activity_list_provider);
        show_listProvider();

    }

    public void back_to_mainMenu(View view) {
        setContentView(R.layout.activity_detail_provider);
    }
}
