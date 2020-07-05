package com.example.androidproject;

public class IngredientData {
    private String INGREDIENT_NAME, INGREDIENT_CONCERN;
    private Float RATING;
    private Boolean SELECTED;

    public IngredientData(String INGREDIENT_NAME, Float RATING, String INGREDIENT_CONCERN) {
        this.INGREDIENT_NAME = INGREDIENT_NAME;
        this.RATING = RATING;
        this.INGREDIENT_CONCERN = INGREDIENT_CONCERN;
        this.SELECTED = false;
    }

    public String getINGREDIENT_NAME() {
        return INGREDIENT_NAME;
    }

    public String getINGREDIENT_CONCERN() {
        return INGREDIENT_CONCERN;
    }

    public Float getRATING() {
        return RATING;
    }

    public Boolean getSELECTED() {
        return SELECTED;
    }

    public void setSELECTED(Boolean SELECTED) {
        this.SELECTED = SELECTED;
    }
}
