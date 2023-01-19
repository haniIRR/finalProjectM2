package com.kazemi.finalprojectm2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;

public class PlayMusic extends AppCompatActivity {

    ImageView songimg,imgpre,imgpost,imgpause,imgplay;
    TextView songerName,songTitle,currenttime,totaltime;

    MediaPlayer mediaPlayer;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        songimg=(ImageView)findViewById(R.id.img_music_player);
        songTitle=findViewById(R.id.songTitlePlayer);
        songerName=findViewById(R.id.songTitlePlayer);
        imgpause=findViewById(R.id.pause);
        imgplay=findViewById(R.id.play);
        imgpost=findViewById(R.id.nextbtn);
        imgpre=findViewById(R.id.previousbtn);
        currenttime=findViewById(R.id.currenttime);
        totaltime=findViewById(R.id.totaltime);
        mediaPlayer=new MediaPlayer();


        Intent i=getIntent();
        String songName=i.getStringExtra("songName");
        String songerName=i.getStringExtra("songerName");
        String imgurl=i.getStringExtra("imgurl");
        String songurl=i.getStringExtra("songurl");




        Toast.makeText(this,songName, Toast.LENGTH_SHORT).show();


        songTitle.setText(songName+" "+songerName);
        Picasso.get().load(imgurl).into(songimg);

        try {
            mediaPlayer.setDataSource(songurl);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.start();


        imgpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause();
            }
        });

        imgplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }
        });

    }

    private void play() {
        mediaPlayer.start();
        imgplay.setVisibility(View.INVISIBLE);
        imgpause.setVisibility(View.VISIBLE);
    }

    private void pause() {
        mediaPlayer.pause();
        imgpause.setVisibility(View.INVISIBLE);
        imgplay.setVisibility(View.VISIBLE);
    }


}