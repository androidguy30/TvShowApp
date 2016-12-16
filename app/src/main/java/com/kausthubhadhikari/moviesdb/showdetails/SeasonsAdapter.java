package com.kausthubhadhikari.moviesdb.showdetails;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kausthubhadhikari.moviesdb.AppController;
import com.kausthubhadhikari.moviesdb.R;
import com.kausthubhadhikari.moviesdb.model.pojo.detail.Season;
import com.kausthubhadhikari.moviesdb.utils.misc.AppConstants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by kausthubhadhikari on 16/12/16.
 */

public class SeasonsAdapter extends RecyclerView.Adapter<SeasonHolder> {

    private ArrayList<Season> seasons = new ArrayList<>();
    private Picasso picasso;
    private Context context;

    public SeasonsAdapter(Context context, ArrayList<Season> seasons, Picasso picasso) {
        this.seasons = seasons;
        this.picasso = picasso;
        this.context = context;
    }

    @Override
    public SeasonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seasons_item_layout, parent, false);
        SeasonHolder seasonHolder = new SeasonHolder(view);
        return seasonHolder;
    }

    @Override
    public void onBindViewHolder(SeasonHolder holder, int position) {
        picasso.load(((AppController) context.getApplicationContext()).getBaseURL() + AppConstants.POSTER_BASE_URL_LOW + seasons.get(position).posterPath).into(holder.seasonImageView);
    }

    @Override
    public int getItemCount() {
        return seasons.size();
    }

    public void updateData(ArrayList<Season> data) {
        this.seasons = data;
        notifyDataSetChanged();
    }

}
