package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements CategoryDataAdapter.ClickAdapterEvent {

    //DONE TODO Create Log for Debugging
    private static final String TAG = "MainActivity";

    //DONE TODO Create DatabaseHelper and DatabaseAccess Classes

    //DONE TODO Create Classes which stores the data for each section
    //DONE TODO i.e. CategoryData Class which is used to store category info
    //DONE TODO i.e. ProductData Class which is used to store product info for each category
    //DONE TODO i.e. IngredientData Class which is used to store ingredient info for each product

    //DONE TODO Create MainActivity UI
    //DONE TODO Create ArrayList<CategoryData> which will be used to display info in category part of the MainActivity


    //DONE TODO Create CategoryDataAdapter Class to adapt the ArrayList<CategoryData> to the Category section
    //DONE TODO Set the Adapter

    //DONE TODO Create ProductListFragment which will be used to display product info for the selected category
    //DONE TODO Create ArrayList<ProductData> which is used to display info of the clicked Category in Product part of the Fragment
    //DONE TODO Create ProductDataAdapter Class to adapt the ArrayList<ProductData> to Product section
    //DONE TODO Set the Adapter

    //DONE TODO Create DisplayProductInfo Class Activity which will be used to display the clicked Product Info
    //DONE TODO Create DisplayProductInfo Activity UI
    //DONE TODO Create ArrayList<IngredientData> which is used to display info of the clicked Product ingredients in DisplayProductInfo Activity
    //DONE TODO Create IngredientDataAdapter to adapt the ArrayList<IngredientData> to Ingredient section
    //DONE TODO Set the Adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<CategoryData> categoryDataList = createCategoryList();
        initCategoryRecyclerView(categoryDataList);
        ImageView userIcon, helpIcon;
        userIcon = findViewById(R.id.aboutDesigners);
        helpIcon = findViewById(R.id.AboutApp);

        userIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutUs.class);
                startActivity(intent);
            }
        });

        helpIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutApp.class);
                startActivity(intent);
            }
        });

    }

    private void initCategoryRecyclerView(ArrayList<CategoryData> categoryDataList) {
        RecyclerView recyclerView = findViewById(R.id.main_activity_category_recycle_view);
        CategoryDataAdapter adapter = new CategoryDataAdapter(this, categoryDataList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
    }

    protected ArrayList<CategoryData> createCategoryList(){

        CategoryData []categoryDataArray = {
                new CategoryData("Bronzer / Highlighter", R.drawable.bronzer_highlighter),
                new CategoryData("Brow Liner", R.drawable.brow_liner),
                new CategoryData("Concealer", R.drawable.concealer),
                new CategoryData("Eye Liner", R.drawable.eye_liner),
                new CategoryData("Eye Makeup Remover", R.drawable.eye_makeup_remover),
                new CategoryData("Eye Shadow", R.drawable.eye_shadow),
                new CategoryData("Eyelash Glue", R.drawable.eyelash_glue),
                new CategoryData("Facial Powder", R.drawable.facial_powder),
                new CategoryData("Foundation", R.drawable.foundation),
                new CategoryData("Lip Balm", R.drawable.lipbalm),
                new CategoryData("Lip Balm with SPF", R.drawable.lipbalm_with_spf),
                new CategoryData("Lip Gloss", R.drawable.lip_gloss),
                new CategoryData("Lip Liner", R.drawable.lip_liner),
                new CategoryData("Lip Plumper", R.drawable.lip_plumper),
                new CategoryData("Lipstick", R.drawable.lipstick),
                new CategoryData("Makeup Primer", R.drawable.makeup_primer),
                new CategoryData("Makeup Remover", R.drawable.makeup_remover),
                new CategoryData("Makeup with SPF", R.drawable.makeup_with_spf),
                new CategoryData("Mascara", R.drawable.mascara),
                new CategoryData("Other Eye Makeup", R.drawable.other_eye_makeup)
        };

        ArrayList<CategoryData> categoryData = new ArrayList<>();
        categoryData.addAll(Arrays.asList(categoryDataArray));
        return categoryData;

    }

    @Override
    public void onCategoryClick(RelativeLayout categoryCardLayout,
                                ArrayList<CategoryData> categoryData,
                                int position,
                                RelativeLayout prevSelected) {
//        Log.d(TAG, "onCategoryClick: Clicked");


        categoryCardLayout.setBackground(getDrawable(R.drawable.selected_category));
        categoryCardLayout.setClickable(false);
//        Log.d(TAG, "onCategoryClick: Set");
        if (categoryCardLayout != prevSelected && prevSelected != null){
            prevSelected.setBackground(getDrawable(R.drawable.category_card_design));
            prevSelected.setClickable(true);
        }

        TextView initialText = findViewById(R.id.InitialText);
        if (initialText.getVisibility() == View.VISIBLE){
            initialText.setVisibility(View.GONE);
        }

        Bundle bundle = new Bundle();
        bundle.putString("CategoryName", categoryData.get(position).getCATEGORY_NAME());


        ProductListFragment productListFragment = new ProductListFragment();
        productListFragment.setArguments(bundle);

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .setCustomAnimations(R.anim.rise_to_top, R.anim.dip_down)
                .replace(R.id.ProductListArea, productListFragment, productListFragment.getTag())
                .commit();
    }
}
