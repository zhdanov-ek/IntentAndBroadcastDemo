package com.example.gek.intentandbroadcastdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Эта активити перехватывает интенты по открытию определнные в манифесте хостов через http
 * https://github.com
 * https://plus.google.com
 * */

public class HttpOpen extends AppCompatActivity {
    TextView tvHttpInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_open);

        tvHttpInfo = (TextView) findViewById(R.id.tvHttpInfo);

        Intent intentHttp = getIntent();
        if (intentHttp != null) {
            tvHttpInfo.setText(intentHttp.toString());
        }

    }
}
