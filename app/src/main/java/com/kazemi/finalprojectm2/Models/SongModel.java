package com.kazemi.finalprojectm2.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;

public class SongModel {
    @Expose
    @SerializedName("album")
    String album;

    @Expose
    @SerializedName("artists")
    String artists;

    @Expose
    @SerializedName("audio")
    String audio;

    @Expose
    @SerializedName("image")
    String image;

    public SongModel(String album, String artists, String audio, String image) {
        this.album = album;
        this.artists = artists;
        this.audio = audio;
        this.image = image;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtists() {
        return artists;
    }

    public String getAudio() {
        return audio;
    }

    public String getImage() {
        return image;
    }
}
