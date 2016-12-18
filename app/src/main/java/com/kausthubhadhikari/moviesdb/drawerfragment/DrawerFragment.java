package com.kausthubhadhikari.moviesdb.drawerfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.kausthubhadhikari.moviesdb.AppController;
import com.kausthubhadhikari.moviesdb.R;
import com.kausthubhadhikari.moviesdb.di.injector.Injector;
import com.kausthubhadhikari.moviesdb.model.pojo.common.Result;
import com.kausthubhadhikari.moviesdb.model.pojo.onair.OnAirPojo;
import com.kausthubhadhikari.moviesdb.model.pojo.popular.PopularPOJO;
import com.kausthubhadhikari.moviesdb.model.pojo.toprated.TVTopRated;
import com.kausthubhadhikari.moviesdb.showdetails.DetailActivity;
import com.kausthubhadhikari.moviesdb.utils.base.BaseFragment;
import com.kausthubhadhikari.moviesdb.utils.misc.AppConstants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DrawerFragment extends BaseFragment implements DrawerFragmentView {

    @Bind(R.id.baseRecyclerView)
    RecyclerView baseRecyclerView;

    @Inject
    DrawerFragmentPresenter presenter;

    @Inject
    MaterialDialog progressDialog;

    @Inject
    DefaultItemAnimator defaultItemAnimator;

    @Inject
    LinearLayoutManager linearLayoutManager;

    @Inject
    ItemDecorator decorator;

    private RecyclerViewAdapter recyclerViewAdapter;

    private String apiMethod;

    private int pageNumber = 1;

    private boolean isloading = false;

    private int visibleThreshold = 5;

    public static DrawerFragment newInstance(String apiMethod) {
        DrawerFragment fragment = new DrawerFragment();
        Bundle args = new Bundle();
        args.putString(AppConstants.ARGS_PARAM_API_METHOD, apiMethod);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            apiMethod = getArguments().getString(AppConstants.ARGS_PARAM_API_METHOD);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drawer_base, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void inject(Injector injector) {
        injector.inject(this);
    }

    @Override
    public DrawerFragmentPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void showHttpError() {

    }

    @Override
    public void setupView() {
        baseRecyclerView.setItemAnimator(defaultItemAnimator);
        baseRecyclerView.setLayoutManager(linearLayoutManager);
        baseRecyclerView.addItemDecoration(decorator);
        recyclerViewAdapter = new RecyclerViewAdapter(new ArrayList()) {
            @Override
            public void onBindData(ViewHolder holder, Object data) {
                Result popularPOJO = (Result) data;
                holder.showName.setText(popularPOJO.name);

                Picasso.with(getContext()).load(
                        ((AppController) getActivity().getApplicationContext()).getBaseURL() + AppConstants.BACKDROP_BASE_URL_HIGH + popularPOJO.backdropPath).into(holder.avatar);
                holder.desc.setText(popularPOJO.overview);
                holder.votes.setText(popularPOJO.voteCount + " Votes");
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity(), DetailActivity.class);
                        intent.putExtra(AppConstants.INTENT_KEY_SHOW_ID, popularPOJO.id);
                        Toast.makeText(getActivity(),""+popularPOJO.id,Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    }
                });
            }
        };

        baseRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int totalItemCount = recyclerView.getLayoutManager().getItemCount();
                int lastVisibleItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).
                        findLastVisibleItemPosition();


                boolean loadingCondition = (!isloading
                        && totalItemCount <= (lastVisibleItem + visibleThreshold));

                if (loadingCondition) {
                    if (!isloading) {
                        presenter.loadNextPage();
                    }
                    isloading = true;

                }

            }
        });
        baseRecyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public String getMethodName() {
        return apiMethod;
    }

    @Override
    public void deliverData(Object data) {
        if (apiMethod.equals("popular")) {
            PopularPOJO popularPOJO = (PopularPOJO) data;
            recyclerViewAdapter.updateData(popularPOJO.results);
        } else if (apiMethod.equals("top_rated")) {
            TVTopRated topRated = (TVTopRated) data;
            recyclerViewAdapter.updateData(topRated.results);
        } else if (apiMethod.equals("on_air")) {
            OnAirPojo onAirPojo = (OnAirPojo) data;
            recyclerViewAdapter.updateData(onAirPojo.results);
        }
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public int getPageNumber() {
        return pageNumber;
    }

    @Override
    public void deliverError(Throwable throwable) {
        Log.i("Error", "" + throwable.toString());
    }

    @Override
    public void endInfiniteLoading() {
        isloading = false;
    }


}
