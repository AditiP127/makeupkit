package com.example.makeupkit.Activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.makeupkit.Adapter.DataAdapter;
import com.example.makeupkit.Models.CategoriesModel;
import com.example.makeupkit.R;

import java.util.ArrayList;

public class CategoriesOfProducts extends AppCompatActivity {
    private long pressedTime;

    String[] Values = {
            "Lipstick",
            "Lip Liner",
            "Blush",
            "Foundation",
            "Eyeliner",
            "Eyeshadow",
            "Mascara"};

    int images[] = {
            R.drawable.lipstick,
            R.drawable.lips,
            R.drawable.blush,
            R.drawable.foundation,
            R.drawable.eyeliner,
            R.drawable.eyeshadow,
            R.drawable.mascara};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_of_products);
        initViews();
    }

    @Override
    public void onBackPressed() {
        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }

    private void initViews() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.nameLst);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList< CategoriesModel > CategoryList = prepareData();
        DataAdapter adapter = new DataAdapter(getApplicationContext(), CategoryList);
        recyclerView.setAdapter(adapter);
    }

    public ArrayList< CategoriesModel > prepareData() {
        ArrayList< CategoriesModel > list_version = new ArrayList<>();
        for (int i = 0; i < Values.length; i++) {
            CategoriesModel ModelObj = new CategoriesModel();
            ModelObj.setCategory_name(Values[i]);
            ModelObj.setCategory_image_url(images[i]);
            list_version.add(ModelObj);
        }
        return list_version;
    }
}