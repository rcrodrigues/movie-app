package com.example.android.movie.enums;

import java.io.Serializable;

public enum DiscoveryFilterEnum implements Serializable {

    POPULAR_MOVIES_PATH("popular"),
    TOP_RATED_MOVIES_PATH("top_rated");

    private String text;

    DiscoveryFilterEnum(String s) {
        this.text = s;
    }

    public String getText() {
        return this.text;
    }
}
