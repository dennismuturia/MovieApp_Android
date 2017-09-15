package com.example.dennis.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    //Lets start by binding
    @Bind(R.id.thisEditText)EditText myEditText;
    @Bind(R.id.movieButton)Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Lets implement a butterknife
        ButterKnife.bind(this);

        //Lets set an onclick listener and implement an Explicit intent
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = myEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, MovieActivity.class);
                intent.putExtra("query", query);
                startActivity(intent);
            }
        });

    }
}
