package com.example.sportapp;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.SportViewHolder>{

    private final List<Sport> sports;

    ItemClickListener itemClickListener;

    public SportAdapter(List<Sport> sports, ItemClickListener itemClickListener)
    {
        this.sports = sports;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public SportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sport, parent, false);
        return new SportViewHolder(view);
    }

    //Random color: https://stackoverflow.com/questions/45324594/how-to-set-random-color
    @Override
    public void onBindViewHolder(@NonNull SportViewHolder holder, int position) {
        Sport sport = sports.get(position);

        holder.sportName.setText(sport.getSportName());
        holder.sportImg.setImageResource(sport.getSportImg());
        holder.sportDesc.setText(sport.getSportDesc());

        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

        holder.viewGroup.setBackgroundColor(color);

        holder.cardView.setOnClickListener(view -> {
                itemClickListener.onClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return sports.size();
    }

    static class SportViewHolder extends RecyclerView.ViewHolder {
        private final TextView sportName;
        private final ImageView sportImg;
        private final ConstraintLayout viewGroup;
        private final CardView cardView;
        private final TextView sportDesc;

        public SportViewHolder(@NonNull View itemView) {
            super(itemView);
            sportName = itemView.findViewById(R.id.tvSportTitle);
            sportImg = itemView.findViewById(R.id.ivSportImg);
            viewGroup = itemView.findViewById(R.id.clGroupOne);
            cardView = itemView.findViewById(R.id.cvItemRecycler);
            sportDesc = itemView.findViewById(R.id.tvSportDesc);
        }
    }
}
