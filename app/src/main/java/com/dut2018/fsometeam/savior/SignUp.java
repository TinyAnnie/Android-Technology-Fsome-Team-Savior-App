package com.dut2018.fsometeam.savior;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {


    DatabaseHelper helper = new DatabaseHelper(this);
    Button btnSignUp,btnExit;
    EditText name,phonenumber,pass,repass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Anhxa();
        ControlButton();

    }

    private void Anhxa()
    {
        btnExit = (Button) findViewById(R.id.btn_exit_app);
        btnSignUp = (Button)findViewById(R.id.btn_sign_up);
        name = (EditText)findViewById(R.id.edt_name);
        phonenumber = (EditText)findViewById(R.id.edt_email);
        pass = (EditText)findViewById(R.id.edt_pass);
        repass = (EditText)findViewById(R.id.edt_re_pass);
    }

    private void ControlButton(){
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_str = name.getText().toString();
                String phonenumber_str = phonenumber.getText().toString();
                String pass_str = pass.getText().toString();
                String repass_str = repass.getText().toString();

                if(!pass_str.equals(repass_str))
                {
                    //popup msg
                    Toast pass_popup = Toast.makeText(SignUp.this, "Passwords don't match!", Toast.LENGTH_SHORT);
                    pass_popup.show();
                }
                else
                {
                    AccoutOfCustomer a = new AccoutOfCustomer();
                    a.setName(name_str);
                    a.setPhonenumber(phonenumber_str);
                    a.setPass(pass_str);

                    helper.insertAOCustomer(a);

                    Intent u = new Intent(SignUp.this, MainActivity.class);
                    startActivity(u);
                }

            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder exit_app = new AlertDialog.Builder(SignUp.this,android.R.style.Theme_DeviceDefault_Dialog);
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

    }


}
