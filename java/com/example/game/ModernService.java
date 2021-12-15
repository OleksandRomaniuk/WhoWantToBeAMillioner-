package com.example.game;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class ModernService extends Service  {


    private MediaPlayer modernsong;


    AudioManager am;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public ModernService() {
        super();

    }

    /**
     * Starts music
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override

    public int onStartCommand(Intent intent, int flags, int startId) {

         am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

         modernsong =MediaPlayer.create(this,R.raw.modern);
        modernsong.setLooping(true);
modernsong.setVolume(20,20);
        modernsong.start();


        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        modernsong.stop();
    }

//    Intent intentInt = getIntent();
//    int temp = intentInt.getIntExtra("int_value", 0)


}


