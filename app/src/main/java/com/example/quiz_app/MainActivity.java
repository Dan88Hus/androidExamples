package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
        The activity_main.xml file will be composed of a Button component, which sends a custom broadcast in the
        moment that it is clicked. to register a broadcast receiver there are two possible solutions. The first one
        is to register the broadcast receiver directly in the Manifest file, by adding the <receiver>
        element.
*/



public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button startButton;
    private Button stopButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button) findViewById(R.id.play);
        stopButton = (Button) findViewById(R.id.stop);

        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        System.out.println("view: "+view.toString());
        if (view == startButton){
            startService(new Intent(this,PlayMusic_Service.class));

        } else if (view == stopButton) {
            stopService(new Intent(this,PlayMusic_Service.class));
        }

    }
}