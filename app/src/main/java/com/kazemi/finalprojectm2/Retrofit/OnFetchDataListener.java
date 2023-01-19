package com.kazemi.finalprojectm2.Retrofit;

public interface OnFetchDataListener {
    void didFetch(FixtureResponse response , String status);
    void didError(String status);

}
