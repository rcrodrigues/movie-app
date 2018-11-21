package com.example.android.movie;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.android.movie.data.Movie;
import com.example.android.movie.utilities.MovieJsonUtils;
import com.example.android.movie.utilities.NetworkUtils;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getCanonicalName();
    private static Movie[] movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        URL popularMoviesRequestUrl = NetworkUtils.buildPopularMoviesUrl();

        new FetchMoviesTask().execute(popularMoviesRequestUrl);

    }

    public class FetchMoviesTask extends AsyncTask<URL, Void, Movie[]> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Movie[] doInBackground(URL... params) {

            /* If there's no zip code, there's nothing to look up. */
            if (params.length == 0) {
                return null;
            }

            URL weatherRequestUrl = params[0];

            try {

                String jsonMoviesResponse = NetworkUtils.getResponseFromHttpUrl(weatherRequestUrl);

                Movie[] movies = MovieJsonUtils.getMovieDataFromJson(MainActivity.this, jsonMoviesResponse);

                return movies;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Movie[] movies) {
            super.onPostExecute(movies);
            MainActivity.this.movies = movies;
            Log.i(TAG,movies.toString());
        }
    }


}
