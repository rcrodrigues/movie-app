package com.example.android.movie.activities.discovery;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.example.android.movie.MainActivity;
import com.example.android.movie.enums.DiscoveryFilterEnum;
import com.example.android.movie.utilities.MovieJsonUtils;
import com.example.android.movie.utilities.NetworkUtils;
import java.net.URL;

public class DiscoveryInteractor implements DiscoveryContract.Interactor {

    private static final String TAG = MainActivity.class.getCanonicalName();
    private DiscoveryModel[] discoveryModel;
    private Context context;

    public DiscoveryModel[] fetchMovies(DiscoveryFilterEnum movieFilter) {

        URL popularMoviesRequestUrl = NetworkUtils.buildMoviesUrl(movieFilter);
        new FetchMoviesTask().execute(popularMoviesRequestUrl);

        return discoveryModel;
    }

    @Override
    public String fetchText() {
        return "Helooo";
    }

    private class FetchMoviesTask extends AsyncTask<URL, Void, DiscoveryModel[]> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected DiscoveryModel[] doInBackground(URL... params) {

            if (params.length == 0) {
                return null;
            }

            URL moviesRequestUrl = params[0];

            try {

                String jsonMoviesResponse = NetworkUtils.getResponseFromHttpUrl(moviesRequestUrl);

                DiscoveryModel[] discoveryModel = MovieJsonUtils.getMovieDataFromJson(DiscoveryInteractor.this.context, jsonMoviesResponse);

                return discoveryModel;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(DiscoveryModel[] movies) {
            super.onPostExecute(movies);
            DiscoveryInteractor.this.discoveryModel = movies;
            Log.i(TAG,movies.toString());
        }
    }

}
