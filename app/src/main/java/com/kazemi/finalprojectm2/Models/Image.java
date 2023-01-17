package com.kazemi.finalprojectm2.Models;

import com.google.android.material.slider.Slider;

public class Image {
    public ThumbnailSmall thumbnail_small;
    public Thumbnail thumbnail;
    public CoverSmall cover_small;
    public Cover cover;
    public Slider slider;

    public ThumbnailSmall getThumbnail_small() {
        return thumbnail_small;
    }

    public void setThumbnail_small(ThumbnailSmall thumbnail_small) {
        this.thumbnail_small = thumbnail_small;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public CoverSmall getCover_small() {
        return cover_small;
    }

    public void setCover_small(CoverSmall cover_small) {
        this.cover_small = cover_small;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public Slider getSlider() {
        return slider;
    }

    public void setSlider(Slider slider) {
        this.slider = slider;
    }
}
