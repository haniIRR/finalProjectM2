package com.kazemi.finalprojectm2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SongData[] songData=new SongData[]{
          new SongData("siahsefid","milad","1401.5.10",R.drawable.logo),
          new SongData("aho","saeed","1401.5.20",R.drawable.logo)
        };

            SongAdapter songAdapter=new SongAdapter(songData,MainActivity.this);
            recyclerView.setAdapter(songAdapter);
    }
}