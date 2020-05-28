package com.example.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void countOdds(View view) {
        odds count = new odds(this);
        Thread thread = new Thread(count);

        thread.start();
    }

    public void countEvens(View view) {
        new Thread(new evens(this)).start();
    }
}
