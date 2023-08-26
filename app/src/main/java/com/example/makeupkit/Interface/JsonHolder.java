package com.example.makeupkit.Interface;

import com.example.makeupkit.Models.MakeupProducts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonHolder {
    @GET("products.json")
    Call< List< MakeupProducts > > getProducts(@Query("product_type") String product_type);
}


