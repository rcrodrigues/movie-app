package com.example.android.movie.utilities;

import android.content.Context;

import com.example.android.movie.data.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;

public final class MovieJsonUtils {

    private static final String TITLE = "title";
    private static final String POSTER_PATH = "poster_path";
    private static final String OVERVIEW = "overview";
    private static final String VOTE_AVARAGE  = "vote_average";
    private static final String RELEASE_DATE = "release_date";

    public static Movie[] getMovieDataFromJson(Context context, String movieJsonStr) throws JSONException {

        final String MOVIE_LIST = "results";

        JSONObject moviesJson = new JSONObject(movieJsonStr);

        JSONArray moviesArray = moviesJson.getJSONArray(MOVIE_LIST);

        Movie[] parsedMovieData = new Movie[moviesArray.length()];

        for (int i = 0; i < moviesArray.length(); i++) {

            JSONObject movieJsonObject = moviesArray.getJSONObject(i);

            Movie movie = new Movie();

            movie.setTitle(movieJsonObject.getString(TITLE));
            movie.setPosterPath(movieJsonObject.getString(POSTER_PATH));
            movie.setOverview(movieJsonObject.getString(OVERVIEW));
            movie.setVoteAverage(movieJsonObject.getDouble(VOTE_AVARAGE));
            movie.setReleaseDate(movieJsonObject.getString(RELEASE_DATE));

            parsedMovieData[i] = movie;
        }

        return parsedMovieData;
    }
}
