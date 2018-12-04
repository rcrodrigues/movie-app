package com.example.android.movie.activities.discovery;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
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

    private static final String SELECTED_FILTER = "selected_filter";
    private static final String TITLE = "activity_title";

    private DiscoveryFilterEnum mDiscoveryFilter;
    private DiscoveryContract.Presenter presenter;
    private RecyclerView mRecyclerView;
    private DiscoveryAdapter mDiscoveryAdapter;
    private FrameLayout mLoadingIndicator;
    private SwipeRefreshLayout mSwipeContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discovery);

        // Instantiate an interactor for the Discovery Activity
        presenter = new DiscoveryPresenter(this);

        initComponents();

        this.setDiscoveryFilter(savedInstanceState);

        if(NetworkUtils.isOnline(this)) {
            presenter.discover(mDiscoveryFilter);
        }

        getWindow().setTitle(getString(R.string.action_discover_popular));
    }

    private void setDiscoveryFilter(@Nullable Bundle savedInstanceState) {

        if(savedInstanceState != null) {

            mDiscoveryFilter = (DiscoveryFilterEnum) savedInstanceState.get(SELECTED_FILTER);
            setTitle((String) savedInstanceState.get(TITLE));

        } else {

            mDiscoveryFilter = DiscoveryFilterEnum.POPULAR_MOVIES_PATH;
            setTitle(R.string.action_discover_popular);

        }
    }

    void initComponents() {

        mLoadingIndicator = findViewById(R.id.discovery_progress_bar);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL, false);
        mDiscoveryAdapter = new DiscoveryAdapter(this, this);

        mRecyclerView = findViewById(R.id.discovery_recycler_view);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(mDiscoveryAdapter);
        mRecyclerView.setHasFixedSize(true);

        mSwipeContainer = findViewById(R.id.swipeContainer);
        mSwipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.discover(mDiscoveryFilter);
            }
        });

        mSwipeContainer.setColorSchemeResources(R.color.colorAccent);
    }

    @Override
    public void showMovies(DiscoveryModel[] discoveryModels) {
        mDiscoveryAdapter.setDiscoveryModels(discoveryModels);
    }

    @Override
    public void showLoading() {
        if(mSwipeContainer.isRefreshing()) {
            return;
        }
        mLoadingIndicator.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mLoadingIndicator.setVisibility(View.GONE);
        if(mSwipeContainer.isRefreshing()) {
            mSwipeContainer.setRefreshing(false);
        }
        mRecyclerView.getLayoutManager().smoothScrollToPosition(mRecyclerView,null,0);
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
                mDiscoveryFilter = DiscoveryFilterEnum.POPULAR_MOVIES_PATH;
                setTitle(getString(R.string.action_discover_popular));
                presenter.discover(mDiscoveryFilter);
                return true;
            }

            if (id == R.id.discovery_top_rated) {
                mDiscoveryFilter = DiscoveryFilterEnum.TOP_RATED_MOVIES_PATH;
                setTitle(getString(R.string.action_discover_top_rated));
                presenter.discover(mDiscoveryFilter);
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(SELECTED_FILTER, mDiscoveryFilter);
        outState.putSerializable(TITLE, getTitle().toString());
        super.onSaveInstanceState(outState);
    }



}
