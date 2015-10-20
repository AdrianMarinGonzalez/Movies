package es.adrianmarin.movies.presentation.view.movies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import es.adrianmarin.movies.R;

/**
 * @author Adrián Marín González
 * @since 20/10/15.
 */
public class MoviesFragment extends Fragment implements MoviesView {

    @Bind(R.id.movies_list) RecyclerView mMoviesList;
    @Bind(R.id.progress) ProgressBar mProgress;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.movies_list, container, false);

        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void showLoading() {
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgress.setVisibility(View.GONE);
    }
}
