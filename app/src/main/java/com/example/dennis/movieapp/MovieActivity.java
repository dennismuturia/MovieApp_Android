package com.example.dennis.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieActivity extends AppCompatActivity {
//This is a bind for the text view
    @Bind(R.id.displayText)TextView Display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        //Use butter Knife
        ButterKnife.bind(this);

        //Lets Collect the data from the main activity
        Intent intent = getIntent();
        String movie = intent.getStringExtra("movie");
        Display.setText("Movie: " + movie);
    }
}
