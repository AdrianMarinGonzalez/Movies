package es.adrianmarin.movies.commons;

import es.adrianmarin.movies.domain.model.movie_detail.MovieDetail;
import es.adrianmarin.movies.presentation.presenter.models.BusinessMovieDetail;
import es.adrianmarin.movies.presentation.view.movie.model.MovieDetailViewModel;

/**
 * @author Adrián Marín González
 * @since 21/10/15.
 */
public class MovieDetailModelMapper {

    public static MovieDetailViewModel businessToViewMovie(BusinessMovieDetail movieDetail){
        MovieDetailViewModel viewModel = new MovieDetailViewModel();

        viewModel.setBackdropPath(movieDetail.getBackdropPath());
        viewModel.setTitle(movieDetail.getTitle());
        viewModel.setTagline(movieDetail.getTagline());
        viewModel.setStatus(movieDetail.getStatus());
        viewModel.setReleaseDate(movieDetail.getReleaseDate());
        viewModel.setOverview(movieDetail.getOverview());
        viewModel.setHomepage(movieDetail.getHomepage());

        return viewModel;

    }

    public static BusinessMovieDetail modelToBusinessMovie(MovieDetail movieDetail){
        BusinessMovieDetail businessMovie = new BusinessMovieDetail();

        businessMovie.setBackdropPath(movieDetail.getBackdropPath());
        businessMovie.setTitle(movieDetail.getTitle());
        businessMovie.setTagline(movieDetail.getTagline());
        businessMovie.setStatus(movieDetail.getStatus());
        businessMovie.setReleaseDate(movieDetail.getReleaseDate());
        businessMovie.setOverview(movieDetail.getOverview());
        businessMovie.setHomepage(movieDetail.getHomepage());

        return businessMovie;
    }

}
