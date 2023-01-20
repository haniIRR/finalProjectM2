package com.kazemi.finalprojectm2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

public class PlayMusic extends AppCompatActivity {

    Handler handler;
    ImageView songimg;
    ImageButton btnpre,btnpost,btnpause,btnplay;
    TextView songerName,songTitle,currenttime,totaltime;

    MediaPlayer mediaPlayer;
    SeekBar seekBar;
    Integer position;

    ArrayList<String>arrayListurl;
    ArrayList<String>arrayListimage;
    ArrayList<String>arrayListartist;
    ArrayList<String>arrayListtitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        songimg=(ImageView)findViewById(R.id.img_music_player);
        songTitle=findViewById(R.id.songTitlePlayer);
        //songerName=findViewById(R.id.songTitlePlayer);
        btnpause=findViewById(R.id.pause);
        btnplay=findViewById(R.id.play);
        btnpost=findViewById(R.id.nextbtn);
        btnpre=findViewById(R.id.previousbtn);
        currenttime=findViewById(R.id.currenttime);
        totaltime=findViewById(R.id.totaltime);
        mediaPlayer=new MediaPlayer();
        seekBar=findViewById(R.id.seekbar);
        handler=new Handler();



        btnpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrayListurl.size()==position+1){
                    position=0;
                    init(arrayListurl.get(position),arrayListtitle.get(position),arrayListartist.get(position),arrayListimage.get(position));
                }
                else {
                    position=position+1;
                    init(arrayListurl.get(position),arrayListtitle.get(position),arrayListartist.get(position),arrayListimage.get(position));
                }
            }
        });

        btnpre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position==0){
                    position=arrayListurl.size()-1;
                    init(arrayListurl.get(position),arrayListtitle.get(position),arrayListartist.get(position),arrayListimage.get(position));
                }
                else {
                    position=position-1;
                    init(arrayListurl.get(position),arrayListtitle.get(position),arrayListartist.get(position),arrayListimage.get(position));

                }
            }
        });






        Intent i=getIntent();
        String songName=i.getStringExtra("songName");
        String songerName=i.getStringExtra("songerName");
        String imgurl=i.getStringExtra("imgurl");
        String songurl=i.getStringExtra("songurl");

        arrayListartist=i.getStringArrayListExtra("arrayListartists");
        arrayListurl=i.getStringArrayListExtra("arrayListurl");
        arrayListimage=i.getStringArrayListExtra("arrayListimage");
        arrayListtitle=i.getStringArrayListExtra("arrayListtitle");
        position=Integer.parseInt(i.getStringExtra("position"));




        Toast.makeText(this,songName, Toast.LENGTH_SHORT).show();


        init(songurl,songName,songerName,imgurl);


        btnpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause();
            }
        });

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }
        });

    }

    private void init(String songurl, String songName, String songerName, String imgurl) {
        songTitle.setText(songName+" "+songerName);
        Picasso.get().load(imgurl).into(songimg);

        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }



        try {
            mediaPlayer=new MediaPlayer();
            mediaPlayer.setDataSource(songurl);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
        initializeSeekbar();

    }

    private void initializeSeekbar() {
        seekBar.setMax(mediaPlayer.getDuration()/1000);


    }

    private void play() {
        mediaPlayer.start();
        btnplay.setVisibility(View.INVISIBLE);
        btnpause.setVisibility(View.VISIBLE);
    }

    private void pause() {
        mediaPlayer.pause();
        btnpause.setVisibility(View.INVISIBLE);
        btnplay.setVisibility(View.VISIBLE);
    }


}