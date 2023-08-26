package com.example.makeupkit.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.makeupkit.Models.ProductColor;
import com.example.makeupkit.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProductColorAdapter extends RecyclerView.Adapter< ProductColorAdapter.MyViewHolder > {
    private final List< ProductColor > ProductsColors;
    LayoutInflater inflater;
    Context context;

    public ProductColorAdapter(Context context, List< ProductColor > ProductsColors) {
        this.context = context;
        this.ProductsColors = ProductsColors;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        holder.tv_name.setText(ProductsColors.get(position).getColourName());
        holder.tv_value.setText(ProductsColors.get(position).getHexValue());
        holder.tv_name.setTextColor(Color.parseColor(ProductsColors.get(position).getHexValue()));
        holder.itemView.setBackgroundColor(Color.parseColor(ProductsColors.get(position).getHexValue()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return ProductsColors.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name, tv_value;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.Colorname);
            tv_value = (TextView) itemView.findViewById(R.id.hexValue);
        }
    }
}
