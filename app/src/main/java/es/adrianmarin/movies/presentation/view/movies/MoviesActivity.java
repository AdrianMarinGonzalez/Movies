package es.adrianmarin.movies.presentation.view.movies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import es.adrianmarin.movies.R;
import es.adrianmarin.movies.base.BaseActivity;
import es.adrianmarin.movies.dagger.ActivityModule;
import es.adrianmarin.movies.presentation.view.movie.MovieDetailFragment;
import es.adrianmarin.movies.presentation.view.movie.MovieDetailActivity;
import es.adrianmarin.movies.presentation.view.movies.models.MovieClickedEvent;
import es.adrianmarin.movies.utils.ScreenUtils;

/**
 * @author Adrián Marín González
 * @since 20/10/15.
 */
public class MoviesActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = LayoutInflater.from(this)
                                .inflate(R.layout.main_view, null);

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
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected List<Object> getModules() {
        List<Object> modules = new LinkedList<Object>();
        return modules;
    }


}
