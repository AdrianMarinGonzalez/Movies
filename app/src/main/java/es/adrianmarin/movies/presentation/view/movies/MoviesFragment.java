package es.adrianmarin.movies.presentation.view.movies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import es.adrianmarin.movies.R;
import es.adrianmarin.movies.base.BaseFragment;
import es.adrianmarin.movies.presentation.presenter.movies.MoviesPresenter;
import es.adrianmarin.movies.presentation.view.movies.contributors.MoviesAdapter;
import es.adrianmarin.movies.presentation.view.movies.contributors.ScrollEndRecyclerViewListener;
import es.adrianmarin.movies.presentation.view.movies.models.MovieClickedEvent;
import es.adrianmarin.movies.presentation.view.movies.models.MovieViewModel;


/**
 * @author Adrián Marín González
 * @since 20/10/15.
 */
public class MoviesFragment extends BaseFragment implements MoviesView,
                                                        MoviesAdapter.OnMovieClickListener,
                                                        SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.swipe_container) SwipeRefreshLayout mSwipeRefreshContainer;
    @Bind(R.id.movies_list) RecyclerView mMoviesList;
    @Bind(R.id.loading_more) ProgressBar mLoadingMoreProgress;

    private MoviesAdapter mMoviesAdapter;
    @Inject MoviesPresenter mPresenter;
    private LinearLayoutManager mLayoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMoviesAdapter = new MoviesAdapter(getActivity(), this);
        mLayoutManager = new LinearLayoutManager(getActivity());

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.movies_fragment, container, false);

        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListView();
        mPresenter.setView(this);
        mPresenter.subscribeEvents();
        mPresenter.getMovies(1);
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

    private void initListView(){
//        mMoviesList.scheduleLayoutAnimation();
        mMoviesList.setAdapter(mMoviesAdapter);
        mMoviesList.setLayoutManager(mLayoutManager);
        mMoviesList.setOnScrollListener(new ScrollEndRecyclerViewListener(mLayoutManager) {
            @Override
            public void onLoadMore(int current_page) {
                mPresenter.getMovies(current_page);
            }
        });
        mSwipeRefreshContainer.setOnRefreshListener(this);
    }

    @Override
    public void showLoading() {
        mSwipeRefreshContainer.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        mSwipeRefreshContainer.setRefreshing(false);
    }

    @Override
    public void add(MovieViewModel movieViewModel) {
        mMoviesAdapter.add(movieViewModel);
    }

    @Override
    public void addAll(List<MovieViewModel> movieViewModels) {
        mMoviesAdapter.addAll(movieViewModels);
    }

    @Override
    public void clear() {
        mMoviesAdapter.clearData();
        mMoviesList.setOnScrollListener(new ScrollEndRecyclerViewListener(mLayoutManager) {
            @Override
            public void onLoadMore(int current_page) {
                mPresenter.getMovies(current_page);
            }
        });
    }

    @Override
    public void onMovieClicked(View view, int position) {
//        mPresenter.presentMovieDetail(mMoviesAdapter.getItem(position));
        EventBus.getDefault().post(new MovieClickedEvent(mMoviesAdapter.getItem(position)));
    }

    @Override
    public void onRefresh() {
        mPresenter.getMovies(1);
    }
}
