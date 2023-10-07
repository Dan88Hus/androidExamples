package com.example.quiz_app;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

public class PlayMusic_Service extends Service {

    private MediaPlayer music;
    public PlayMusic_Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int onStartCommand(Intent i, int flag, int id){
        music = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        music.setLooping(true);
        music.start();
        Toast.makeText(PlayMusic_Service.this,"Music started",Toast.LENGTH_SHORT);
        System.out.println("music started");
        return START_STICKY;
    }

    public void onDestroy(){
        super.onDestroy();
        music.stop();
        System.out.println("music stopped");
        Toast.makeText(PlayMusic_Service.this,"Music stopped",Toast.LENGTH_SHORT);


    }
}