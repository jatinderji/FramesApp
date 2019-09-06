package com.jatin.framesapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    LinearLayout myLay;
    Switch theme;
    ImageView img,frame;
    Button btnNext;
    int cnt = -1;
    int frames[]={R.drawable.frame1,R.drawable.frame2,R.drawable.frame3,R.drawable.frame4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        theme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    myLay.setBackgroundColor(Color.BLACK);
                else
                    myLay.setBackgroundColor(Color.GRAY);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(cnt<frames.length-1)
                 {
                 cnt++;
                 frame.setImageResource(frames[cnt]);
                 }
                else
                 {
                    cnt = 0;
                    frame.setImageResource(frames[cnt]);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.cRed:
                myLay.setBackgroundColor(Color.RED);
                return true;
            case R.id.cYellow:
                myLay.setBackgroundColor(Color.YELLOW);
                return true;
            case R.id.cWhite:
                myLay.setBackgroundColor(Color.WHITE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initViews()
    {
        btnNext = findViewById(R.id.btnNext);
        img = findViewById(R.id.myImg);
        theme = findViewById(R.id.theme);
        myLay = findViewById(R.id.myLay);
        frame = findViewById(R.id.myFrame);
    }

}
