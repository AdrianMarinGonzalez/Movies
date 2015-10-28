package es.adrianmarin.movies.commons;

import java.util.ArrayList;
import java.util.List;

import es.adrianmarin.movies.domain.model.movies.Movie;
import es.adrianmarin.movies.presentation.presenter.movies.models.BusinessMovie;
import es.adrianmarin.movies.presentation.view.movies.models.MovieViewModel;

/**
 * @author Adrián Marín González
 * @since 21/10/15.
 */
public class MovieModelMapper {

    public static MovieViewModel businessToViewMovie(BusinessMovie model){
        MovieViewModel viewModel = new MovieViewModel();

        viewModel.setId(model.getId());
        viewModel.setAdult(model.getAdult());
        viewModel.setBackdrop_path(model.getBackdropPath());
        viewModel.setOriginal_language(model.getOriginalLanguage());
        viewModel.setOverview(model.getOverview());
        viewModel.setPopularity(model.getPopularity());
        viewModel.setPoster_path(model.getPosterPath());
        viewModel.setRelease_date(model.getReleaseDate());
        viewModel.setTitle(model.getTitle());
        viewModel.setVote_average(model.getVoteAverage());
        viewModel.setVote_count(model.getVoteCount());

        return viewModel;

    }

    public static List<MovieViewModel> businessToViewMovie(List<BusinessMovie> businessMovies){
        List<MovieViewModel> viewModels = new ArrayList<MovieViewModel>();

        for (int i=0 ; i<businessMovies.size() ; i++){
            viewModels.add(businessToViewMovie(businessMovies.get(i)));
        }

        return viewModels;

    }

    public static  BusinessMovie modelToBusinessMovie(Movie movie){
        BusinessMovie businessMovie = new BusinessMovie();

        businessMovie.setId(movie.getId());
        businessMovie.setAdult(movie.getAdult());
        businessMovie.setBackdropPath(movie.getBackdropPath());
        businessMovie.setOriginalLanguage(movie.getOriginalLanguage());
        businessMovie.setOverview(movie.getOverview());
        businessMovie.setPopularity(movie.getPopularity());
        businessMovie.setPosterPath(movie.getPosterPath());
        businessMovie.setReleaseDate(movie.getReleaseDate());
        businessMovie.setTitle(movie.getTitle());
        businessMovie.setVoteAverage(movie.getVoteAverage());
        businessMovie.setVoteCount(movie.getVoteCount());

        return businessMovie;
    }

    public static List<BusinessMovie> modelToBusinessMovie(List<Movie> models){
        List<BusinessMovie> businessMovies = new ArrayList<BusinessMovie>();

        for (int i=0 ; i<models.size() ; i++){
            businessMovies.add(modelToBusinessMovie(models.get(i)));
        }

        return businessMovies;

    }

}
