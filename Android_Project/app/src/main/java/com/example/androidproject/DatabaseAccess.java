package com.example.androidproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class DatabaseAccess {
    // LOG to help in debugging
    private static final String TAG = "DatabaseAccess";
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;

    //SQLiteAssetHelper Retrieves the Database from the asset folder
    //Open helper provides functions to open the DB
    //SQLiteDatabase provides database functionality

    //Constructor to get DatabaseHelper object
    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseHelper(context);
    }

    //Override getInstance from DatabaseAccess
    public static DatabaseAccess getInstance(Context context){
        if (instance == null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    //Function to Open Database
    public void open(){
        this.db = openHelper.getWritableDatabase();
    }

    //Function to Close Database
    public void close(){
        if (db != null){
            this.db.close();
        }
    }

    //DONE TODO get List of Products
    public ArrayList<ProductData> getProductList(String CategoryName){
        Cursor cursor = db.rawQuery("SELECT product_name, rating, image FROM Data_Overview WHERE category = '" + CategoryName + "'", null);
        ArrayList<ProductData> PRODUCT_LIST = new ArrayList<>();

        while (cursor.moveToNext()){
            String temp_product_name = cursor.getString(0);
            Float temp_rating = 5.0f -  Float.parseFloat(cursor.getString(1))/2;
            byte[] temp_image = cursor.getBlob(2);
            Bitmap temp_bitmap = BitmapFactory.decodeByteArray(temp_image, 0, temp_image.length);
            ProductData productData = new ProductData(temp_product_name, temp_rating, temp_bitmap);
            PRODUCT_LIST.add(productData);
        }
        cursor.close();
        return PRODUCT_LIST;
    }


    //TODO get List of Ingredients
    public ArrayList<IngredientData> getIngredientList(String ProductName){
        ArrayList<IngredientData> INGREDIENT_LIST = new ArrayList<>();
        String[] List_of_Ingredients = null;
        Cursor cursor = db.rawQuery("SELECT ingredients FROM Product_Ingredient Where product_name = '" + ProductName + "'", null);
        while (cursor.moveToNext()){
            String temp_ingredient = cursor.getString(0);
            List_of_Ingredients = temp_ingredient.split("\\|\\|");
        }

        for (String ingredient_name : List_of_Ingredients){
            cursor = db.rawQuery("SELECT rating, concern FROM Ingredient_Data Where ingredient_name = '" + ingredient_name.trim() + "'", null);
            while (cursor.moveToNext()){
                Float temp_rating = 5.0f - Float.parseFloat(cursor.getString(0))/2;
                String temp_concern = cursor.getString(1);
                if (temp_concern.length() != 0){
                    temp_concern = "\u2022 " + temp_concern.replaceAll("\\|", "\n\u2022 ");
                }else {
                    temp_concern = null;
                }
                IngredientData ingredientData = new IngredientData(ingredient_name, temp_rating, temp_concern);
                INGREDIENT_LIST.add(ingredientData);
            }
        }
        cursor.close();
        return INGREDIENT_LIST;
    }
}
