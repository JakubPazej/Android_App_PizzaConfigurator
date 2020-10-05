package com.example.pizzaconfigurator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class orderDetailsScene extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details_scene);

        Intent intent = getIntent();
        String message = intent.getStringExtra("orderKey");

        TextView orderSummary = findViewById(R.id.textView5);
        orderSummary.setText(message);
    }
}