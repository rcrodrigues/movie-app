package com.example.android.movie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.movie.activities.discovery.DiscoveryActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent discoveryActivity = new Intent(this, DiscoveryActivity.class);
        startActivity(discoveryActivity);
    }

}
