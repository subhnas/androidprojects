package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ProductGridAdp extends ArrayAdapter<ProductModel> {

    ImageView productImgId;
    TextView productTvId;


    public ProductGridAdp(@NonNull Context context, @NonNull ArrayList<ProductModel> objects) {
        super(context, 0, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view=convertView;

        if (view==null){
            view= LayoutInflater.from(getContext()).inflate(R.layout.card_item_grid_adp,parent,false);
        }

        productImgId=view.findViewById(R.id.productImgId);
        productTvId=view.findViewById(R.id.productTvId);

        ProductModel productModel=getItem(position);
        productImgId.setImageResource(productModel.getImage());
        productTvId.setText(productModel.getProductName());

        return view;
    }
}
