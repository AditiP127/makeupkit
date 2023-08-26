package com.example.makeupkit.Activities;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.makeupkit.Adapter.ProductColorAdapter;
import com.example.makeupkit.Models.MakeupProducts;
import com.example.makeupkit.Models.ProductColor;
import com.example.makeupkit.R;

import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailsOfProduct extends AppCompatActivity {
    ImageView selectedImage;
    TextView nameToDisplay, BrandToDisplay,PriceTodisplay,TypeToDisplay,Description;
    String IDofProduct;
    Button Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details_of_product);
        nameToDisplay = (TextView) findViewById(R.id.nameTodisplay);
        selectedImage = (ImageView) findViewById(R.id.imageTodisplay);
        BrandToDisplay = (TextView) findViewById(R.id.BrandTodisplay);
        PriceTodisplay = (TextView) findViewById(R.id.PriceTodisplay);
        TypeToDisplay = (TextView) findViewById(R.id.TypeTodisplay);
        Description = (TextView) findViewById(R.id.Description);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        MakeupProducts products = (MakeupProducts) bundle.getSerializable("data");

        nameToDisplay.setText(products.getName());
        BrandToDisplay.setText(products.getBrand());
        TypeToDisplay.setText(products.getProductType());
        PriceTodisplay.setText(products.getPrice());
        Description.setText(products.getDescription());
        String ImgSrc = (products.getImageLink());
        Picasso.get().load(ImgSrc).into(selectedImage);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.colors_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,true);
        recyclerView.setLayoutManager(layoutManager);

        ProductColorAdapter adapter = new ProductColorAdapter(getApplicationContext(),  products.getProductColors());
        recyclerView.setAdapter(adapter);
    }
}