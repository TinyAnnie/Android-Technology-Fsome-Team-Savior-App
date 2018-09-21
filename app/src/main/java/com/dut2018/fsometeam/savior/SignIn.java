package com.dut2018.fsometeam.savior;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;





public class SignIn extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    EditText edtUser,edtPass;
    Button btnSignIn,btnexit;
    TextView textSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

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
                AlertDialog.Builder exit_app = new AlertDialog.Builder(SignIn.this,android.R.style.Theme_DeviceDefault_Dialog);
                exit_app.setTitle("Exit Savior?");
                exit_app.setIcon(android.R.drawable.ic_dialog_alert);
                exit_app.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //quay ve activity main
                        Intent i = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);
                        //thoat app
                        Intent ex = new Intent(Intent.ACTION_MAIN);
                        ex.addCategory(Intent.CATEGORY_HOME);
                        startActivity(ex);
                        finish();
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
                Intent m = new Intent(SignIn.this, SignUp.class);
                startActivity(m);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent s = new Intent(SignIn.this,MainListProvider.class);
                startActivity(s);
                /*
                EditText a = (EditText)findViewById(R.id.edt_email);
                String str = a.getText().toString();

                EditText p = (EditText)findViewById(R.id.edt_pass);
                String pass = p.getText().toString();

                String password = helper.searchPass(str);
                if(pass.equals(password))
                {
                    Intent i = new Intent(SignIn.this, Display.class);
                    //i.putExtra("Username",str);
                    startActivity(i);
                }
                else
                {
                    Toast pass_popup = Toast.makeText(SignIn.this, "Phone number or Password don't match!", Toast.LENGTH_SHORT);
                    pass_popup.show();
                }*/

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

}