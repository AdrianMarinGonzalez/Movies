package es.adrianmarin.movies.domain.interactors.movie_detail;

import android.content.Context;


import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import es.adrianmarin.movies.commons.MovieDetailModelMapper;
import es.adrianmarin.movies.domain.model.movie_detail.MovieDetail;
import es.adrianmarin.movies.domain.repository.MoviesRepository;
import es.adrianmarin.movies.presentation.presenter.models.BusinessMovieDetail;

/**
 * @author Adrián Marín González
 * @since 25/10/15.
 */
public class GetMovieDetailImp implements GetMovieDetail {

    @Inject protected MoviesRepository repository;

    @Inject
    public GetMovieDetailImp(Context context, MoviesRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Long id){
        repository.getMovieDetail(id);
    }

    @Override
    public void onEvent(MovieDetail movieDetail) {
        BusinessMovieDetail businessMovieDetail = MovieDetailModelMapper.modelToBusinessMovie(movieDetail);
        EventBus.getDefault().post(businessMovieDetail);
    }

    @Override
    public void subscribeEvents() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void unSubscriveEvents() {
        EventBus.getDefault().unregister(this);
    }

}
