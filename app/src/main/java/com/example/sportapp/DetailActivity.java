package com.example.sportapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Sport sport = intent.getParcelableExtra("sport");

        TextView name = findViewById(R.id.tvSportName);
        name.setText(sport.getSportName());

        TextView desc = findViewById(R.id.tvSportDesc);
        desc.setText(sport.getSportDesc());

        ImageView img = findViewById(R.id.ivSportImg);
        img.setImageResource(sport.getSportImg());
    }

}