package com.example.android.movie.data;

public class Movie {

    private Object posterPath;
    private Boolean adult;
    private String overview;
    private String releaseDate;
    private Integer id;
    private String originalTitle;
    private String originalLanguage;
    private String title;
    private Object backdropPath;
    private Double popularity;
    private Integer voteCount;
    private Boolean video;
    private Double voteAverage;

    public Object getPosterPath() {
        return posterPath;
    }

    public Movie setPosterPath(Object posterPath) {
        this.posterPath = posterPath;
        return this;
    }

    public Boolean getAdult() {
        return adult;
    }

    public Movie setAdult(Boolean adult) {
        this.adult = adult;
        return this;
    }

    public String getOverview() {
        return overview;
    }

    public Movie setOverview(String overview) {
        this.overview = overview;
        return this;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public Movie setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Movie setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public Movie setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
        return this;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public Movie setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Movie setTitle(String title) {
        this.title = title;
        return this;
    }

    public Object getBackdropPath() {
        return backdropPath;
    }

    public Movie setBackdropPath(Object backdropPath) {
        this.backdropPath = backdropPath;
        return this;
    }

    public Double getPopularity() {
        return popularity;
    }

    public Movie setPopularity(Double popularity) {
        this.popularity = popularity;
        return this;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public Movie setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
        return this;
    }

    public Boolean getVideo() {
        return video;
    }

    public Movie setVideo(Boolean video) {
        this.video = video;
        return this;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public Movie setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
        return this;
    }
}