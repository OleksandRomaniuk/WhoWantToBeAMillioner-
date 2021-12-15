package com.example.game;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class GameStat extends AppCompatActivity {

    TextView numpoint,numtry,numanswear,numtruavt,numtopscore;
    int numpoints,numtrys,mScore,numAllpoints,numofwin,numoflose,allscore,sc,count,allcount,hightlv=0;
    private static final String FILE_NAME = "example.txt";
    Nwlevel nw;
    public static final String SHARED_PREFS = "sharedPrefs";


    /**
     * Creates a  Game Stat Menu
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuplayout);
        numpoint=(TextView)findViewById(R.id.numpoint);
        numtry=(TextView)findViewById(R.id.numtry);
        numanswear=(TextView)findViewById(R.id.numanswear);
        numtruavt=(TextView)findViewById(R.id.numtruavt);
        numtopscore=(TextView)findViewById(R.id.numtopscore);

        PieChart pieChart = findViewById(R.id.piecha);
        pieChart.setUsePercentValues(true);

       /* SharedPreferences myScore = this.getSharedPreferences("MyAwesomeScore", Context.MODE_PRIVATE);
        mScore = myScore.getInt("mScore", 0);*/





     /*   SharedPreferences myScore = getSharedPreferences("MyAwesomeScore", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = myScore.edit();
        editor.putInt("mScore", mScore); editor.commit(); */

        loadData();
        updateAll();


        numpoint.setText(""+numAllpoints);
        numtry.setText(""+(numoflose+numofwin));
        numanswear.setText(""+ allscore);
        numtopscore.setText(""+hightlv);
        numtruavt.setText(""+count);

        List<PieEntry> value = new ArrayList<>();
        value.add(new PieEntry(numofwin,"Win"));
        value.add(new PieEntry(numoflose,"lose"));

        PieDataSet pieDataSet = new PieDataSet(value , "Games");
        PieData pieData =new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieDataSet.setColors(ColorTemplate.PASTEL_COLORS);
        pieChart.setHoleRadius(0f);
        pieChart.getDescription().setEnabled(false);
        pieDataSet.setValueTextSize(12);

        saveData();


        Window w= getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    public void updateAll() {
        if(hightlv<sc){
            hightlv=sc;

        }


        allcount+=count;
        if (mScore == 15 ) {
            numofwin++;

        }
        else  if(mScore<15 && mScore>0)
            numoflose++;

        check();

        if(numpoints>=60)
            numAllpoints += numpoints;

        allscore+=mScore;
    }
    public  void check(){


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

    }

    /**
     * Loads current data
     */
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        count=sharedPreferences.getInt("count",count);
        mScore = sharedPreferences.getInt("mScore",mScore);
        numpoints = sharedPreferences.getInt("numpoints",numpoints);
        numoflose = sharedPreferences.getInt("numoflose",numoflose);
        numofwin= sharedPreferences.getInt("numofwin",numofwin);
        numAllpoints= sharedPreferences.getInt("numAllpoints",numAllpoints);
        allscore= sharedPreferences.getInt("allscore", allscore);
        sc= sharedPreferences.getInt("sc", sc);


        hightlv=sharedPreferences.getInt("hightlv", hightlv);


    }

    /**
     * Saves current Data
     */
    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("numofwin",numofwin);
        editor.putInt("numoflose",numoflose);
        editor.putInt("numAllpoints", numAllpoints);
        editor.putInt("allscore", allscore);
        editor.putInt("mScore",0);
        editor.putInt("numpoints",0);
        editor.putInt("count",count);
        editor.putInt("sc",0);
        editor.putInt(" hightlv", hightlv);

        editor.apply();

    }



    //system button back

    public void onBackPressed(){
        try{
            Intent intent =new Intent(GameStat.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        catch (Exception e){

        }
    }




}
