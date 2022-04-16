package com.github.iot1009.lab2_scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends AppCompatActivity implements View.OnClickListener{

    // declaring components
    Button savePreferences;

    // declaring SavedPreferences keys
    private static final String SHARED_PREFS = "sharedPrefs";
    private static final String BASKET_RADIO = "basket_radio";
    private static final String AMERICA_RADIO = "america_radio";
    private static final String FIRSTSCORE = "first_team_score";
    private static final String SECONDSCORE = "second_team_score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // initializing component(s)
        savePreferences = findViewById(R.id.save_preferences);

        // assigning listener
        savePreferences.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        saveData();
    }

    // save data to SavedPreferences
    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Intent intent = getIntent();
        Bundle savedData = intent.getExtras();

        /* debugging
        System.out.println("START FROM HERE!!!!");
        System.out.println(savedData.getStringArray("savedVal")[0]);
        System.out.println(savedData.getStringArray("savedVal")[1]);
        System.out.println(savedData.getStringArray("savedVal")[2]);
        System.out.println(savedData.getStringArray("savedVal")[3]);*/

        editor.putBoolean(BASKET_RADIO,Boolean.parseBoolean(savedData.getStringArray("savedVal")[0]));
        editor.putBoolean(AMERICA_RADIO, Boolean.parseBoolean(savedData.getStringArray("savedVal")[1]));
        editor.putString(FIRSTSCORE, savedData.getStringArray("savedVal")[2]);
        editor.putString(SECONDSCORE, savedData.getStringArray("savedVal")[3]);
        Toast.makeText(this, "Preferences Saved", Toast.LENGTH_SHORT).show();
        // confirm saving
        editor.apply();
    }
}