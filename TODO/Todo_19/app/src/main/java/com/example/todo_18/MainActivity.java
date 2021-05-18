package com.example.todo_18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecycleView;
    private ArrayList<Sport> mSportsData;
    private  SportsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        mRecycleView = (RecyclerView)findViewById(R.id.recycleview);
        mRecycleView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
        mSportsData = new ArrayList<>();

        mAdapter = new SportsAdapter(this,mSportsData);
        mRecycleView.setAdapter(mAdapter);

        initializeData();
    }

    private void initializeData() {
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.sports_img);
        String[] sportList = getResources().getStringArray(R.array.sports_title);
        String[] sportInfo = getResources().getStringArray(R.array.sports_info);

        mSportsData.clear();

        for (int i=0; i<sportList.length; i++){
            mSportsData.add(new Sport(sportList[i],sportInfo[i], sportsImageResources.getResourceId(i,0)));


        }
        //notify the adapter of the change
        mAdapter.notifyDataSetChanged();
        sportsImageResources.recycle();
    }


}