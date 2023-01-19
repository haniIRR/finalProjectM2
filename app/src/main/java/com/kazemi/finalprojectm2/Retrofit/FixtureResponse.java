package com.kazemi.finalprojectm2.Retrofit;

import com.kazemi.finalprojectm2.Models.SongData;

import java.util.ArrayList;
import java.util.List;

public class FixtureResponse {
    private Integer total;
    public ArrayList<SongData> results=new ArrayList<>();
    public Integer getTotal(){return total;}
    public void setTotal(Integer total){this.total=total;}
    public List<SongData> getResults(){return results;}
    public void setResult(List<SongData> results){this.results= (ArrayList<SongData>) results;}
}
