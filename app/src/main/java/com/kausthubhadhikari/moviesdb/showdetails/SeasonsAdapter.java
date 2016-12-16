package com.kausthubhadhikari.moviesdb.showdetails;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.kausthubhadhikari.moviesdb.model.pojo.detail.Season;

import java.util.ArrayList;

/**
 * Created by kausthubhadhikari on 16/12/16.
 */

public class SeasonsAdapter extends RecyclerView.Adapter<SeasonHolder> {

    private ArrayList<Season> seasons = new ArrayList<>();

    public SeasonsAdapter(ArrayList<Season> seasons) {
        this.seasons = seasons;
    }

    @Override
    public SeasonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(SeasonHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
