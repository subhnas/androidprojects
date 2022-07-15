package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView showData_tv_Id;
    EditText data_et_Id,pwd_et_Id;
    AppCompatButton saveBtnId,showBtnId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        showData_tv_Id=findViewById(R.id.showData_tv_Id);
        data_et_Id=findViewById(R.id.data_et_Id);
        pwd_et_Id=findViewById(R.id.pwd_et_Id);
        saveBtnId=findViewById(R.id.saveBtnId);
        showBtnId=findViewById(R.id.showBtnId);


        saveBtnId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Toast.makeText(MainActivity.this, "saveBtnId", Toast.LENGTH_SHORT).show();
                String str=data_et_Id.getText().toString();
                String pwd=pwd_et_Id.getText().toString();
                if (str.isEmpty()){
                    data_et_Id.setError("User Name can not be empty");
                }
                if (pwd.isEmpty()){
                    data_et_Id.setError("Password can not be empty");
                }
                SharedPreferences.Editor speditor=getSharedPreferences("MY_SP_EDIT",MODE_PRIVATE).edit();
                speditor.putString("ValueKey",str);
                speditor.putString("PwdKey",pwd);
                speditor.apply();
            }
        });

        showBtnId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "showBtnId", Toast.LENGTH_SHORT).show();
                SharedPreferences prefs = getSharedPreferences("MY_SP_EDIT", MODE_PRIVATE);
                String name = prefs.getString("ValueKey", "null");
                String pwd_b = prefs.getString("PwdKey", "null");
                showData_tv_Id.setText(name+pwd_b);
            }
        });



        SharedPreferences prefs_actvt = getSharedPreferences("MY_SP_EDIT", MODE_PRIVATE);
        String name_actvt = prefs_actvt.getString("ValueKey", "null");
        String pwd_a = prefs_actvt.getString("PwdKey", "null");
        if (name_actvt.equalsIgnoreCase("Hello World!")){
            showBtnId.setVisibility(View.VISIBLE);
            saveBtnId.setVisibility(View.VISIBLE);
            data_et_Id.setVisibility(View.VISIBLE);
            pwd_et_Id.setVisibility(View.VISIBLE);
        }
        else {
            showBtnId.setVisibility(View.GONE);
            saveBtnId.setVisibility(View.GONE);
            data_et_Id.setVisibility(View.GONE);
            pwd_et_Id.setVisibility(View.GONE);

            showData_tv_Id.setText(name_actvt+pwd_a);
        }


        showData_tv_Id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBtnId.setVisibility(View.VISIBLE);
                saveBtnId.setVisibility(View.VISIBLE);
                data_et_Id.setVisibility(View.VISIBLE);
                pwd_et_Id.setVisibility(View.VISIBLE);
            }
        });

    }
}