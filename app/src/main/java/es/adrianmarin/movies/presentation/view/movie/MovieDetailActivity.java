package es.adrianmarin.movies.presentation.view.movie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;
import es.adrianmarin.movies.R;
import es.adrianmarin.movies.base.BaseActivity;
import es.adrianmarin.movies.presentation.view.movies.models.MovieViewModel;

/**
 * @author Adrián Marín González
 * @since 20/10/15.
 */
public class MovieDetailActivity extends BaseActivity {

    public static final String MOVIE_VIEW_MODEL_KEY = "MOVIE_VIEW_MODEL";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = LayoutInflater.from(this)
                                .inflate(R.layout.movie_detail_activity, null);

        setContentView(view);
        ButterKnife.bind(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected List<Object> getModules() {
        List<Object> modules = new LinkedList<Object>();
        return modules;
    }


}
