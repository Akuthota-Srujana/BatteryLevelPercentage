package com.example.batterylevel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView battery;

    private BroadcastReceiver mBatInfoReceiver  = new BroadcastReceiver() {

        @Override

        public void onReceive(Context context, Intent intent) {
            int defaultValue;
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, defaultValue=0);
        battery.setText(String.valueOf(level)+"%");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        battery = (TextView)findViewById(R.id.battery);
        this.registerReceiver(this.mBatInfoReceiver,new IntentFilter(
                Intent.ACTION_BATTERY_CHANGED
        ));
    }


}
