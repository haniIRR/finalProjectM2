package com.kazemi.finalprojectm2;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.kazemi.finalprojectm2.Adapter.FixtureAdapter;
import com.kazemi.finalprojectm2.Retrofit.FixtureResponse;
import com.kazemi.finalprojectm2.Retrofit.OnFetchDataListener;
import com.kazemi.finalprojectm2.Retrofit.RequestManager;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RequestManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        manager = new RequestManager(this);
        manager.getFixture(listener);





    }
    private final OnFetchDataListener listener = new OnFetchDataListener() {

        @Override
        public void didFetch(FixtureResponse response, String status) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL , false));
            FixtureAdapter adapter = new FixtureAdapter(MainActivity.this, response.data);
            recyclerView.setAdapter(adapter);
        }

        @Override
        public void didError(String status) {
            Toast.makeText(MainActivity.this, status, Toast.LENGTH_SHORT).show();
        }
    };


}