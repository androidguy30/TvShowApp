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

        setSelectedItem(R.id.popular_item);
        navigationView.setNavigationItemSelectedListener(this);
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
        navigationView.setCheckedItem(item.getItemId());
        setSelectedItem(item.getItemId());
        return true;
    }

    public void setSelectedItem(int item) {
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
                    drawerLayout.openDrawer(GravityCompat.START);
                } else {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
