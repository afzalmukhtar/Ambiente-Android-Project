package com.example.androidproject;

import android.graphics.Bitmap;

public class ProductData {
    private String PRODUCT_NAME;
    private Float PRODUCT_RATING;
    private Bitmap PRODUCT_IMAGE;

    public ProductData(String PRODUCT_NAME, Float PRODUCT_RATING, Bitmap PRODUCT_IMAGE) {
        this.PRODUCT_NAME = PRODUCT_NAME;
        this.PRODUCT_RATING = PRODUCT_RATING;
        this.PRODUCT_IMAGE = PRODUCT_IMAGE;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public Float getPRODUCT_RATING() {
        return PRODUCT_RATING;
    }

    public Bitmap getPRODUCT_IMAGE() {
        return PRODUCT_IMAGE;
    }
}
