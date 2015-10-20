package es.adrianmarin.movies.presentation.view.movies;

import android.os.Bundle;

import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;
import es.adrianmarin.movies.base.BaseActivity;
import es.adrianmarin.movies.dagger.MoviesModule;

/**
 * @author Adrián Marín González
 * @since 20/10/15.
 */
public class MoviesActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);

    }

    @Override
    protected List<Object> getModules() {
        List<Object> modules = new LinkedList<Object>();
        modules.add(new MoviesModule());
        return modules;
    }
}
