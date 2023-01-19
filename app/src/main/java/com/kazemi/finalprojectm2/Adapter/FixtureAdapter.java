package com.kazemi.finalprojectm2.Adapter;

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
    public void onBindViewHolder(@NonNull FixtureViewHolder holder, int position) {

        final SongData data = list.get(position);

        Picasso.get().load(data.image.toString()).into(holder.imgsong);
        holder.songtitle.setText(data.title);
        holder.songdate.setText(data.releaseDate.toString());
        holder.songername.setText(data.artists.toString());



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(v.getContext(), PlayMusic.class);
                i.putExtra("song",holder.songtitle.getText().toString());
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
    TextView songtitle, songdate, songername ;

    public FixtureViewHolder(@NonNull View itemView) {
        super(itemView);

        songdate=itemView.findViewById(R.id.textdate);
        songername=itemView.findViewById(R.id.textname);
        songtitle=itemView.findViewById(R.id.texttitle);
        imgsong=itemView.findViewById(R.id.imagesong);


    }


}
