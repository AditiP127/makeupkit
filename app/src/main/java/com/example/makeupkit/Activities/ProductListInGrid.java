package com.example.makeupkit.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.makeupkit.Adapter.CustomAdapter;
import com.example.makeupkit.Interface.JsonHolder;
import com.example.makeupkit.Models.MakeupProducts;
import com.example.makeupkit.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductListInGrid extends AppCompatActivity {

    RecyclerView recyclerView;
    CustomAdapter Aadapter;
    ProgressDialog progressDialog;
    private ArrayList< MakeupProducts > data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list_in_grid);


        progressDialog = ProgressDialog.show(this, "", "Please Wait...", true);

        initViews();
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        loadJSON();
    }

    private void loadJSON() {
        Intent intent = getIntent();
        String productType = intent.getStringExtra("param");

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.writeTimeout(30, TimeUnit.SECONDS);
        client = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("http://makeup-api.herokuapp.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonHolder jsonHolder = retrofit.create(JsonHolder.class);
        Call< List< MakeupProducts > > call = jsonHolder.getProducts(productType);

        call.enqueue(new Callback< List< MakeupProducts > >() {
            @Override
            public void onResponse(Call< List< MakeupProducts > > call, @NotNull Response< List< MakeupProducts > > response) {
                Aadapter = new CustomAdapter(ProductListInGrid.this, response.body());
                recyclerView.setAdapter(Aadapter);
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call< List< MakeupProducts > > call, Throwable t) {
            }
        });
    }
}