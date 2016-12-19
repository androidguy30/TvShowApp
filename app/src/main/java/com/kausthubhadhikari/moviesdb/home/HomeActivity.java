package com.kausthubhadhikari.moviesdb.home;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.kausthubhadhikari.moviesdb.R;
import com.kausthubhadhikari.moviesdb.di.injector.Injector;
import com.kausthubhadhikari.moviesdb.drawerfragment.DrawerFragment;
import com.kausthubhadhikari.moviesdb.utils.base.BaseActivity;
import com.kausthubhadhikari.moviesdb.utils.misc.AppConstants;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements HomeView, NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.container)
    FrameLayout container;

    @Bind(R.id.drawerlayout)
    DrawerLayout drawerLayout;

    @Bind(R.id.navigationView)
    NavigationView navigationView;

    @Inject
    HomePresenter presenter;

    @Inject
    MaterialDialog progressDialog;

    public int itemSelected = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void inject(Injector injector) {
        injector.inject(this);
    }

    @Override
    public HomePresenter getPresenter() {
        return presenter;
    }


    @Override
    public void fetchError(int code) {

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
    public void setupViews() {
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);

        navigationView.setNavigationItemSelectedListener(this);
        if (itemSelected == 0) {
            setSelectedItem(R.id.popular_item);
        } else {
            setSelectedItem(itemSelected);
        }
    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void showHttpError() {

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        drawerLayout.closeDrawers();
        setSelectedItem(item.getItemId());
        return true;
    }

    public void setSelectedItem(int item) {
        navigationView.setCheckedItem(item);
        switch (item) {
            case R.id.popular_item: {
                DrawerFragment fragment = new DrawerFragment().newInstance("popular");
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragment).commit();
                break;
            }

            case R.id.top_rated_item: {
                DrawerFragment fragment = new DrawerFragment().newInstance("top_rated");
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragment).commit();

                break;
            }

            case R.id.on_air_item: {
                DrawerFragment fragment = new DrawerFragment().newInstance("on_air");
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragment).commit();

                break;
            }

            default: {
                DrawerFragment fragment = new DrawerFragment().newInstance("popular");
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragment).commit();
                break;
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        itemSelected = savedInstanceState.getInt(AppConstants.DRAWER_ITEM_SELECTED, 0);
        presenter.onRestoreState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(AppConstants.DRAWER_ITEM_SELECTED, itemSelected);
        presenter.onSaveState(outState);
    }

}
