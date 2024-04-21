package com.example.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Try to find button by ID
        Button btn = findViewById(R.id.presser);
        // Create a on-click listener
        btn.setOnClickListener(new View.OnClickListener() {
            // Implement functionality for clicking on btn
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OtherActivity.class);
                startActivity(intent);
            }
        });
    }
}
