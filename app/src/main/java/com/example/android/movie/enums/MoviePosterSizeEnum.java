package com.example.android.movie.enums;

public enum MoviePosterSizeEnum {

    W92("w92"),
    W154("w154"),
    W185("w185"),
    W342("w342"),
    W500("w500"),
    W780("w780"),
    ORIGINAL("original");

    private String text;

    MoviePosterSizeEnum(String s) {
        this.text = s;
    }

    public String getText() {
        return text;
    }

}
