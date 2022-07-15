package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText usr_nameEtId,pwd_EtId;
    AppCompatButton submitBtnId;
    TextView sign_in_tvId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usr_nameEtId=findViewById(R.id.usr_nameEtId);
        pwd_EtId=findViewById(R.id.pwd_EtId);
        submitBtnId=findViewById(R.id.submitBtnId);
        sign_in_tvId=findViewById(R.id.sign_in_tvId);

        submitBtnId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String uname=usr_nameEtId.getText().toString();
                String pwd=pwd_EtId.getText().toString();

                if (uname.isEmpty()){
                    usr_nameEtId.setError("User Name Can not be empty");
                }
                if (pwd.isEmpty()){
                    pwd_EtId.setError("Password Can not be empty");
                }

                submitBtnId.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SharedPreferences prefs = getSharedPreferences("MY_SP_EDIT", MODE_PRIVATE);
                        String name = prefs.getString("ValueKey", "null");
                        String pwd_b = prefs.getString("PwdKey", "null");
                       //Toast.makeText(LoginActivity.this, name+pwd_b, Toast.LENGTH_SHORT).show();

                        if (uname. contentEquals(name) && pwd.contentEquals(pwd_b)){
                           Toast.makeText(LoginActivity.this, "user name matched:"+name, Toast.LENGTH_SHORT).show();
                                //startActivity(new Intent(LoginActivity.this,DashboardActivity.class));
                        }else {
                            Toast.makeText(LoginActivity.this, "user name not matched", Toast.LENGTH_SHORT).show();

                        }
//

                    }
                });

                sign_in_tvId.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));

                    }
                });

            }
        });

    }
}