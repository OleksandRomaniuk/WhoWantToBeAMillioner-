package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.Toolbar;

import java.nio.file.Files;

public class MainActivity extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;
    MediaPlayer mPlayer;
    Button classic;
    SeekBar volumeControl;
    AudioManager audioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //button cup
        ImageButton buttonCup = (ImageButton) findViewById(R.id.cup);
        buttonCup.setOnClickListener(new View.OnClickListener() {
            /**
             * Go to the Cup view
             * @param v
             */
            @Override
            public void onClick(View v) {
                try{
                    //sound.start();
                    Intent intent =new Intent(MainActivity.this,GameStat.class);
                    startActivity(intent);finish();
                }
                catch (Exception e){

                }

            }
        });

        //button start
        ImageButton buttonPlay=(ImageButton)findViewById(R.id.play);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            /**
             * Go to button play
             * @param v
             */
            @Override
            public void onClick(View v) {
                try{
                    Intent intent =new Intent(MainActivity.this,PlayButtom.class);
                    startActivity(intent);finish();
                }
                catch (Exception e){

                }

            }
        });
        //button menu
        ImageButton buttonMenu=(ImageButton)findViewById(R.id.menu);
        buttonMenu.setOnClickListener(new View.OnClickListener() {
            /**
             * Menu
             * @param v
             */
            @Override
            public void onClick(View v) {
                try{
                    //sound.start();
                    Intent intent =new Intent(MainActivity.this,MenuActivity.class);
                    startActivity(intent);finish();
                }
                catch (Exception e){

                }

            }
        });

        //settings menu
        ImageButton buttonSettings=(ImageButton)findViewById(R.id.settings);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            /**
             * Go to settings
             * @param v
             */
            @Override
            public void onClick(View v) {
                try{
                    //sound.start();
                    Intent intent =new Intent(MainActivity.this,Settings.class);
                    startActivity(intent);finish();
                }
                catch (Exception e){

                }

            }
        });

        //coins menu
        ImageButton buttonCoins=(ImageButton)findViewById(R.id.coins);
        buttonCoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    // sound.start();
                    Intent intent =new Intent(MainActivity.this,CoinsClass.class);
                    startActivity(intent);finish();
                }
                catch (Exception e){

                }

            }
        });





        Window w= getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    //systemButton

    @Override
    public void onBackPressed() {

        if(backPressedTime +2000>System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return; }
        else{
            backToast= Toast.makeText(getBaseContext(),"Натисніть ще раз, щоб вийти",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime=System.currentTimeMillis();
    }








}
