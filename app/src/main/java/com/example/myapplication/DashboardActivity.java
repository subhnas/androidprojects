package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    //  GridView grid_vw_id;
   RecyclerView grid_vw_id;
    ArrayList<ProductModel> productModelArrayList=new ArrayList<ProductModel>();
    ProductGridAdp productGridAdp;
    ProductRecycleAdp productRecycleAdp;

    TextView usr_nm_tv_id,pwd_tv_id;

    GridLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        usr_nm_tv_id=findViewById(R.id.usr_nm_tv_id);
        pwd_tv_id=findViewById(R.id.pwd_tv_id);



        SharedPreferences prefs = getSharedPreferences("MY_SP_EDIT", MODE_PRIVATE);
        String name = prefs.getString("ValueKey", "null");
        String pwd_b = prefs.getString("PwdKey", "null");

        usr_nm_tv_id.setText(name);
        pwd_tv_id.setText(pwd_b);



       // grid_vw_id=findViewById(R.id.grid_vw_id);

        layoutManager = new GridLayoutManager(this, 2);
        grid_vw_id = (RecyclerView) findViewById(R.id.grid_vw_id);
        grid_vw_id.setHasFixedSize(true);
        grid_vw_id.setLayoutManager(layoutManager);


        productModelArrayList.add(new ProductModel("Apple",R.drawable.apple_img));
        productModelArrayList.add(new ProductModel("Guava",R.drawable.guava_img));
        productModelArrayList.add(new ProductModel("Mango",R.drawable.mango_img));
        productModelArrayList.add(new ProductModel("Litchi",R.drawable.litchi_img));
        productModelArrayList.add(new ProductModel("Orange",R.drawable.orange_img));
        productModelArrayList.add(new ProductModel("Cherry",R.drawable.cherry_img));
        productModelArrayList.add(new ProductModel("Grapes",R.drawable.grapes_img));

       // productGridAdp=new ProductGridAdp(this,productModelArrayList);
        productRecycleAdp=new ProductRecycleAdp(this,productModelArrayList);

        //grid_vw_id.setAdapter(productGridAdp);
        grid_vw_id.setAdapter(productRecycleAdp);




    }
}