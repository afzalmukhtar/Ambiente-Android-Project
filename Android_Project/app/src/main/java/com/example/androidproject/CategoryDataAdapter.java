package com.example.androidproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryDataAdapter extends RecyclerView.Adapter<CategoryDataAdapter.ViewHolder> {
    private static final String TAG = "CategoryDataAdapter";

    private int last = -1;
    private ClickAdapterEvent clickAdapterEvent;
    private ArrayList<CategoryData> categoryData;
    private Context context;
    private RelativeLayout prevSelected;

    public CategoryDataAdapter(Context context, ArrayList<CategoryData> categoryData, ClickAdapterEvent clickAdapterEvent) {
        this.context = context;
        this.categoryData = categoryData;
        this.clickAdapterEvent = clickAdapterEvent;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_card_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.imageView.setImageResource(categoryData.get(position).getCATEGORY_IMAGE());
        holder.categoryName.setText(categoryData.get(position).getCATEGORY_NAME());

        holder.categoryCardLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DONE TODO Fix the layout when clicked
                clickAdapterEvent.onCategoryClick(holder.categoryCardLayout, categoryData, position, prevSelected);
                prevSelected = holder.categoryCardLayout;
            }
        });

        holder.categoryCardLayout.setAnimation(AnimationUtils.loadAnimation(context, position > last ? R.anim.delayed_scroll_from_right : R.anim.delayed_scroll_from_left));
        last = position;
    }

    @Override
    public int getItemCount() {
        return categoryData.size();
    }

    public interface ClickAdapterEvent {
        void onCategoryClick(RelativeLayout categoryCardLayout,
                             ArrayList<CategoryData> categoryData,
                             int position,
                             RelativeLayout prevSelected);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imageView;
        TextView categoryName;
        RelativeLayout categoryCardLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.CategoryImage);
            categoryName = itemView.findViewById(R.id.CategoryName);
            categoryCardLayout = itemView.findViewById(R.id.CategoryCardItem);
        }
    }
}
