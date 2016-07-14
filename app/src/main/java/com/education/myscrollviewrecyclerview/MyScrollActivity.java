package com.education.myscrollviewrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ScrollView;

import java.util.Arrays;

public class MyScrollActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MyScrollview mScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_scroll);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(new MyAdapter(Arrays.asList(new String[20])));
        mScrollView = (MyScrollview) findViewById(R.id.scrollview);
        mScrollView.smoothScrollTo(0, 20);
    }
}
