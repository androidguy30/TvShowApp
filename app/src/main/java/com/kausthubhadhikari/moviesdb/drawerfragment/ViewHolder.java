package com.kausthubhadhikari.moviesdb.drawerfragment;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.kausthubhadhikari.moviesdb.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by kausthubhadhikari on 14/12/16.
 */

public class ViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.avatar)
    public ImageView avatar;

    @Bind(R.id.showName)
    public AppCompatTextView showName;

    @Bind(R.id.genre)
    public AppCompatTextView votes;

    @Bind(R.id.desc)
    public AppCompatTextView desc;

    public ViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
