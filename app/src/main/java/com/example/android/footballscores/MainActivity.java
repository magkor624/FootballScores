package com.example.android.footballscores;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int foulTeamA = 0;
    int scoreTeamB = 0;
    int foulTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreViewA = (TextView) findViewById(R.id.team_a_score);
        TextView nameViewA = (TextView) findViewById(R.id.team_a_name);

        if (scoreTeamA > scoreTeamB) {
            scoreViewA.setTextColor(Color.parseColor("#D50000"));
            nameViewA.setTextColor(Color.parseColor("#D50000"));
        }

        if (scoreTeamA == scoreTeamB) {
            scoreViewA.setTextColor(Color.parseColor("#64DD17"));
            nameViewA.setTextColor(Color.parseColor("#64DD17"));
        }
        if (scoreTeamA < scoreTeamB) {
            scoreViewA.setTextColor(Color.parseColor("#64DD17"));
            nameViewA.setTextColor(Color.parseColor("#64DD17"));
        }
        scoreViewA.setText(String.valueOf(score));
    }

    /**
     * /**
     * Displays the given foul for Team A.
     */
    public void displayFoulForTeamA(int foulTeamA) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_foul);
        scoreView.setText(String.valueOf(foulTeamA));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreViewB = (TextView) findViewById(R.id.team_b_score);
        TextView nameViewB = (TextView) findViewById(R.id.team_b_name);
        if (scoreTeamB > scoreTeamA) {
            scoreViewB.setTextColor(Color.parseColor("#D50000"));
            nameViewB.setTextColor(Color.parseColor("#D50000"));
        }

        if (scoreTeamB == scoreTeamA) {
            scoreViewB.setTextColor(Color.parseColor("#64DD17"));
            nameViewB.setTextColor(Color.parseColor("#64DD17"));
        }

        if (scoreTeamB < scoreTeamA) {
            scoreViewB.setTextColor(Color.parseColor("#64DD17"));
            nameViewB.setTextColor(Color.parseColor("#64DD17"));
        }
        scoreViewB.setText(String.valueOf(score));
    }

    /**
     * /**
     * Displays the given foul for Team A.
     */
    public void displayFoulForTeamB(int foulTeamB) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_foul);
        scoreView.setText(String.valueOf(foulTeamB));
    }

    /**
     * This method is called when the plus button +1 GOAL for Team A is clicked.
     */
    public void goalsTeamA(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * This method is called when the plus button +1 FOUL Team A is clicked.
     */
    public void foulsTeamA(View view) {
        foulTeamA = foulTeamA + 1;
        displayFoulForTeamA(foulTeamA);
    }

    /**
     * This method is called when the plus button +1 GOAL for Team B is clicked.
     */
    public void goalsTeamB(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
        displayForTeamA(scoreTeamA);
    }

    /**
     * This method is called when the plus button +1 FOUL Team B is clicked.
     */
    public void foulsTeamB(View view) {
        foulTeamB = foulTeamB + 1;
        displayFoulForTeamB(foulTeamB);
    }

    /**
     * This method is called when the plus button +RESET is clicked.
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

