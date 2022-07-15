package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;

public class ProductRecycleAdp extends RecyclerView.Adapter<ProductRecycleAdp.MyviewHolder> {

    Context context;
    ArrayList list;

    public ProductRecycleAdp(Context context, ArrayList list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ProductRecycleAdp.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.card_item_grid_adp,parent,false);
        MyviewHolder myviewHolder=new MyviewHolder(view);
        return myviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductRecycleAdp.MyviewHolder holder, int position) {

        ProductModel productModel= (ProductModel) list.get(position);
        holder.productImgId.setImageResource(productModel.getImage());
        holder.productTvId.setText(productModel.getProductName());


        int view_pos= holder.getLayoutPosition();
        for (int i=1 ; i<= list.size() ; i+=2){
            if (view_pos==i){
                holder.productImgId.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
            }
        }



        holder.card_vw_Id.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {

                String fruitNm=holder.productTvId.getText().toString();

                Intent intent=new Intent(context,DetailsActivity.class);
                intent.putExtra("fruitNameKey",fruitNm);
                intent.putExtra("fruitImageKey",productModel.getImage());
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {

        ImageView productImgId;
        TextView productTvId;
        CardView card_vw_Id;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);

            productImgId=itemView.findViewById(R.id.productImgId);
            productTvId=itemView.findViewById(R.id.productTvId);
            card_vw_Id=itemView.findViewById(R.id.card_vw_Id);
        }
    }
}
