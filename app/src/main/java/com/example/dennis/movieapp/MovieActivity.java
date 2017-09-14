package com.example.dennis.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import javax.security.auth.callback.Callback;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

public class MovieActivity extends AppCompatActivity {
    private static final String TAG = MovieActivity.class.getSimpleName() ;
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

        getMovies(movie);
    }

    public void getMovies(String query){
        final MovieService movieService = new MovieService();
        movieService.theMovies(query, new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    if (response.isSuccessful()){
                        Log.v(TAG, jsonData);
                    }

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
