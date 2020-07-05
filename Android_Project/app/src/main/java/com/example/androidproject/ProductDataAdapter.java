package com.example.androidproject;

import android.app.ActivityOptions;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProductDataAdapter extends RecyclerView.Adapter<ProductDataAdapter.ViewHolder> {

    private ClickAdapterEvent clickAdapterEvent;
    private Context context;
    private ArrayList<ProductData> productData;

    public ProductDataAdapter(Context context, ArrayList<ProductData> productData, ClickAdapterEvent clickAdapterEvent) {
        this.clickAdapterEvent = clickAdapterEvent;
        this.context = context;
        this.productData = productData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_card_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.product_image.setImageBitmap(productData.get(position).getPRODUCT_IMAGE());
        holder.product_name.setText(productData.get(position).getPRODUCT_NAME());
        holder.product_rating.setRating(productData.get(position).getPRODUCT_RATING());
        holder.productCardLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickAdapterEvent.onProductClick(holder.productCardLayout, productData, position, holder.product_image);

            }
        });


        holder.productCardLayout.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_scale_cards));
        holder.product_image.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_in_from_left));
    }

    @Override
    public int getItemCount() {
        return productData.size();
    }

    public interface ClickAdapterEvent {
        void onProductClick(RelativeLayout productCardLayout, ArrayList<ProductData> productData, int position, ImageView imageView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView product_name;
        RatingBar product_rating;
        CircleImageView product_image;
        RelativeLayout productCardLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            product_name = itemView.findViewById(R.id.ProductName);
            product_rating = itemView.findViewById(R.id.ProductRating);
            product_image = itemView.findViewById(R.id.ProductImage);
            productCardLayout = itemView.findViewById(R.id.ProductCardItem);
        }
    }
}
