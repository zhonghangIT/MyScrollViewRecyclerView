package com.education.myscrollviewrecyclerview;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhonghang on 16/7/14.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_recycler, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FullyGridLayoutManager manager = new FullyGridLayoutManager(holder.recyclerView.getContext(), 3);
        holder.list.clear();
        holder.list.addAll(Arrays.asList(new String[(position + 100) % 23]));
        holder.adapter.notifyDataSetChanged();
//        holder.recyclerView.setAdapter(new MyAdapter(Arrays.asList(new String[(position + 100) % 23])));
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        MyAdapter adapter;
        List<String> list;

        public MyViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerview_child);
            FullyGridLayoutManager manager = new FullyGridLayoutManager(itemView.getContext(), 3);
            recyclerView.setLayoutManager(manager);
            list = new ArrayList<>();
            adapter = new MyAdapter(list);
            recyclerView.setAdapter(adapter);
        }
    }
}
