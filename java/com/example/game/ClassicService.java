package com.example.game;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class ClassicService extends Service {
    private MediaPlayer classicsong;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public ClassicService() {
        super();
    }

    /**
     * Starts palying music
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

         classicsong =MediaPlayer.create(this,R.raw.classic);
        classicsong.setLooping(true);
        classicsong.setVolume(1,1);
        classicsong.start();
        return START_STICKY;
    }

    /**
     * Void that stops the program
     */
    @Override
    public void onDestroy() {
        super.onDestroy();

        classicsong.stop();
    }
}
