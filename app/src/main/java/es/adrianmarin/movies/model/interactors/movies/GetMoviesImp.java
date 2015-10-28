package es.adrianmarin.movies.model.interactors.movies;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import es.adrianmarin.movies.commons.MovieModelMapper;
import es.adrianmarin.movies.model.model.movies.Movie;
import es.adrianmarin.movies.model.model.movies.MovieList;
import es.adrianmarin.movies.model.repository.MoviesRepository;
import es.adrianmarin.movies.presentation.presenter.movies.models.BusinessMovie;

/**
 * @author Adrián Marín González
 * @since 25/10/15.
 */
public class GetMoviesImp implements GetMovies {

    @Inject protected MoviesRepository repository;

    @Inject
    public GetMoviesImp(Context context, MoviesRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(int page){
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
        repository.getMovies(page);
    }

    @Override
    public void onEvent(MovieList movieList) {
        EventBus.getDefault().unregister(this);
        List<Movie> modelMovies = movieList.getMovies();
        List<BusinessMovie> businessMovies = MovieModelMapper.modelToBusinessMovie(modelMovies);
        EventBus.getDefault().post(businessMovies);
    }

}
