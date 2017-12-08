package com.example.tulika.corpotask;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.List;

/**
 * Created by csa on 16-May-17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Myholder> implements View.OnClickListener {


    List<ProductModel> list;
Context context;
    ImageLoader imageLoader;
    public RecyclerAdapter(List<ProductModel> list, Context context, ImageLoader instance) {
        this.list = list;
        this.imageLoader=instance;
        this.context=context;
    }

    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show,parent,false);
        Myholder myHolder = new Myholder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {

        ProductModel product = list.get(position);
        holder.pname.setText(product.getCountry());
        holder.pcolor.setText(product.getRank());
        String image1 = product.getFlag();
        imageLoader.displayImage(image1, holder.pimage);
        holder.price.setText("Population"+product.getPopulation());
        holder.pimage.setTag(position);
        holder.pimage.setOnClickListener(this);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View view) {
        Integer pos = (Integer)view.getTag();
        Intent intent = new Intent(context, Detail.class);
        intent.putExtra("image",list.get(pos).getFlag() );
        context.startActivity(intent);

    }


    public class Myholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView pimage;
        TextView pname,pcolor,price;

        public Myholder(View itemView) {
            super(itemView);
            pimage = (ImageView) itemView.findViewById(R.id.productimage);
            pname = (TextView) itemView.findViewById(R.id.name);
            pcolor = (TextView) itemView.findViewById(R.id.color);
            price = (TextView) itemView.findViewById(R.id.price);

            }

        @Override
        public void onClick(View view) {

        }
    }
    }

