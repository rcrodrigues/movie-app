package com.example.android.movie.activities.discovery;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.android.movie.R;
import com.example.android.movie.activities.details.DetailActivity;
import com.example.android.movie.activities.discovery.entities.DiscoveryModel;
import com.example.android.movie.activities.discovery.view.DiscoveryAdapter;
import com.example.android.movie.activities.discovery.view.DiscoveryAdapterOnClickHandler;
import com.example.android.movie.enums.DiscoveryFilterEnum;
import com.example.android.movie.utilities.NetworkUtils;

import static com.example.android.movie.activities.details.DetailActivity.DISCOVERY_MODEL_DATA;

public class DiscoveryActivity extends AppCompatActivity implements DiscoveryContract.View, DiscoveryAdapterOnClickHandler {

    private DiscoveryContract.Presenter presenter;
    private RecyclerView mRecyclerView;
    private DiscoveryAdapter mDiscoveryAdapter;
    private ProgressBar mLoadingIndicator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discovery);

        // Instantiate an interactor for the Discovery Activity
        presenter = new DiscoveryPresenter(this);

        initComponents();

        if(NetworkUtils.isOnline(this)) {
            presenter.discover(DiscoveryFilterEnum.POPULAR_MOVIES_PATH);
        }

        getWindow().setTitle(getString(R.string.action_discover_popular));
    }

    void initComponents() {

        mLoadingIndicator = findViewById(R.id.discovery_progress_bar);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL, false);
        mDiscoveryAdapter = new DiscoveryAdapter(this, this);

        mRecyclerView = findViewById(R.id.discovery_recycler_view);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(mDiscoveryAdapter);
        mRecyclerView.setHasFixedSize(true);
    }

    @Override
    public void showMovies(DiscoveryModel[] discoveryModels) {
        mDiscoveryAdapter.setDiscoveryModels(discoveryModels);
    }

    @Override
    public void showLoading() {
        mLoadingIndicator.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mLoadingIndicator.setVisibility(View.GONE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* Use AppCompatActivity's method getMenuInflater to get a handle on the menu inflater */
        MenuInflater inflater = getMenuInflater();
        /* Use the inflater's inflate method to inflate our menu layout to this menu */
        inflater.inflate(R.menu.discovery_header_menu, menu);
        /* Return true so that the menu is displayed in the Toolbar */
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(NetworkUtils.isOnline(this)) {

            int id = item.getItemId();

            if (id == R.id.discovery_popular) {
                presenter.discover(DiscoveryFilterEnum.POPULAR_MOVIES_PATH);
                setTitle(getString(R.string.action_discover_popular));
                return true;
            }

            if (id == R.id.discovery_top_rated) {
                presenter.discover(DiscoveryFilterEnum.TOP_RATED_MOVIES_PATH);
                setTitle(getString(R.string.action_discover_top_rated));
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(DiscoveryModel discoveryModel) {

        Intent detalActivityIntent = new Intent(this,DetailActivity.class);
        detalActivityIntent.putExtra(DISCOVERY_MODEL_DATA,discoveryModel);
        startActivity(detalActivityIntent);

    }

}
