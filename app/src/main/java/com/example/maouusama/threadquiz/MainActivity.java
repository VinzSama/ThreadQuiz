package com.example.maouusama.threadquiz;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    Switch mSwOnOff;
    TextView mTvScore;
    TextView mTvColor;
    TextView mTvColorText;
    Button mBtnTrue;
    Button mBtnFalse;
    CountDownTimer myTimer;

    int time=10;
    Handler handler = new Handler();
    Runnable r = new Runnable() {
        @Override
        public void run() {
            mTvColor.setText(time + "");
            time--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwOnOff = (Switch) findViewById(R.id.swOnOff);
        mTvScore = (TextView) findViewById(R.id.tvScore);
        mTvColor = (TextView) findViewById(R.id.tvColor);
        mTvColorText = (TextView) findViewById(R.id.tvColorText);
        mBtnFalse = (Button) findViewById(R.id.btnFalse);
        mBtnTrue = (Button) findViewById(R.id.btnTrue);

        mSwOnOff.setOnCheckedChangeListener(this);
        mTvColor.setBackgroundColor(Color.GREEN);


        /*myTimer = new CountDownTimer(time, 1000) {

            public void onTick(long millisUntilFinished) {
                long currTime = 0;
                if(millisUntilFinished>0)
                    currTime = millisUntilFinished / 1000;
                mTvColor.setText("" + currTime);
                StartTimer timer = new StartTimer();
                timer.execute();
            }

            public void onFinish() {
                mTvColor.setText("0");
            }

        };*/


    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {



        if (isChecked) {
            changeColor();
                handler.postDelayed(r, 0);
        } else {
            mTvColor.setText("10");
        }
}

    public void changeColor() {
        Random rand = new Random();
        Random randColor = new Random();

        int randColorBack = randColor.nextInt((5-1)+1)+1;
        int randColorText = rand.nextInt((5-1)+1)+1;

        switch(randColorBack){
            case 1: mTvColor.setBackgroundColor(Color.RED);
                break;
            case 2: mTvColor.setBackgroundColor(Color.BLUE);
                break;
            case 3: mTvColor.setBackgroundColor(Color.GREEN);
                break;
            case 4: mTvColor.setBackgroundColor(Color.GRAY);
                break;
            case 5: mTvColor.setBackgroundColor(Color.CYAN);
                break;
        }
        switch(randColorText){
            case 1: mTvColorText.setText("Red");
                break;
            case 2: mTvColorText.setText("Blue");
                break;
            case 3: mTvColorText.setText("Cyan");
                break;
            case 4: mTvColorText.setText("Gray");
                break;
            case 5: mTvColorText.setText("Green");
                break;
        }
    }

    /*public class StartTimer extends AsyncTask<Void, Void, Void>{


        @Override
        protected void onPreExecute(){
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... params) {
            try{

            }catch(Exception e){

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void voids){
            super.onPostExecute(null);
        }
    }*/
}
