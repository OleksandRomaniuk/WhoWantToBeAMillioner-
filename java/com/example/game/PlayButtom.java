package com.example.game;

import android.app.AutomaticZenRule;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PlayButtom extends AppCompatActivity {

    private int mode=1;

    private int qwestiom=1;
    private boolean isClassic=true;
    private boolean isGeneral=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);

        final ImageButton buttonClassicmode=(ImageButton)findViewById(R.id.clasicmode);
        final ImageButton buttonAvtorode=(ImageButton)findViewById(R.id.originalmode);
        final ImageButton buttonStart=(ImageButton)findViewById(R.id.start);
        final ImageButton buttonKMA=(ImageButton)findViewById(R.id.fi);
        final ImageButton buttongeneral=(ImageButton)findViewById(R.id.general);


        buttonClassicmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    isClassic=true;
                    buttonKMA.setEnabled(true);
                    mode=1;
                    Toast.makeText(PlayButtom.this, "Ви вибрали класичний режим", Toast.LENGTH_SHORT).show();
                    buttonClassicmode.setImageResource(R.drawable.classmodeacept);
                    buttonAvtorode.setImageResource(R.drawable.avtormode);


                }
                catch (Exception e) {

                }
            }
        });


        buttonAvtorode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    isClassic=false;
                    mode=2;
                    Toast.makeText(PlayButtom.this, "Ви вибрали авторський режим", Toast.LENGTH_SHORT).show();
                    buttonClassicmode.setImageResource(R.drawable.clasicmode);
                    buttonAvtorode.setImageResource(R.drawable.avtormodeaccept);
                    buttonKMA.setImageResource(R.drawable.fi);
                    buttonKMA.setEnabled(false);
                    buttongeneral.setImageResource(R.drawable.generalaccept);

                }
                catch (Exception e) {

                }
            }
        });



        buttonKMA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    isGeneral=false;
                    qwestiom=1;
                    Toast.makeText(PlayButtom.this, "Ви вирішили обрати питання з теми ФІ", Toast.LENGTH_SHORT).show();


                    buttonKMA.setImageResource(R.drawable.kmaaccept);
                    buttongeneral.setImageResource(R.drawable.general);
                }
                catch (Exception e) {

                }
            }
        });


        buttongeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    isGeneral=true;
                    qwestiom=2;

                    buttonKMA.setImageResource(R.drawable.fi);
                    buttongeneral.setImageResource(R.drawable.generalaccept);
                    Toast.makeText(PlayButtom.this, "Ви вирішили обрати питання на загальну тематику", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e) {

                }
            }
        });

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isClassic==true){
                    if(isGeneral==true){
                    try{
                        Intent intent =new Intent(PlayButtom.this,Nwlevel.class);
                        startActivity(intent);finish();
                    }
                    catch (Exception e) {

                    }
                }
                    if(isGeneral==false){
                        try{
                            Intent intent =new Intent(PlayButtom.this,NwlevelFi.class);
                            startActivity(intent);finish();
                        }
                        catch (Exception e) {

                        }
                    }
                }




                if(isClassic==false){
                    try{
                        Intent intent =new Intent(PlayButtom.this,NwlevelAvtor.class);
                        startActivity(intent);finish();
                    }
                    catch (Exception e) {

                    }
                }}

        });

        Window w= getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



    }
    //system button back
    public void seecbar(){

    }
    public void onBackPressed(){
        try{
            Intent intent =new Intent(PlayButtom.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        catch (Exception e){

        }
    }

}
