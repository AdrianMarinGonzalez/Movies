package es.adrianmarin.movies.presentation.presenter.movies.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Adrián Marín González
 * @since 21/10/15.
 */
public class BusinessMovie {

    private Long id;
    private Boolean adult;
    private List<Long> genre_ids = new ArrayList<Long>();
    private String originalTitle;
    private String backdropPath;
    private Float voteAverage;
    private Float popularity;
    private String posterPath;
    private String title;
    private String overview;
    private String originalLanguage;
    private Long voteCount;
    private String releaseDate;
    private Boolean video;

    public BusinessMovie() {
    }

    public BusinessMovie(Long id, Boolean adult, List<Long> genre_ids, String original_title,
                         String backdrop_path, Float vote_average, Float popularity, String poster_path,
                         String title, String overview, String original_language, Long vote_count,
                         String release_date, Boolean video) {
        this.id = id;
        this.adult = adult;
        this.genre_ids = genre_ids;
        this.originalTitle = original_title;
        this.backdropPath = backdrop_path;
        this.voteAverage = vote_average;
        this.popularity = popularity;
        this.posterPath = poster_path;
        this.title = title;
        this.overview = overview;
        this.originalLanguage = original_language;
        this.voteCount = vote_count;
        this.releaseDate = release_date;
        this.video = video;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public List<Long> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Long> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Float getPopularity() {
        return popularity;
    }

    public void setPopularity(Float popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public Long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Long voteCount) {
        this.voteCount = voteCount;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }
}