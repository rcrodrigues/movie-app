package com.example.android.movie.activities.discovery;

public class DiscoveryModel {

    private String posterPath;
    private Boolean adult;
    private String overview;
    private String releaseDate;
    private Integer id;
    private String originalTitle;
    private String originalLanguage;
    private String title;
    private String backdropPath;
    private Double popularity;
    private Integer voteCount;
    private Boolean video;
    private Double voteAverage;

    public String getPosterPath() {
        return posterPath;
    }

    public DiscoveryModel setPosterPath(String posterPath) {
        this.posterPath = posterPath;
        return this;
    }

    public Boolean getAdult() {
        return adult;
    }

    public DiscoveryModel setAdult(Boolean adult) {
        this.adult = adult;
        return this;
    }

    public String getOverview() {
        return overview;
    }

    public DiscoveryModel setOverview(String overview) {
        this.overview = overview;
        return this;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public DiscoveryModel setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public DiscoveryModel setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public DiscoveryModel setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
        return this;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public DiscoveryModel setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public DiscoveryModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public DiscoveryModel setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
        return this;
    }

    public Double getPopularity() {
        return popularity;
    }

    public DiscoveryModel setPopularity(Double popularity) {
        this.popularity = popularity;
        return this;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public DiscoveryModel setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
        return this;
    }

    public Boolean getVideo() {
        return video;
    }

    public DiscoveryModel setVideo(Boolean video) {
        this.video = video;
        return this;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public DiscoveryModel setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
        return this;
    }
}