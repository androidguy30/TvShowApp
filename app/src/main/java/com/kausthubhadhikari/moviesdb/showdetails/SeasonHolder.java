package com.kausthubhadhikari.moviesdb.showdetails;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.kausthubhadhikari.moviesdb.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kausthubhadhikari on 16/12/16.
 */

public class SeasonHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.seasonImage)
    public ImageView seasonImageView;

    public SeasonHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
