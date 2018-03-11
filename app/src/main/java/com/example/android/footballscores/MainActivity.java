package com.example.android.footballscores;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /**
     * Static variables to save the current scores while the screen is rotated.
     */
    static final String STATE_SCORE_TEAM_A = "score team A";
    static final String STATE_SCORE_TEAM_B = "score team B";
    static final String STATE_FOUL_TEAM_A = "foul team A";
    static final String STATE_FOUL_TEAM_B = "foul team B";
    /**
     * Variables used in result calculation.
     */
    private int scoreTeamA = 0;
    private int foulTeamA = 0;
    private int scoreTeamB = 0;
    private int foulTeamB = 0;
    /**
     * Variables used in display of team's name and goal result .
     */
    private int wincolor;
    private int looscolor;
    /**
     * Variables used to find TextViews using findViewById in OnCreate method.
     */
    private TextView scoreViewA;
    private TextView nameViewA;
    private TextView scoreViewB;
    private TextView nameViewB;
    private TextView foulViewA;
    private TextView foulViewB;

    /**
     * Variables used to find TextViews and colors variables from strings.xml are initialized.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wincolor = getResources().getColor(R.color.red);
        looscolor = getResources().getColor(R.color.orange);
        scoreViewA = (TextView) findViewById(R.id.team_a_score);
        nameViewA = (TextView) findViewById(R.id.team_a_name);
        scoreViewB = (TextView) findViewById(R.id.team_b_score);
        nameViewB = (TextView) findViewById(R.id.team_b_name);
        foulViewA = (TextView) findViewById(R.id.team_a_foul);
        foulViewB = (TextView) findViewById(R.id.team_b_foul);
    }

    /**
     * Method created to save the state of the app after screen rotation .
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(STATE_SCORE_TEAM_A, scoreTeamA);
        savedInstanceState.putInt(STATE_SCORE_TEAM_B, scoreTeamB);
        savedInstanceState.putInt(STATE_FOUL_TEAM_A, foulTeamA);
        savedInstanceState.putInt(STATE_FOUL_TEAM_B, foulTeamB);
    }

    /**
     * Method created to restore the state of the app after screen rotation .
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreTeamA = savedInstanceState.getInt(STATE_SCORE_TEAM_A);
        scoreTeamB = savedInstanceState.getInt(STATE_SCORE_TEAM_B);
        foulTeamA = savedInstanceState.getInt(STATE_FOUL_TEAM_A);
        foulTeamB = savedInstanceState.getInt(STATE_FOUL_TEAM_B);
        displayForTeamA(scoreTeamA);
        displayFoulForTeamA(foulTeamA);
        displayForTeamB(scoreTeamB);
        displayFoulForTeamB(foulTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        if (scoreTeamA > scoreTeamB) {
            scoreViewA.setTextColor(wincolor);
            nameViewA.setTextColor(wincolor);
        }
        if (scoreTeamA == scoreTeamB) {
            scoreViewA.setTextColor(looscolor);
            nameViewA.setTextColor(looscolor);
        }
        if (scoreTeamA < scoreTeamB) {
            scoreViewA.setTextColor(looscolor);
            nameViewA.setTextColor(looscolor);
        }
        scoreViewA.setText(String.valueOf(score));
    }

    /**
     * /**
     * Displays the given foul for Team A.
     */
    public void displayFoulForTeamA(int foulTeamA) {
        foulViewA.setText(String.valueOf(foulTeamA));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        if (scoreTeamB > scoreTeamA) {
            scoreViewB.setTextColor(wincolor);
            nameViewB.setTextColor(wincolor);
        }
        if (scoreTeamB == scoreTeamA) {
            scoreViewB.setTextColor(looscolor);
            nameViewB.setTextColor(looscolor);
        }
        if (scoreTeamB < scoreTeamA) {
            scoreViewB.setTextColor(looscolor);
            nameViewB.setTextColor(looscolor);
        }
        scoreViewB.setText(String.valueOf(score));
    }


    /**
     * Displays the given foul for Team A.
     */
    public void displayFoulForTeamB(int foulTeamB) {
        foulViewB.setText(String.valueOf(foulTeamB));
    }

    /**
     * This method is called when the button +1 GOAL for Team A is clicked.
     */
    public void goalsTeamA(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * This method is called when the button +1 FOUL Team A is clicked.
     */
    public void foulsTeamA(View view) {
        foulTeamA = foulTeamA + 1;
        displayFoulForTeamA(foulTeamA);
    }

    /**
     * This method is called when the button +1 GOAL for Team B is clicked.
     */
    public void goalsTeamB(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
        displayForTeamA(scoreTeamA);
    }

    /**
     * This method is called when the button +1 FOUL Team B is clicked.
     */
    public void foulsTeamB(View view) {
        foulTeamB = foulTeamB + 1;
        displayFoulForTeamB(foulTeamB);
    }

    /**
     * This method is called when the button RESET is clicked.
     */

    public void reset(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        foulTeamA = 0;
        foulTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayFoulForTeamA(foulTeamA);
        displayForTeamB(scoreTeamB);
        displayFoulForTeamB(foulTeamB);
    }
}

