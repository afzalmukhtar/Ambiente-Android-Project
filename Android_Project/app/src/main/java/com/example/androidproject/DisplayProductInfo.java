package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class DisplayProductInfo extends AppCompatActivity {

    private static final String TAG = "DisplayProductInfo";
    private ArrayList<IngredientData> ingredientDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_product_info);
//        Log.d(TAG, "onCreate: Started");

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("ProductData");
        Bitmap bitmap = bundle.getParcelable("ProductImage");
        String productName = bundle.getString("ProductName");
        Float productRating = bundle.getFloat("ProductRating");

//        Log.d(TAG, "onCreate: Database Accessing");
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        ingredientDataList = databaseAccess.getIngredientList(productName);
        databaseAccess.close();
        Log.d(TAG, "onCreate: Data Accessed " + ingredientDataList.size());

        ImageView enlargedImage = findViewById(R.id.enlargedProductImage);
        ImageView smallImage = findViewById(R.id.smallProductImage);
        TextView productNameView = findViewById(R.id.DetailsPageProductName);
        RatingBar ProductRatingBar = findViewById(R.id.DetailsPageProductRating);

        enlargedImage.setImageBitmap(bitmap);
        smallImage.setImageBitmap(bitmap);
        productNameView.setText(productName);
        ProductRatingBar.setRating(productRating);


        RelativeLayout relativeLayout = findViewById(R.id.ProductInfoRelativeLayout);
        relativeLayout.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.delayed_fade_from_right));


        RecyclerView recyclerView = findViewById(R.id.IngredientList);
        recyclerView.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.view_loading_animation));
        IngredientDataAdapter ingredientDataAdapter = new IngredientDataAdapter(ingredientDataList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(ingredientDataAdapter);
    }
}
