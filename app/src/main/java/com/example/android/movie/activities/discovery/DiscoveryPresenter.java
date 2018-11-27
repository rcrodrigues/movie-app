package com.example.android.movie.activities.discovery;

import android.net.Network;
import android.os.AsyncTask;

import com.example.android.movie.R;
import com.example.android.movie.activities.discovery.entities.DiscoveryModel;
import com.example.android.movie.enums.DiscoveryFilterEnum;
import com.example.android.movie.utilities.MovieJsonUtils;
import com.example.android.movie.utilities.NetworkUtils;
import java.net.URL;

public class DiscoveryPresenter implements DiscoveryContract.Presenter{

    DiscoveryContract.View view;

    public DiscoveryPresenter(DiscoveryContract.View view) {
        this.view = view;
    }

    @Override
    public void discover(DiscoveryFilterEnum filter) {

        URL endpoint = NetworkUtils.buildMoviesUrl(filter);
        new FetchMoviesTask().execute(endpoint);

    }

    private class FetchMoviesTask extends AsyncTask<URL, Void, DiscoveryModel[]> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            view.showLoading();
        }

        @Override
        protected DiscoveryModel[] doInBackground(URL... params) {

            if (params.length == 0) {
                return null;
            }

            URL moviesRequestUrl = params[0];

            try {

                String jsonMoviesResponse = NetworkUtils.getResponseFromHttpUrl(moviesRequestUrl);

                DiscoveryModel[] discoveryModel = MovieJsonUtils.getDiscoveryDataFromJson(jsonMoviesResponse);

                return discoveryModel;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(DiscoveryModel[] movies) {

            super.onPostExecute(movies);
            view.showMovies(movies);
            view.hideLoading();
        }
    }

}
