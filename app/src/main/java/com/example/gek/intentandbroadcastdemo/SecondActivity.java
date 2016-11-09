package com.example.gek.intentandbroadcastdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView  tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        Intent intent = getIntent();
        tvMessage.setText(intent.getStringExtra("mess"));
    }
}
