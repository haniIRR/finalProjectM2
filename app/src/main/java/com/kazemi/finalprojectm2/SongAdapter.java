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

import com.kazemi.finalprojectm2.Models.Album;
import com.kazemi.finalprojectm2.Models.Artist;
import com.kazemi.finalprojectm2.Models.Cover;
import com.kazemi.finalprojectm2.Models.Image;
import com.kazemi.finalprojectm2.Models.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {
    SongData [] songData;
    Context context;
    private List<Result> resultList;
    private  Cover cover;

    public SongAdapter(Cover cover) {
        this.cover = cover;
    }

    public SongAdapter(List<Result> resultList) {
        this.resultList = resultList;
    }

    public SongAdapter(SongData[] songData, MainActivity activity) {
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
        //final SongData songDataList=songData[position];
        //holder.txttitle.setText(songDataList.getSongtitle());
        //holder.txtname.setText(songDataList.getSongname());
        //holder.txtdate.setText(songDataList.getSongdate());
        //holder.imgsong.setImageResource(songDataList.getSongimage());

        holder.txttitle.setText(resultList.get(position).getTitle());
        holder.txtname.setText((CharSequence) resultList.get(position).getArtists());
        holder.txtdate.setText((CharSequence) resultList.get(position).getReleaseDate());
        Picasso.get().load(cover.getUrl()).into(holder.imgsong);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,resultList.get(holder.getAdapterPosition()).getTitle(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return resultList.size();
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
