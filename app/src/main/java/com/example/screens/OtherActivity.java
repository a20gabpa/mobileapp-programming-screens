package com.example.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int number = extras.getInt("number");

            // Use the number to update the text element
            TextView myNumberText = findViewById(R.id.numberText);
            myNumberText.setText("Number carried from intent " + number);
        }
    }
}
