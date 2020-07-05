package com.example.androidproject;

public class CategoryData {
    private String CATEGORY_NAME;
    private Integer CATEGORY_IMAGE;
    private Boolean SELECTED;

    public CategoryData(String CATEGORY_NAME, Integer CATEGORY_IMAGE) {
        this.CATEGORY_NAME = CATEGORY_NAME;
        this.CATEGORY_IMAGE = CATEGORY_IMAGE;
        this.SELECTED = false;
    }

    public String getCATEGORY_NAME() {
        return CATEGORY_NAME;
    }

    public Integer getCATEGORY_IMAGE() {
        return CATEGORY_IMAGE;
    }

    public Boolean getSELECTED() {
        return SELECTED;
    }

    public void setSELECTED(Boolean SELECTED) {
        this.SELECTED = SELECTED;
    }
}
