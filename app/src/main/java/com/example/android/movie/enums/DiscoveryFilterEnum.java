package com.example.android.movie.enums;

public enum DiscoveryFilterEnum {

    POPULAR_MOVIES_PATH("popular"),
    TOP_RATED_MOVIES_PATH("top_rated");

    private String text;

    DiscoveryFilterEnum(String s) {
        this.text = s;
    }
}
