package com.kazemi.finalprojectm2.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kazemi.finalprojectm2.Models.SongData;
import com.kazemi.finalprojectm2.PlayMusic;
import com.kazemi.finalprojectm2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FixtureAdapter extends RecyclerView.Adapter<FixtureViewHolder> {
    Context context;
    List<SongData> list;
    ArrayList<String>arrayListurl=new ArrayList<>();
    ArrayList<String>arrayListtitle=new ArrayList<>();
    ArrayList<String>arrayListartists=new ArrayList<>();
    ArrayList<String>arrayListimage=new ArrayList<>();

    public FixtureAdapter(Context context, ArrayList<SongData> songlist) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FixtureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FixtureViewHolder(LayoutInflater.from(context).inflate(R.layout.song_item_list , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull FixtureViewHolder holder, @SuppressLint("RecyclerView") int position) {

        final SongData songData = list.get(position);

        Picasso.get().load(songData.image.toString()).into(holder.imgsong);
        holder.songtitle.setText(songData.title);
        holder.songdate.setText(songData.releaseDate.toString());
        holder.songername.setText(songData.artists.toString());
        holder.songurl.setText(songData.audio.medium.url);
        holder.imgsongurl.setText(songData.album.image.toString());




        if (!arrayListurl.contains(songData.audio.medium.url))
            arrayListurl.add(songData.audio.medium.url);
        if (!arrayListtitle.contains(songData.title))
            arrayListtitle.add(songData.title);
        if (!arrayListartists.contains(songData.artists))
            arrayListartists.add(songData.artists.toString());
        if (!arrayListimage.contains(songData.album.image))
            arrayListimage.add(songData.album.image.toString());




        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(v.getContext(), PlayMusic.class);
                i.putExtra("songName",holder.songtitle.getText().toString());
                i.putExtra("songerName",holder.songername.getText().toString());
                i.putExtra("url",holder.songurl.getText().toString());
                i.putExtra("imgurl",holder.imgsongurl.toString());

                i.putExtra("arrayListurl",arrayListurl);
                i.putExtra("arrayListartists",arrayListartists);
                i.putExtra("arrayListimage",arrayListimage);
                i.putExtra("arrayListtitle",arrayListtitle);
                i.putExtra("position",String.valueOf(position));


                v.getContext().startActivity(i);

            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class FixtureViewHolder extends RecyclerView.ViewHolder {
    ImageView imgsong;
    TextView songtitle, songdate, songername,songurl,imgsongurl ;

    public FixtureViewHolder(@NonNull View itemView) {
        super(itemView);
        //songurl=itemView.findViewById(R.id.)
        songdate=itemView.findViewById(R.id.textdate);
        songername=itemView.findViewById(R.id.textname);
        songtitle=itemView.findViewById(R.id.texttitle);
        imgsong=itemView.findViewById(R.id.imagesong);


    }


}
