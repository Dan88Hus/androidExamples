package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
        The activity_main.xml file will be composed of a Button component, which sends a custom broadcast in the
        moment that it is clicked. to register a broadcast receiver there are two possible solutions. The first one
        is to register the broadcast receiver directly in the Manifest file, by adding the <receiver>
        element.
        The second solution that we are going to see in more detail is by registering the broadcast
        receiver via the Context (we need to add the proper lines of
        code in the MainActivity.java file.)
*/



public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button startButton;
    private Button stopButton;

    private Button broadcastButton;

    ConnectionReceiver r;
    IntentFilter intentFilter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button) findViewById(R.id.play);
        stopButton = (Button) findViewById(R.id.stop);
        broadcastButton = (Button) findViewById(R.id.broadcast);
        r = new ConnectionReceiver();
        intentFilter = new IntentFilter("com.journaldev.broadcastreceiver.SOME_ACTION");

        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);

        broadcastButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        System.out.println("view: "+view.toString());
        if (view == startButton){
            startService(new Intent(this,PlayMusic_Service.class));

        } else if (view == stopButton) {
            stopService(new Intent(this,PlayMusic_Service.class));
        } else if (view == broadcastButton){
            System.out.println("Broadcast onClick");

//            Intent intent = new Intent("com.workingdev.SOMETHINGHAPPENED");
//            sendBroadcast(intent);
//
//            IntentFilter filter = new IntentFilter("com.workingdev.SOMETHINGHAPPENED");
            registerReceiver(r, intentFilter);
            Intent intent = new Intent("com.journaldev.broadcastreceiver.SOME_ACTION");
            sendBroadcast(intent);
            System.out.println("sent Broadcast");


        }

    }

    @Override
    protected void onResume() {

        super.onResume();
        System.out.println("onResume called");
//        IntentFilter filter = new IntentFilter("com.workingdev.SOMETHINGHAPPENED");
        registerReceiver(r, intentFilter);
    }
    @Override
    protected void onPause() {

        super.onPause();
//        unregisterReceiver(r);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        System.out.println("onDestroy called");
        unregisterReceiver(r);
    }



}