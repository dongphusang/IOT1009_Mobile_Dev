package com.github.iot1009.lab2_scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button increaseButton;
    Button decreaseButton;
    TextView firstTeamScore;
    TextView secondTeamScore;
    Switch teamSelector;
    RadioButton basketBallFormat;
    RadioButton americanFootBallFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Scorekeeper_Data.InitStats();
        setContentView(R.layout.activity_main);

        // creating views
        increaseButton = (Button)findViewById(R.id.increase_button);
        decreaseButton = (Button)findViewById(R.id.decrease_button);
        teamSelector = (Switch)findViewById(R.id.team_selector);
        firstTeamScore = (TextView)findViewById(R.id.first_team_point);
        secondTeamScore = (TextView)findViewById(R.id.second_team_point);
        basketBallFormat = (RadioButton)findViewById(R.id.basketball);
        americanFootBallFormat = (RadioButton)findViewById(R.id.american_football);

        // assigning listener to views
        increaseButton.setOnClickListener(this);
        decreaseButton.setOnClickListener(this);
        teamSelector.setOnClickListener(this);
        basketBallFormat.setOnClickListener(this);
        americanFootBallFormat.setOnClickListener(this);


    }

    public void onClick(View v){

        switch(v.getId()) {

            case R.id.increase_button:
                if (!teamSelector.isChecked()) {
                    // Corno is selected for an increase
                    Scorekeeper_Data.setFirstTeamPoint(1);
                    firstTeamScore.setText(""+Scorekeeper_Data.getFirstTeamPoint());
                }
                else {
                    // Forest is selected for an increase
                    Scorekeeper_Data.setSecondTeamPoint(1);
                    secondTeamScore.setText(""+Scorekeeper_Data.getSecondTeamPoint());
                }
                break;

            case R.id.decrease_button:
                if (!teamSelector.isChecked()) {
                    // Corno is selected for decrease
                    Scorekeeper_Data.setFirstTeamPoint(-1);
                    firstTeamScore.setText(""+Scorekeeper_Data.getFirstTeamPoint());
                }
                else {
                    // Forest is selected for decrease
                    Scorekeeper_Data.setSecondTeamPoint(-1);
                    secondTeamScore.setText(""+Scorekeeper_Data.getSecondTeamPoint());
                }
                break;

            // switch button toggled
            case R.id.team_selector:
                if (teamSelector.isChecked()) {
                    teamSelector.setText("Forest");
                }
                else {
                    teamSelector.setText("Corno");
                }
                break;

            // basketball scoring system
            case R.id.basketball:
                americanFootBallFormat.setChecked(false);
                Scorekeeper_Data.setScoreSystem(0);
                Scorekeeper_Data.resetPoints();
                firstTeamScore.setText(""+Scorekeeper_Data.getFirstTeamPoint());
                secondTeamScore.setText(""+Scorekeeper_Data.getSecondTeamPoint());
                break;

            // american football scoring system
            case R.id.american_football:
                basketBallFormat.setChecked(false);
                Scorekeeper_Data.setScoreSystem(1);
                Scorekeeper_Data.resetPoints();
                firstTeamScore.setText(""+Scorekeeper_Data.getFirstTeamPoint());
                secondTeamScore.setText(""+Scorekeeper_Data.getSecondTeamPoint());
                break;
        }
    }
}