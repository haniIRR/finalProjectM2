package com.kazemi.finalprojectm2;

public class SongData {
    private String songtitle;
    private String songname;
    private String songdate;
    private  Integer songimage;

    public SongData(String songtitle, String songname, String songdate, Integer songimage) {
        this.songtitle = songtitle;
        this.songname = songname;
        this.songdate = songdate;
        this.songimage = songimage;
    }

    public String getSongtitle() {
        return songtitle;
    }

    public void setSongtitle(String songtitle) {
        this.songtitle = songtitle;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public String getSongdate() {
        return songdate;
    }

    public void setSongdate(String songdate) {
        this.songdate = songdate;
    }

    public Integer getSongimage() {
        return songimage;
    }

    public void setSongimage(Integer songimage) {
        this.songimage = songimage;
    }
}
