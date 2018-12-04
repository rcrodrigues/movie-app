package com.example.android.movie.activities.details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.android.movie.R;
import com.example.android.movie.activities.discovery.entities.DiscoveryModel;
import com.example.android.movie.enums.MoviePosterSizeEnum;
import com.example.android.movie.utilities.NetworkUtils;

import java.net.URL;

public class DetailActivity extends AppCompatActivity {

    public static final String DISCOVERY_MODEL_DATA = "DiscoveryModelData";
    private static final RequestOptions imageOptions = new RequestOptions().fitCenter();

    ImageView imPoster;
    TextView tvTitle;
    TextView tvRating;
    TextView tvReleaseDate;
    TextView tvOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setTitle(R.string.title_activity_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        initComponents();
        loadData();
    }

    private void initComponents() {

        imPoster = findViewById(R.id.detail_poster_image);
        tvTitle = findViewById(R.id.detail_title);
        tvRating = findViewById(R.id.detail_rating);
        tvReleaseDate = findViewById(R.id.detail_release_date);
        tvOverview = findViewById(R.id.detail_overview);

    }

    private void loadData() {

        Intent callerIntent = getIntent();

        if(callerIntent != null && callerIntent.hasExtra(DISCOVERY_MODEL_DATA)) {
            DiscoveryModel movie = (DiscoveryModel) callerIntent.getSerializableExtra(DISCOVERY_MODEL_DATA);

            URL posterUrl = NetworkUtils.buildMoviePosterUrl(movie.getPosterPath(), MoviePosterSizeEnum.W185);

            Glide.with(this)
                    .load(posterUrl.toString())
                    .apply(imageOptions)
                    .into(imPoster);


            tvTitle.setText(movie.getTitle());
            tvRating.setText(String.valueOf(movie.getVoteAverage()));
            tvReleaseDate.setText(movie.getReleaseDate());
            tvOverview.setText(movie.getOverview());
        }

    }




}
