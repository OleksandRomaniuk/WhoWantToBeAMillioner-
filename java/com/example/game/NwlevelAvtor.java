package com.example.game;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NwlevelAvtor extends AppCompatActivity {

    ObjectAnimator textColorAnim;
    long startTime = System.currentTimeMillis();
    private ImageView back;
    private  TextView mScorecurrent;
    private Button answer1 ,answer2 , answer3,  answer4;
    private  ImageButton applyButton;
    private boolean  acr3=false;
    private TextView question;
    private QuestionAvtor mQuestionAvtor = new QuestionAvtor();
    private String mAnswear;
    private int mScore;
    int forTrue=0;
    private  int mQuestionslength = mQuestionAvtor.mQuestions.length;
    private int life=0;
    private TextView timer;
    public int counter=60;
    private int count, sc;
    public static final String SHARED_PREFS = "sharedPrefs";
    Random r;
    List<Integer> rlist = new ArrayList<>();
    int index = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newlevelavtor);
        Random rand = new Random();
        loadData();
        count++;
        while (rlist.size() != 31) {
            int r = rand.nextInt(31) ;
            if (!rlist.contains(r))
                rlist.add(r);

        }

        saveData();

        timer=(TextView)findViewById(R.id.timer);
        new CountDownTimer(60000, 1000){
            public void onTick(long millisUntilFinished){
                timer.setText(String.valueOf(counter));
                counter--;
            }
            public  void onFinish(){
                timer.setText("Кінець!!");
                answer4.setEnabled(false);
                answer1.setEnabled(false);
                answer3.setEnabled(false);
                answer2.setEnabled(false);
                Intent intent =new Intent(NwlevelAvtor.this,LastmenuAvtor.class);
                startActivity(intent);
                finish();
                saveData();
            }
        }.start();

        mScorecurrent =(TextView)findViewById(R.id.Scorenewlevelavtor);
        back=(ImageView)findViewById(R.id.playbackgrountmainswea);
        applyButton = (ImageButton) findViewById(R.id.apply);
        answer1 = (Button) findViewById(R.id.answear1);
        answer2 = (Button) findViewById(R.id.answear2);
        answer3 = (Button) findViewById(R.id.answear3);
        answer4 = (Button) findViewById(R.id.answear4);
        question = (TextView) findViewById(R.id.question);



        updateQuestion(rlist.get(index));
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index < 30) {
                    if(answer1.getText()==mAnswear){
                        sc++;
                        mScore++;
                        mScorecurrent.setText("Рахунок: "+mScore);
                    }

                    index++;
                    updateQuestion(rlist.get(index));


                } else {
                    sc=0;
                    answer1.setEnabled(false);
                    answer2.setEnabled(false);
                    answer3.setEnabled(false);
                    answer4.setEnabled(false);
                    timer.setVisibility(View.GONE) ;
                    Intent intent =new Intent(NwlevelAvtor.this,Lastmenu.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index < 30) {
                    if(answer2.getText()==mAnswear){
                        sc++;
                        mScore++;
                        mScorecurrent.setText("Рахунок: "+mScore);
                    }

                    index++;
                    updateQuestion(rlist.get(index));

                } else {
                    sc=0;
                    answer1.setEnabled(false);
                    answer2.setEnabled(false);
                    answer3.setEnabled(false);
                    answer4.setEnabled(false);
                    timer.setVisibility(View.GONE) ;
                    Intent intent =new Intent(NwlevelAvtor.this,Lastmenu.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index < 30) {
                    if(answer3.getText()==mAnswear){
                        sc++;
                        mScore++;
                        mScorecurrent.setText("Рахунок: "+mScore);
                    }

                    index++;
                    updateQuestion(rlist.get(index));

                } else {
                    sc=0;
                    answer1.setEnabled(false);
                    answer2.setEnabled(false);
                    answer3.setEnabled(false);
                    answer4.setEnabled(false);
                    timer.setVisibility(View.GONE) ;
                    Intent intent =new Intent(NwlevelAvtor.this,Lastmenu.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index < 30) {
                    if(answer4.getText()==mAnswear){
                        mScore++;
                        mScorecurrent.setText("Рахунок: "+mScore);
                    }

                    index++;
                    updateQuestion(rlist.get(index));

                } else {
                    sc=0;
                    answer1.setEnabled(false);
                    answer2.setEnabled(false);
                    answer3.setEnabled(false);
                    answer4.setEnabled(false);
                    timer.setVisibility(View.GONE);
                    Intent intent =new Intent(NwlevelAvtor.this,Lastmenu.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        Window w= getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void updateQuestion(int num){
        question.setText(mQuestionAvtor.getQuestion(num));
        answer1.setText(mQuestionAvtor.getChoice1(num));
        answer2.setText(mQuestionAvtor.getChoice2(num));
        answer3.setText(mQuestionAvtor.getChoice3(num));
        answer4.setText(mQuestionAvtor.getChoice4(num));
        mAnswear= mQuestionAvtor.getCorrectAnswear(num);
    }

    public void getStatForGameStat(){
        Intent intent = new Intent(NwlevelAvtor.this,GameStat.class);
        intent.putExtra("mScore",mScore);
        startActivity(intent);
    }
    public void getStatForEndmenu(){
        Intent intentEnd = new Intent(NwlevelAvtor.this,Lastmenu.class);
        intentEnd.putExtra("mScoreEnd",mScore);
        startActivity(intentEnd);
    }

    //system button back

    public void onBackPressed(){
        try{
            Intent intent =new Intent(NwlevelAvtor.this,PlayButtom.class);
            startActivity(intent);
            finish();
        }
        catch (Exception e){

        }
    }

    /**
     * Saves data
     */
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        count = sharedPreferences.getInt("count", count);

    }
    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("sc",mScore);
        editor.putInt("count",count);
        editor.putInt("rescopy2",mScore);


        editor.apply();

    }

}