package es.adrianmarin.movies.presentation.presenter.movie;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.greenrobot.event.EventBus;
import es.adrianmarin.movies.commons.MovieDetailModelMapper;
import es.adrianmarin.movies.domain.interactors.movie_detail.GetMovieDetail;
import es.adrianmarin.movies.presentation.presenter.NavigationHelper;
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
        MovieDetailViewModel viewModel = MovieDetailModelMapper.businessToViewMovie(businessMovie);
        mView.setMovieDetail(viewModel);
    }

    @Override
    public void getMovieDetail(Long id) {
        mGetMovieDetail.execute(id);
    }

    @Override
    public void subscribeEvents() {
        EventBus.getDefault().register(this);
        mGetMovieDetail.subscribeEvents();
    }

    @Override
    public void unSubscribeEvents() {
        EventBus.getDefault().unregister(this);
        mGetMovieDetail.unSubscriveEvents();
    }
}
