
package com.example.game;
/*
IPZ1
Осташко Романюк
Class nwLevel
 */
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import com.airbnb.lottie.LottieAnimationView;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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

import static android.provider.Telephony.Mms.Part.TEXT;

public class Nwlevel extends AppCompatActivity {
    LottieAnimationView win;
    private MediaPlayer answeara, answearb, answearc, answeard;
    Dialog dialog,dialog1;
    private ImageView back;
    private int checkNumber=0;
    private ImageButton applyButton,butfinish;
    private boolean  acr1=false;
    AudioManager am;
    List<Integer> rlist = new ArrayList<>();
    int index = 0;
    private Button answer1 ,answer2 , answer3,  answer4;
    private TextView question,coments;
    private Question mQuestion = new Question();
    private String mAnswear;
    private int mScore,numpoints,numtrys;
    private  int mQuestionslength = mQuestion.mQuestions1.length;
    private int life=0;
    private ImageButton help50Button,helpaudio,helpaudition,continiue,ido,ino;;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String SWITCH1 = "switch1";
    private boolean switchOnOff;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.newlevel);
        coments=(TextView)findViewById(R.id.сoments);
        coments.setText("");
        Random rand = new Random();

        while (rlist.size() != 15) {
            int r = rand.nextInt(15) ;
            if (!rlist.contains(r))
                rlist.add(r);
        }

        back=(ImageView)findViewById(R.id.playbackgrountmainswea);
        applyButton = (ImageButton) findViewById(R.id.apply);
        answer1 = (Button) findViewById(R.id.answear1);
        answer2 = (Button) findViewById(R.id.answear2);
        answer3 = (Button) findViewById(R.id.answear3);
        answer4 = (Button) findViewById(R.id.answear4);
        question = (TextView) findViewById(R.id.question);
        updateQuestion(rlist.get(index));
        applyButton.setEnabled(false);
        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(checkNumber<14){
                    checkNumber++;
                    if(life==1) {
                        if(checkNumber==1) {
                            updateQuestion(rlist.get(index + 1));
                            applyButton.setEnabled(false);
                        }
                        if(checkNumber==2) {
                            updateQuestion(rlist.get(index + 2));
                            applyButton.setEnabled(false);
                        }
                        if(checkNumber==3){
                            updateQuestion(rlist.get(index+3));
                            applyButton.setEnabled(false);
                        }

                        if(checkNumber==4){
                            updateQuestion(rlist.get(index+4));
                            applyButton.setEnabled(false);

                        }
                        if(checkNumber==5){
                            updateQuestion(rlist.get(index+5));
                            applyButton.setEnabled(false);

                        }
                        if(checkNumber==6){
                            updateQuestion(rlist.get(index+6));
                            applyButton.setEnabled(false);
                        }
                        if(checkNumber==7){
                            updateQuestion(rlist.get(index+7));
                            applyButton.setEnabled(false);

                        }
                        if(checkNumber==8){
                            updateQuestion(rlist.get(index+8));
                            applyButton.setEnabled(false);
                        }
                        if(checkNumber==9){
                            updateQuestion(rlist.get(index+9));
                            applyButton.setEnabled(false);
                        }
                        if(checkNumber==10){
                            updateQuestion(rlist.get(index+10));
                            applyButton.setEnabled(false);
                        }

                        if(checkNumber==11) {
                            updateQuestion(rlist.get(index + 11));
                            applyButton.setEnabled(false);
                        }
                        if(checkNumber==12) {
                            updateQuestion(rlist.get(index + 12));
                            applyButton.setEnabled(false);
                        }
                        if(checkNumber==13) {
                            updateQuestion(rlist.get(index + 13));
                            applyButton.setEnabled(false);
                        }
                        if(checkNumber==14) {
                            updateQuestion(rlist.get(index + 14));
                            applyButton.setEnabled(false);
                        }
                        answer1.setTextColor(Color.BLACK);
                        answer2.setTextColor(Color.BLACK);
                        answer3.setTextColor(Color.BLACK);
                        answer4.setTextColor(Color.BLACK);
                        answer1.setEnabled(true);
                        answer2.setEnabled(true);
                        answer3.setEnabled(true);
                        answer4.setEnabled(true);
                        back.setImageResource(R.drawable.backanswer);

                    }

                    if(life==0){
                        Intent intent =new Intent(Nwlevel.this,Lastmenu.class);
                        startActivity(intent);finish();

                        saveData();
                        getStatForEndmenu();

                    }
                }
                else {


                    Intent intent =new Intent(Nwlevel.this,Lastmenu.class);
                    startActivity(intent);finish();
                    saveData();
                    getStatForEndmenu();
                }



            }

        });
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer2.setEnabled(false);
                answer3.setEnabled(false);
                answer4.setEnabled(false);
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(900); //You can manage the blinking time with this parameter
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(1);

                if(answer1.getText()==mAnswear){
                    coments();
                    back.setImageResource(R.drawable.backanswer1);
                    applyButton.setEnabled(true);
                    mScore++;
                    answer1.setTextColor(Color.GREEN);
                    answer1.startAnimation(anim);
                    life=1;
                }
                else{
                    comentsneg();
                    applyButton.setEnabled(true);
                    life=0;
                    answer1.startAnimation(anim);
                    if(answer3.getText()==mAnswear){
                        back.setImageResource(R.drawable.backanswer2);
                        answer3.setTextColor(Color.GREEN);
                        answer3.startAnimation(anim);
                    }
                    if(answer2.getText()==mAnswear){
                        back.setImageResource(R.drawable.backanswer3);
                        answer2.setTextColor(Color.GREEN);
                        answer2.startAnimation(anim);
                    }
                    if(answer4.getText()==mAnswear){
                        back.setImageResource(R.drawable.backanswer4);
                        answer4.setTextColor(Color.GREEN);
                        answer4.startAnimation(anim);
                    }


                }
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer1.setEnabled(false);
                answer3.setEnabled(false);
                answer4.setEnabled(false);
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(900); //You can manage the blinking time with this parameter
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(1);
                if(answer2.getText()==mAnswear){
                    coments();
                    back.setImageResource(R.drawable.backanswer3);
                    applyButton.setEnabled(true);
                    mScore++;
                    answer2.setTextColor(Color.GREEN);
                    answer2.startAnimation(anim);
                    life=1;
                }
                else{
                    comentsneg();

                    applyButton.setEnabled(true);
                    life=0;
                    answer2.startAnimation(anim);
                    if(answer1.getText()==mAnswear){
                        back.setImageResource(R.drawable.backanswer1);
                        answer1.setTextColor(Color.GREEN);
                        answer1.startAnimation(anim);
                    }
                    if(answer3.getText()==mAnswear){
                        back.setImageResource(R.drawable.backanswer2);
                        answer3.setTextColor(Color.GREEN);
                        answer3.startAnimation(anim);
                    }
                    if(answer4.getText()==mAnswear){
                        back.setImageResource(R.drawable.backanswer4);
                        answer4.setTextColor(Color.GREEN);
                        answer4.startAnimation(anim);
                    }

                }
            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                answer1.setEnabled(false);
                answer2.setEnabled(false);
                answer4.setEnabled(false);
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(900); //You can manage the blinking time with this parameter
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(1);


                if(answer3.getText()==mAnswear){
                    coments();
                    back.setImageResource(R.drawable.backanswer2);
                    applyButton.setEnabled(true);
                    mScore++;
                    answer3.setTextColor(Color.GREEN);
                    answer3.startAnimation(anim);
                    life=1;
                }
                else{
                    comentsneg();

                    applyButton.setEnabled(true);
                    life=0;
                    answer3.startAnimation(anim);
                    if(answer1.getText()==mAnswear){
                        back.setImageResource(R.drawable.backanswer1);
                        answer1.setTextColor(Color.GREEN);
                        answer1.startAnimation(anim);
                    }
                    if(answer2.getText()==mAnswear){
                        back.setImageResource(R.drawable.backanswer3);
                        answer2.setTextColor(Color.GREEN);
                        answer2.startAnimation(anim);
                    }
                    if(answer4.getText()==mAnswear){
                        back.setImageResource(R.drawable.backanswer4);
                        answer4.setTextColor(Color.GREEN);
                        answer4.startAnimation(anim);
                    }

                }
            }
        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer1.setEnabled(false);
                answer2.setEnabled(false);
                answer3.setEnabled(false);
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(900); //You can manage the blinking time with this parameter
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(1);


                if(answer4.getText()==mAnswear){
                    coments();
                    back.setImageResource(R.drawable.backanswer4);
                    applyButton.setEnabled(true);
                    mScore++;
                    answer4.setTextColor(Color.GREEN);
                    answer4.startAnimation(anim);
                    answer1.setEnabled(true);
                    answer2.setEnabled(true);
                    answer3.setEnabled(true);
                    life=1;
                }
                else{
                    comentsneg();

                    applyButton.setEnabled(true);
                    if(answer3.getText()==mAnswear){
                        back.setImageResource(R.drawable.backanswer2);
                        answer3.setTextColor(Color.GREEN);
                        answer3.startAnimation(anim);
                    }
                    if(answer2.getText()==mAnswear){
                        back.setImageResource(R.drawable.backanswer3);
                        answer2.setTextColor(Color.GREEN);
                        answer2.startAnimation(anim);
                    }
                    if(answer1.getText()==mAnswear){
                        back.setImageResource(R.drawable.backanswer1);
                        answer1.setTextColor(Color.GREEN);
                        answer1.startAnimation(anim);
                    }
                    life=0;
                    answer4.startAnimation(anim);

                }
            }
        });
        answeara = MediaPlayer.create(this, R.raw.answeara);
        answearb = MediaPlayer.create(this, R.raw.answearb);
        answearc = MediaPlayer.create(this, R.raw.answearc);
        answeard = MediaPlayer.create(this, R.raw.answeard);

        helpaudio = (ImageButton) findViewById(R.id.callbut);
        helpaudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helpaudio.setImageResource(R.drawable.notcall);
                helpaudio.setEnabled(false);
                am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

                if (answer1.getText() == mAnswear) {
                    answeara.start();
                }
                if (answer3.getText() == mAnswear) {
                    answearb.start();
                }
                if (answer2.getText() == mAnswear) {
                    answearc.start();
                }
                if (answer4.getText() == mAnswear) {
                    answeard.start();
                }
            }
        });


        help50Button = (ImageButton) findViewById(R.id.fifty);
        help50Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                help50Button.setImageResource(R.drawable.notfifty);
                help50Button.setEnabled(false);
                Random rand2 = new Random();
                int a=0;
                Button[] buttons = new Button[4];
                buttons[0]=answer1;
                buttons[1]=answer2;
                buttons[2]=answer3;
                buttons[3]=answer4;
                while(a<2)
                {
                    int random = rand2.nextInt(4);

                    if((buttons[random].getText()!=mAnswear)&&(buttons[random].getText()!="")) {
                        buttons[random].setText("");
                        buttons[random].setEnabled(false);
                        a++;
                    }

                }

            }


        });

        butfinish = (ImageButton) findViewById(R.id.finish);
        butfinish.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                dialoge1();

            }
        });


        helpaudition = (ImageButton) findViewById(R.id.people);
        helpaudition.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                helpaudition.setImageResource(R.drawable.notpeople);

                dialoge();

            }
        });

        Window w= getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    private void dialoge(){

        dialog= new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialoge);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);

        continiue = (ImageButton) dialog.findViewById(R.id.exit);
        continiue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void dialoge1(){

        dialog1= new Dialog(this);
        dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog1.setContentView(R.layout.diafin);
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog1.setCancelable(false);
        ido = (ImageButton) dialog1.findViewById(R.id.ido);
        ido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
            }
        });

        ino = (ImageButton) dialog1.findViewById(R.id.ino);
        ino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Nwlevel.this, Lastmenu.class);
                startActivity(intent);
                finish();
            }
        });

        dialog1.show();
    }

    private void updateQuestion(int num){
        question.setText(mQuestion.getQuestion(num));
        answer1.setText(mQuestion.getChoice1(num));
        answer2.setText(mQuestion.getChoice2(num));
        answer3.setText(mQuestion.getChoice3(num));
        answer4.setText(mQuestion.getChoice4(num));
        mAnswear= mQuestion.getCorrectAnswear(num);
    }
    public void coments(){
        if(mScore%2==0)
            coments.setText("Ура!Ви відповіли на "+(mScore+1)+" запитання."+"Ваші бали-" +check((mScore+1)));
        else
            coments.setText("Так тримати!Ви відповіли на "+(mScore+1)+" запитання."+"Ваші бали-" +check((mScore+1)));
    }

    public void comentsneg(){
        if(mScore<6)
            coments.setText("Це ганьба! Таке мають всі знати");
        else
            coments.setText("Зарах є та й добре!");
    }
    public  int check(int mScore){

        int numtrys=0;
        switch(mScore) {
            case 1:
                numpoints = 1;

                break;
            case 2:
                numpoints = 3;

                break;
            case 3:
                numpoints = 8;

                break;
            case 4:
                numpoints = 12;

                break;
            case 5:
                numpoints = 20;

                break;
            case 6:
                numpoints = 30;

                break;
            case 7:
                numpoints = 40;

                break;
            case 8:
                numpoints = 60;

                break;
            case 9:
                numpoints = 85;

                break;
            case 10:
                numpoints = 100;

                break;
            case 11:
                numpoints = 120;

                break;
            case 12:
                numpoints = 135;

                break;
            case 13:
                numpoints = 150;

                break;
            case 14:
                numpoints = 180;

                break;
            case 15:
                numpoints = 200;

                break;
            default:
                break;
        }
        return  numpoints;
    }


    /**
     * Get stat to end menu
     */
    public void getStatForEndmenu(){
        Intent intentEnd = new Intent(Nwlevel.this,Lastmenu.class);
        if(mScore<6)
            numpoints=0;
        else if(mScore>=6)
            numpoints=60;
        else if(mScore>=14)
            numpoints=200;

        intentEnd.putExtra("numpints",numpoints);
        startActivity(intentEnd);
    }
    public void getStatForSettins(){
        Intent intent = new Intent(Nwlevel.this,GameStat.class);
        intent.putExtra("numpints",numpoints);
        intent.putExtra("mScrore",mScore);
        startActivity(intent);
    }

    //system button back

    /**
     * Go to previos menu
     */
    public void onBackPressed(){
        try{
            Intent intent =new Intent(Nwlevel.this,PlayButtom.class);
            startActivity(intent);
            finish();
        }
        catch (Exception e){

        }
    }

    /**
     * Saves data
     */
    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("mScore",mScore);
        editor.putInt("numpoints",numpoints);
        editor.putInt("rescopy",numpoints);
        editor.apply();

    }




}