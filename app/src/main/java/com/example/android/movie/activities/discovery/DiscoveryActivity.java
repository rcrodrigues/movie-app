package com.example.android.movie.activities.discovery;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.movie.MainActivity;
import com.example.android.movie.R;
import com.example.android.movie.activities.discovery.view.DiscoveryAdapter;
import com.example.android.movie.enums.DiscoveryFilterEnum;
import com.example.android.movie.utilities.MovieJsonUtils;
import com.example.android.movie.utilities.NetworkUtils;

import java.net.URL;
import java.util.concurrent.ExecutionException;

public class DiscoveryActivity extends AppCompatActivity implements DiscoveryContract.View {

    private static final String TAG = DiscoveryActivity.class.getCanonicalName();

    private DiscoveryContract.Presenter presenter;

    private RecyclerView mRecyclerView;
    private DiscoveryAdapter mDiscoveryAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discovery);

        // Instantiate an interactor for the Discovery Activity
        presenter = new DiscoveryPresenter(this);

        initComponents();
    }

    void initComponents() {

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL, false);
        mDiscoveryAdapter = new DiscoveryAdapter(this);

        mRecyclerView = findViewById(R.id.discovery_recycler_view);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(mDiscoveryAdapter);
        mRecyclerView.setHasFixedSize(true);

        presenter.discover(DiscoveryFilterEnum.POPULAR_MOVIES_PATH);
    }

    @Override
    public void showMovies(DiscoveryModel[] discoveryModels) {
        mDiscoveryAdapter.setDiscoveryModels(discoveryModels);
    }

}
