package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
    }

    public void launchLogo(View v){
        Intent i = new Intent(this, LogoActivity.class);
        startActivity(i);
    }

    public void launchMain(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void launchCalories(View v){
        Intent i = new Intent(this, CaloriesActivity.class);
        startActivity(i);
    }

    public void launchRecipes(View v){
        Intent i = new Intent(this, RecipesActivity.class);
        startActivity(i);
    }
}