package es.adrianmarin.movies.presentation.view.movie.model;

/**
 * @author Adrián Marín González
 * @since 26/10/15.
 */
public class MovieDetailViewModel {

    private Long id;
    private String originalTitle;
    private String backdropPath;
    private String title;
    private String tagline;
    private String status;
    private String releaseDate;
    private String overview;
    private String homepage;

    public MovieDetailViewModel() {
    }

    public MovieDetailViewModel(Long id, String originalTitle, String backdropPath, String title, String tagline, String status, String releaseDate, String overview, String homepage) {
        this.id = id;
        this.originalTitle = originalTitle;
        this.backdropPath = backdropPath;
        this.title = title;
        this.tagline = tagline;
        this.status = status;
        this.releaseDate = releaseDate;
        this.overview = overview;
        this.homepage = homepage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

}
