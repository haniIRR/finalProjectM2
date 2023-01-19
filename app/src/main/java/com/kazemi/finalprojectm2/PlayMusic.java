package com.kazemi.finalprojectm2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class PlayMusic extends AppCompatActivity {

    ImageView songimg;
    TextView songerName,songTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        songimg=(ImageView)findViewById(R.id.img_music_player);
        songTitle=findViewById(R.id.songTitlePlayer);


        Intent i=getIntent();
        String songName=i.getStringExtra("songName");
        String songerName=i.getStringExtra("songerName");
        String imgurl=i.getStringExtra("imgurl");


        Toast.makeText(this,songName, Toast.LENGTH_SHORT).show();


        songTitle.setText(songName+" "+songerName);
        Picasso.get().load(imgurl).into(songimg);

    }


}