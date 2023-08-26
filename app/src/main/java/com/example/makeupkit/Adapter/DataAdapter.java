package com.example.makeupkit.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.makeupkit.Activities.ProductListInGrid;
import com.example.makeupkit.Models.CategoriesModel;
import com.example.makeupkit.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter< DataAdapter.ViewHolder > {
    private ArrayList< CategoriesModel > categoriesModelList;
    private Context context;

    public DataAdapter(Context context, ArrayList< CategoriesModel > categoriesModelList) {
        this.categoriesModelList = categoriesModelList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout_of_categories, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.tv_name.setText(categoriesModelList.get(position).getCategory_name());
        holder.img_display.setImageResource(categoriesModelList.get(position).getCategory_image_url());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = Integer.parseInt(String.valueOf(position));
                if (temp == 0) {
                    Intent intent = new Intent(context, ProductListInGrid.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("param", "lipstick");
                    context.startActivity(intent);
                }
                if (temp == 1) {
                    Intent intent = new Intent(context, ProductListInGrid.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("param", "lip_liner");
                    context.startActivity(intent);
                }
                if (temp == 2) {
                    Intent intent = new Intent(context, ProductListInGrid.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("param", "blush");
                    context.startActivity(intent);
                }
                if (temp == 3) {
                    Intent intent = new Intent(context, ProductListInGrid.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("param", "foundation");
                    context.startActivity(intent);
                }
                if (temp == 4) {
                    Intent intent = new Intent(context, ProductListInGrid.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("param", "eyeliner");
                    context.startActivity(intent);
                }
                if (temp == 5) {
                    Intent intent = new Intent(context, ProductListInGrid.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("param", "eyeshadow");
                    context.startActivity(intent);
                }
                if (temp == 6) {
                    Intent intent = new Intent(context, ProductListInGrid.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("param", "mascara");
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoriesModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private ImageView img_display;

        public ViewHolder(View view) {
            super(view);
            tv_name = (TextView) view.findViewById(R.id.category_name);
            img_display = (ImageView) view.findViewById(R.id.img_category);
        }
    }
}
