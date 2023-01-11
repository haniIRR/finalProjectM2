package com.kazemi.finalprojectm2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class music_player extends AppCompatActivity {

    TextView currenttime,totaltime,songtitleplayer;
    SeekBar seekBar;
    ImageView puseplay,musicimg,nextbtn,prebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        currenttime=findViewById(R.id.currenttime);
        totaltime=findViewById(R.id.totaltime);
        songtitleplayer=findViewById(R.id.songTitlePlayer);
        seekBar=findViewById(R.id.seekbar);
        puseplay=findViewById(R.id.pause_play);
        musicimg=findViewById(R.id.img_music_player);
        nextbtn=findViewById(R.id.nextbtn);
        prebtn=findViewById(R.id.previousbtn);
    }
}