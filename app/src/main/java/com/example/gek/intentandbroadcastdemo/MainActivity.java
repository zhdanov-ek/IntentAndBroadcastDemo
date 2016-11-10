package com.example.gek.intentandbroadcastdemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnSecondActivity, btnSendText;
    String  mess = "Hello from ActivityMain";
    AudioReceiver mAudioReceiver;
    BluetoothReceiver mBluetoothReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSecondActivity = (Button)findViewById(R.id.btnSecondActivity);
        btnSecondActivity.setOnClickListener(this);

        btnSendText = (Button)findViewById(R.id.btnSendText);
        btnSendText.setOnClickListener(this);

        mAudioReceiver = new AudioReceiver();
        mBluetoothReceiver = new BluetoothReceiver();
    }

    // регистрируем наш ресиверы, которые не прописаны в манифесте
    @Override
    protected void onResume() {
        IntentFilter filter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        registerReceiver(mAudioReceiver, filter);

        IntentFilter filterB = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        registerReceiver(mBluetoothReceiver, filterB);
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSecondActivity:
                Intent intentSecondActivity = new Intent(this, SecondActivity.class);
                intentSecondActivity.putExtra("mess", mess);
                startActivity(intentSecondActivity);
                break;
            case R.id.btnSendText:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, mess);
                sendIntent.setType("text/plain");

                // проверяем есть ли вообще в системе апп способные обработать наш интент
                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendIntent);
                }

        }
    }
}
