package es.adrianmarin.movies.presentation.presenter.movie;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.greenrobot.event.EventBus;
import es.adrianmarin.movies.commons.MovieDetailModelMapper;
import es.adrianmarin.movies.model.interactors.movie_detail.GetMovieDetail;
import es.adrianmarin.movies.presentation.presenter.models.BusinessMovieDetail;
import es.adrianmarin.movies.presentation.view.movie.MovieDetailView;
import es.adrianmarin.movies.presentation.view.movie.model.MovieDetailViewModel;

/**
 * @author Adrián Marín González
 * @since 25/10/15.
 */
@Singleton
public class MovieDetailPresenterImp implements MovieDetailPresenter {

    private Context mContext;
    private MovieDetailView mView;
    private GetMovieDetail mGetMovieDetail;

    @Inject
    public MovieDetailPresenterImp(Context context, GetMovieDetail getMovieDetail) {
        mContext = context;
        mGetMovieDetail = getMovieDetail;
    }

    @Override
    public void setView(MovieDetailView view){
        mView = view;
    }

    @Override
    public void onEvent(BusinessMovieDetail businessMovie) {
        EventBus.getDefault().unregister(this);
        MovieDetailViewModel viewModel = MovieDetailModelMapper.businessToViewMovie(businessMovie);
        mView.setMovieDetail(viewModel);
    }

    @Override
    public void getMovieDetail(Long id) {
        EventBus.getDefault().register(this);
        mGetMovieDetail.execute(id);
    }

    @Override
    public void subscribeEvents() {

    }

    @Override
    public void unSubscribeEvents() {

    }
}
