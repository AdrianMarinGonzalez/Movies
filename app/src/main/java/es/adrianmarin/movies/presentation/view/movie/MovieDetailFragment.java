package es.adrianmarin.movies.presentation.view.movie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import es.adrianmarin.movies.R;
import es.adrianmarin.movies.base.BaseFragment;
import es.adrianmarin.movies.model.repository.api.APIGlobals;
import es.adrianmarin.movies.presentation.presenter.movie.MovieDetailPresenter;
import es.adrianmarin.movies.presentation.view.movie.model.MovieDetailViewModel;
import es.adrianmarin.movies.presentation.view.movies.models.MovieViewModel;
import es.adrianmarin.movies.utils.ImageUtils;

/**
 * @author Adrián Marín González
 * @since 20/10/15.
 */
public class MovieDetailFragment extends BaseFragment implements MovieDetailView{

    private static final String MOVIE_VIEW_MODEL_KEY = "MOVIE_VIEW_MODEL";
    @Bind(R.id.backdrop) ImageView mBackdrop;
    @Bind(R.id.title) TextView mTitle;
    @Bind(R.id.tagline) TextView mTagline;
    @Bind(R.id.release_date) TextView mReleaseDate;
    @Bind(R.id.overview) TextView mOverview;

    @Inject
    MovieDetailPresenter mPresenter;

    private Long mMovieId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.movie_detail_fragment, container, false);

        ButterKnife.bind(this, rootView);

        initView();

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.setView(this);
        mPresenter.subscribeEvents();
        mPresenter.getMovieDetail(mMovieId);
    }

    private void initView() {
        Bundle bundle = getArguments();

        MovieViewModel model = bundle.getParcelable(MOVIE_VIEW_MODEL_KEY);

        mMovieId = model.getId();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unSubscribeEvents();
    }

    public static MovieDetailFragment newInstance(MovieViewModel movieViewModel) {
        MovieDetailFragment movieDetailFragment = new MovieDetailFragment();

        Bundle bundle = new Bundle();
        bundle.putParcelable(MOVIE_VIEW_MODEL_KEY, movieViewModel);

        movieDetailFragment.setArguments(bundle);

        return movieDetailFragment;
    }

    @Override
    public void setMovieDetail(MovieDetailViewModel movieDetail) {

        ImageUtils.setImage(getActivity(),
                            APIGlobals.getMoviePosterURI(movieDetail.getBackdropPath()),
                            mBackdrop);
        mTitle.setText(movieDetail.getTitle());
        mTagline.setText(movieDetail.getTagline());
        mOverview.setText(movieDetail.getOverview());
        mReleaseDate.setText(movieDetail.getReleaseDate());

    }
}
