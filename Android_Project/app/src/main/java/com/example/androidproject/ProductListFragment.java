package com.example.androidproject;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductListFragment extends Fragment implements ProductDataAdapter.ClickAdapterEvent {

    private static final String TAG = "ProductListFragment";
    private ArrayList<ProductData> productDataList;

    public ProductListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_product_recycle_view);
        ProductDataAdapter productDataAdapter = new ProductDataAdapter(getContext(), productDataList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(productDataAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String CategoryName = getDatabaseRelatedName(getArguments().getString("CategoryName"));

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getContext());
        databaseAccess.open();
        productDataList = databaseAccess.getProductList(CategoryName);
        databaseAccess.close();
    }

    private String getDatabaseRelatedName(String categoryName) {
        if (categoryName.equalsIgnoreCase("Bronzer / Highlighter")){
            return "Bronzer__Highlighter";
        } else if (categoryName.equalsIgnoreCase("Brow Liner")){
            return "Brow_liner";
        }else if (categoryName.equalsIgnoreCase("Concealer")) {
            return "Concealer";
        }else if (categoryName.equalsIgnoreCase("Eye Liner")){
            return "Eye_liner";
        }else if (categoryName.equalsIgnoreCase("Eye Makeup Remover")){
            return "Eye_makeup_remover";
        }else if (categoryName.equalsIgnoreCase("Eye Shadow")){
            return "Eye_shadow";
        }else if (categoryName.equalsIgnoreCase("Eyelash Glue")){
            return "Eyelash_glue";
        }else if (categoryName.equalsIgnoreCase("Facial Powder")){
            return "Facial_powder";
        }else  if (categoryName.equalsIgnoreCase("Foundation")){
            return "Foundation";
        }else if (categoryName.equalsIgnoreCase("Lip Balm")){
            return "Lip_balm";
        }else if (categoryName.equalsIgnoreCase("Lip Balm with SPF")){
            return "Lip_balm_with_SPF";
        }else if (categoryName.equalsIgnoreCase("Lip Gloss")){
            return "Lip_gloss";
        }else if (categoryName.equalsIgnoreCase("Lip Liner")){
            return "Lip_liner";
        }else if (categoryName.equalsIgnoreCase("Lip Plumper")){
            return "Lip_plumper";
        }else if (categoryName.equalsIgnoreCase("Lipstick")){
            return "Lipstick";
        }else if (categoryName.equalsIgnoreCase("Makeup Primer")){
            return "Makeup_primer";
        }else if (categoryName.equalsIgnoreCase("Makeup Remover")){
            return "Makeup_remover";
        }else if (categoryName.equalsIgnoreCase("Makeup with SPF")){
            return "Makeup_with_SPF";
        }else if (categoryName.equalsIgnoreCase("Mascara")){
            return "Mascara";
        }else if (categoryName.equalsIgnoreCase("Other Eye Makeup")){
            return "Other_eye_makeup";
        }else {
            return null;
        }

    }

    @Override
    public void onProductClick(RelativeLayout productCardLayout, ArrayList<ProductData> productData, int position, ImageView imageView) {
//        Log.d(TAG, "onProductClick: Clicked");

        Intent intent = new Intent(getContext(), DisplayProductInfo.class);

        Bundle bundle = new Bundle();
        bundle.putParcelable("ProductImage", productData.get(position).getPRODUCT_IMAGE());
        bundle.putString("ProductName", productData.get(position).getPRODUCT_NAME());
        bundle.putFloat("ProductRating", productData.get(position).getPRODUCT_RATING());
        intent.putExtra("ProductData", bundle);
        intent.putExtra("TransitionName", "enlargeProductTransition");

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), imageView, "enlargeProductTransition");

        startActivity(intent, options.toBundle());
    }
}
