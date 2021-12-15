package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        Window w= getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    //system button back

    /**
     * Back to previos menu
     */
public void onBackPressed(){
        try{
            Intent intent =new Intent(MenuActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        catch (Exception e){

        }
}

}
