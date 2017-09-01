package com.example.acer.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by acer on 6/16/2017.
 */

public class BatteryReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "This is custom", Toast.LENGTH_SHORT).show();
       /* if (intent.getAction() == Intent.ACTION_POWER_CONNECTED) {
            //status.setText("Charger PluggedIn");
            Toast.makeText(context, "Charger PluggedIn", Toast.LENGTH_SHORT).show();
        }
        else if(intent.getAction() == Intent.ACTION_POWER_DISCONNECTED){
           // status.setText("Charger PluggedOut");
            Toast.makeText(context, "Charger PluggedOut", Toast.LENGTH_SHORT).show();
        }
        else{}
    }*/
    }
}

