package com.kausthubhadhikari.moviesdb.showdetails;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by kausthubhadhikari on 16/12/16.
 */

public class SeasonHolder extends RecyclerView.ViewHolder {


    public SeasonHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
