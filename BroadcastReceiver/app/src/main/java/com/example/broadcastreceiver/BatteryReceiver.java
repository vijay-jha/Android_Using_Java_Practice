package com.example.broadcastreceiver;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class BatteryReceiver extends android.content.BroadcastReceiver {
    TextView tv;
    BatteryReceiver(TextView tv) {
        this.tv = tv;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int percentage = intent.getIntExtra("level", 0);
        if (percentage != 0)
            tv.setText(percentage + "%");
    }
}
