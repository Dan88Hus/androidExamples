package com.example.quiz_app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/*
this is from IU script example, but its missing some pieces, need to fix some bug
 */
public class Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
        Toast.makeText(context,"Broadcast Message", Toast.LENGTH_SHORT).show();
        System.out.println("Broadcast is working");
    }
}