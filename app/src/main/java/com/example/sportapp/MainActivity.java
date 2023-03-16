package com.example.sportapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<Sport> sports = new ArrayList<>();

    private ItemClickListener itemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sports.add(new Sport("Ping Pong", R.drawable.ping_pong, "Table tennis is a game that can be played with two or four people. All you need are the paddles, a ball, and a rectangular table. While getting the equipment is quite cheap and easy, finding a table might be more difficult."));
        sports.add(new Sport("Running", R.drawable.running, "Running is easily the most accessible and easiest sport to play. All you need is a good pair of running shoes and your good to go. There are no rules in running, but that's what makes running so free-form and fun."));
        sports.add(new Sport("Cycling", R.drawable.cyclist, "Cycling is a very relaxing and stress-free sport. It's a great way to enjoy the weather, get some exercise, and it's easy on the joints! All you need is a bike and you're good to go."));
        sports.add(new Sport("Bowling", R.drawable.bowling, "Bowling is a fun sport to play with your friends if you're looking for a chill and relaxing activity to do on the weekend. Bowling is very straightforward. "));
        sports.add(new Sport("Baseball", R.drawable.baseball, "Baseball is a bat-and-ball sport played between two teams of nine players each, taking turns batting and fielding."));
        sports.add(new Sport("Basketball", R.drawable.basketball, "Basketball is a team sport ; Players advance the ball by bouncing it while walking or running (dribbling) or by passing it to a teammate, both of which require ..."));

        itemClickListener = new ItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("sport", sports.get(position));
                startActivity(intent);
            }
        };

        RecyclerView rvSports = this.findViewById(R.id.rvSports);
        rvSports.setAdapter(new SportAdapter(sports, itemClickListener));

    }
}