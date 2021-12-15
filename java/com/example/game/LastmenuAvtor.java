package com.example.game;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class LastmenuAvtor extends AppCompatActivity implements Serializable {

    TextView animText;
    float[] hsv;
    int runColor;
    int number,re,numpoints,sc,numpoints2;
    private ImageView fongood;
    public static final String SHARED_PREFS = "sharedPrefs";
    private boolean logic1,logic2,logic3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lastmenu);
        fongood=(ImageView)findViewById(R.id.fongo);
        animText=(TextView)findViewById(R.id.scoreOnLast);
        ValueAnimator anim = ValueAnimator.ofFloat(0, 1);
        anim.setDuration(2000);



        loadData();

        animText.setText(""+sc);


        int hue = 0;
        hsv = new float[3]; // Transition color
        hsv[1] = 1;
        hsv[2] = 1;
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                hsv[0] = 360 * animation.getAnimatedFraction();

                runColor = Color.HSVToColor(hsv);
                animText.setTextColor(runColor);
            }
        });

        anim.setRepeatCount(Animation.INFINITE);
        anim.start();

        ImageButton buttonRest = (ImageButton) findViewById(R.id.rest);
        buttonRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    //sound.start();
                    Intent intent =new Intent(LastmenuAvtor.this,PlayButtom.class);
                    startActivity(intent);finish();
                }
                catch (Exception e){

                }

            }
        });

        ImageButton buttonHome = (ImageButton) findViewById(R.id.home);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    //sound.start();
                    Intent intent =new Intent(LastmenuAvtor.this,MainActivity.class);
                    startActivity(intent);finish();
                }
                catch (Exception e){

                }

            }
        });


        Window w= getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * Loads data
     */
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);


        sc= sharedPreferences.getInt("rescopy2", 0);




    }

    //system button back

    /**
     * Back to previos menu
     */
    public void onBackPressed(){
        try{
            Intent intent =new Intent(LastmenuAvtor.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        catch (Exception e){

        }
    }
    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("rescopy",0);
        editor.putInt("rescopy2",0);
        editor.putInt("rescopy3",0);
        editor.putBoolean("logic1",false);
        editor.putBoolean("logic2",false);
        editor.putBoolean("logic3",false);

        editor.apply();

    }
}