package es.adrianmarin.movies.model.model.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Adrián Marín González
 * @since 21/10/15.
 */
public class MovieList {

    @SerializedName("total_results")
    @Expose
    public Long totalResults;

    @SerializedName("page")
    @Expose
    public Long page;

    @SerializedName("total_pages")
    @Expose
    public Long totalPages;

    @SerializedName("results")
    @Expose
    public List<Movie> movies = new ArrayList<Movie>();

    public MovieList() {
    }

    public MovieList(Long totalResults, Long page, Long totalPages, List<Movie> movies) {
        this.totalResults = totalResults;
        this.page = page;
        this.totalPages = totalPages;
        this.movies = movies;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
