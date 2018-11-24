package com.example.android.movie.activities.discovery;

import android.os.AsyncTask;
import com.example.android.movie.enums.DiscoveryFilterEnum;
import com.example.android.movie.utilities.MovieJsonUtils;
import com.example.android.movie.utilities.NetworkUtils;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class DiscoveryPresenter implements DiscoveryContract.Presenter{

    DiscoveryContract.View view;
    DiscoveryContract.Interactor interactor;

    public DiscoveryPresenter(DiscoveryContract.View view) {
        this.view = view;
        this.interactor = new DiscoveryInteractor();
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

                DiscoveryModel[] discoveryModel = MovieJsonUtils.getMovieDataFromJson(jsonMoviesResponse);

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
