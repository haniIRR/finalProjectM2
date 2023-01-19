package com.kazemi.finalprojectm2.Models;

import com.google.android.material.slider.Slider;

import java.util.ArrayList;
import java.util.Date;

public class SongData {
    public String id;
    public Album album;
    public ArrayList<Artist> artists;
    public Audio audio;
    public boolean copyrighted;
    public boolean localized;
    public String downloadCount;
    public int duration;
    public boolean hasVideo;
    public String title;
    public Image image;
    public Date releaseDate;

    public class Album{
        public String name;
        public ArrayList<Artist> artists;
        public Image image;
        public Date releaseDate;
    }

    public class Artist{
        public String id;
        public int followersCount;
        public String fullName;
        public String type;
        public String sumSongsDownloadsCount;
        public Image image;
    }

    public class Audio{
        public Medium medium;
        public High high;
    }

    public class Cover{
        public String url;
    }

    public class CoverSmall{
        public String url;
    }

    public class High{
        public String fingerprint;
        public String url;
    }

    public class Image{
        public ThumbnailSmall thumbnail_small;
        public Thumbnail thumbnail;
        public CoverSmall cover_small;
        public Cover cover;
        public Slider slider;
    }

    public class Medium{
        public String fingerprint;
        public String url;
    }



    public class Root{
        public int total;
        public ArrayList<SongData> results;
    }

    public class Slider{
        public String url;
    }

    public class Thumbnail{
        public String url;
    }

    public class ThumbnailSmall{
        public String url;
    }



}
