package es.adrianmarin.movies.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * @author Adrián Marín González
 * @since 26/10/15.
 */
public abstract class BaseFragment extends Fragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MoviesApplication app = (MoviesApplication) getActivity().getApplicationContext();
        app.inject(this);
    }
}
