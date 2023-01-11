package com.kazemi.finalprojectm2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {
    SongData [] songData;
    Context context;

    public SongAdapter(SongData[] songData,MainActivity activity) {
        this.songData=songData;
        this.context=activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.song_item_list,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final SongData songDataList=songData[position];
        holder.txttitle.setText(songDataList.getSongtitle());
        holder.txtname.setText(songDataList.getSongname());
        holder.txtdate.setText(songDataList.getSongdate());
        holder.imgsong.setImageResource(songDataList.getSongimage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,songDataList.getSongname(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return songData.length;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgsong;
        TextView txtname;
        TextView txtdate;
        TextView txttitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgsong=itemView.findViewById(R.id.imagesong);
            txtdate=itemView.findViewById(R.id.textdate);
            txtname=itemView.findViewById(R.id.textname);
            txttitle=itemView.findViewById(R.id.texttitle);

        }
    }
}
