package com.example.makeupkit.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.makeupkit.Activities.DetailsOfProduct;
import com.example.makeupkit.Models.MakeupProducts;
import com.example.makeupkit.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter< CustomAdapter.MyViewHolder > {

    private final List< MakeupProducts > makeUPProducts;
    LayoutInflater inflater;
    Context context;

    public CustomAdapter(Context context, List< MakeupProducts > MakeupProductsList) {
        this.context = context;
        this.makeUPProducts = MakeupProductsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.setNameToView.setText(makeUPProducts.get(position).getName());
        holder.setBrandsToView.setText(makeUPProducts.get(position).getBrand());
        holder.setpriceToView.setText(String.valueOf(makeUPProducts.get(position).getPrice()));
        Picasso.get().load(makeUPProducts.get(position).getImageLink()).into(holder.setimageToView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Test Data", String.valueOf(makeUPProducts.get(position).getBrand()));
                Intent intent = new Intent(context, DetailsOfProduct.class).putExtra("data", makeUPProducts.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return makeUPProducts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView setNameToView, setBrandsToView, setpriceToView;
        ImageView setimageToView;

        public MyViewHolder(View itemView) {
            super(itemView);
            setNameToView = (TextView) itemView.findViewById(R.id.productName);
            setBrandsToView = (TextView) itemView.findViewById(R.id.productBrands);
            setpriceToView = (TextView) itemView.findViewById(R.id.productPrice);
            setimageToView = (ImageView) itemView.findViewById(R.id.productImage);
        }
    }
}