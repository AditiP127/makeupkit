package com.example.makeupkit.Models;

public class CategoriesModel {

    private String category_name;
    private int category_image_url;

    public int getCategory_image_url() {
        return category_image_url;
    }

    public void setCategory_image_url(int category_image_url) {
        this.category_image_url = category_image_url;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

}
