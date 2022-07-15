package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView productNameTvId;
    String fruitName;
    ImageView back_btn_Img,productImageImgId;
    int image_value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);



        back_btn_Img=findViewById(R.id.back_btn_Img);
        productNameTvId=findViewById(R.id.productNameTvId);
        productImageImgId=findViewById(R.id.productImageImgId);

        back_btn_Img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Intent intent=getIntent();
        fruitName=intent.getStringExtra("fruitNameKey");
        productNameTvId.setText(fruitName);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {// if bundle is not null then get the image value
            image_value = bundle.getInt("fruitImageKey");
        }
        productImageImgId.setImageResource(image_value);
    }
}