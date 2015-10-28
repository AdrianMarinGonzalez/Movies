package es.adrianmarin.movies.presentation.view.movies.models;

/**
 * @author Adrián Marín González
 * @since 21/10/15.
 */
public class MovieClickedEvent {

    private MovieViewModel movieViewModel;

    public MovieClickedEvent(MovieViewModel movieViewModel) {
        this.movieViewModel = movieViewModel;
    }

    public MovieViewModel getMovieViewModel() {
        return movieViewModel;
    }

}
