package com.example.androidproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class IngredientDataAdapter extends RecyclerView.Adapter<IngredientDataAdapter.ViewHolder>{

    private static final String TAG = "IngredientDataAdapter";
    private ArrayList<IngredientData> ingredientDataList;
    private Context context;

    public IngredientDataAdapter(ArrayList<IngredientData> ingredientDataList) {
        this.ingredientDataList = ingredientDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredient_card_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        context = parent.getContext();
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: Called");
        holder.ingredientName.setText(ingredientDataList.get(position).getINGREDIENT_NAME());
        holder.ingredientRating.setRating(ingredientDataList.get(position).getRATING());
        holder.ingredientConcern.setText(ingredientDataList.get(position).getINGREDIENT_CONCERN());

        boolean expanded = ingredientDataList.get(position).getSELECTED();
        holder.ConcernLayout.setVisibility(expanded ? View.VISIBLE : View.GONE );
    }

    @Override
    public int getItemCount() {
        return ingredientDataList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ingredientName, ingredientConcern;
        RatingBar ingredientRating;
        RelativeLayout ConcernLayout, IngredientLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ingredientName = itemView.findViewById(R.id.IngredientName);
            ingredientConcern = itemView.findViewById(R.id.IngredientConcern);
            ingredientRating = itemView.findViewById(R.id.IngredientRatingBar);
            ConcernLayout = itemView.findViewById(R.id.CollapsingConcernLayout);
            IngredientLayout = itemView.findViewById(R.id.IngredientRelativeLayout);

            IngredientLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    ingredientDataList.get(pos).setSELECTED(!ingredientDataList.get(pos).getSELECTED());
                    notifyItemChanged(pos);
                }
            });
        }
    }
}
