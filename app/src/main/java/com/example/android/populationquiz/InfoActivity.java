package com.example.android.populationquiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    /**
     * Navigates to the web page.
     */
    public void goToWeb1 (View view) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.theguardian.com/global-development-professionals-network/gallery/2015/apr/01/over-population-over-consumption-in-pictures"));
        startActivity(intent);
    }

    /**
     * Navigates to the web page.
     */
    public void goToWeb2 (View view) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.theguardian.com/global-development-professionals-network/gallery/2015/apr/01/over-population-over-consumption-in-pictures"));
        startActivity(intent);
    }

    /**
     * Navigates to the web page.
     */
    public void goToWeb3 (View view) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://www.marketwatch.com/story/climate-report-proves-humans-are-the-new-dinosaurs-2013-10-12"));
        startActivity(intent);
    }

    /**
     * Navigates to home screen.
     */
    public void home (View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
