package com.kausthubhadhikari.moviesdb.drawerfragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kausthubhadhikari.moviesdb.R;

import java.util.ArrayList;

/**
 * Created by kausthubhadhikari on 14/12/16.
 */

public abstract class RecyclerViewAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<T> data = new ArrayList<T>();

    public RecyclerViewAdapter(ArrayList<T> data) {
        this.data = data;
    }

    public abstract void onBindData(ViewHolder holder, T data);

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        onBindData(holder, data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void updateData(ArrayList<T> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }
}
