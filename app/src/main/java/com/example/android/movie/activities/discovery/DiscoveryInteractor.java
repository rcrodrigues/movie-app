package com.example.android.movie.activities.discovery;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.example.android.movie.MainActivity;
import com.example.android.movie.enums.DiscoveryFilterEnum;
import com.example.android.movie.utilities.MovieJsonUtils;
import com.example.android.movie.utilities.NetworkUtils;
import java.net.URL;

public class DiscoveryInteractor implements DiscoveryContract.Interactor {


    public DiscoveryModel[] loadData(DiscoveryFilterEnum movieFilter, DiscoveryContract.View view) {

//        URL popularMoviesRequestUrl = NetworkUtils.buildMoviesUrl(movieFilter);
//        DiscoveryModel[] discoveryModels = view.getMovies(popularMoviesRequestUrl);
//
//        return discoveryModels;
        return null;
    }
}
