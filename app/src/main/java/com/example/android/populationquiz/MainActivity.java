package com.example.android.populationquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Starts quiz (QuizActivity).
     */

    public void startQuiz(View view) {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);

    }
}


