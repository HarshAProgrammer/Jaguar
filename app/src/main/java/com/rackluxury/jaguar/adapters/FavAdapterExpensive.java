package com.rackluxury.jaguar.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.rackluxury.jaguar.R;
import com.rackluxury.jaguar.activities.FavDBExpensive;
import com.rackluxury.jaguar.activities.FavItemExpensive;

import java.util.List;


public class FavAdapterExpensive extends RecyclerView.Adapter<FavAdapterExpensive.ViewHolder> {

    private final Context context;
    private final List<FavItemExpensive> favItemListExpensive;


    public FavAdapterExpensive(Context context, List<FavItemExpensive> favItemListExpensive) {
        this.context = context;
        this.favItemListExpensive = favItemListExpensive;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_item_expensive,
                parent, false);
        FavDBExpensive favDB = new FavDBExpensive(context);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.favCardView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.recycler_view_animation));
        holder.favTextView.setText(favItemListExpensive.get(position).getItem_title());
        holder.favImageView.setImageResource(favItemListExpensive.get(position).getItem_image());
    }

    @Override
    public int getItemCount() {
        return favItemListExpensive.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView favTextView;
        ImageView favImageView;
        CardView favCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            favCardView = itemView.findViewById(R.id.cvFavExpensive);
            favTextView = itemView.findViewById(R.id.tvFavExpensive);
            favImageView = itemView.findViewById(R.id.ivFavExpensive);

        }
    }

}
