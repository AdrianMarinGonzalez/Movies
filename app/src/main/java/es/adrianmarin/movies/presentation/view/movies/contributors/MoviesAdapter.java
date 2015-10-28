package es.adrianmarin.movies.presentation.view.movies.contributors;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import es.adrianmarin.movies.R;
import es.adrianmarin.movies.domain.repository.api.APIGlobals;
import es.adrianmarin.movies.presentation.view.movies.models.MovieViewModel;
import es.adrianmarin.movies.utils.ImageUtils;

/**
 * @author Adrián Marín González
 * @since 20/10/15.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>{

    private Context mContext;

    private List<MovieViewModel> mData;
    private OnMovieClickListener mMovieClickListener;

    public MoviesAdapter(Context context, List<MovieViewModel> data, OnMovieClickListener movieClickListener){
        mContext = context;
        mData = data;
        mMovieClickListener = movieClickListener;
    }

    public MoviesAdapter(Context context, OnMovieClickListener movieClickListener) {
        mContext = context;
        mData = new ArrayList<>();
        mMovieClickListener = movieClickListener;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_moview_item, parent, false);

        MovieViewHolder viewHolder = new MovieViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
            holder.bindMovie(mData.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public MovieViewModel getItem(int position){
        return mData.get(position);
    }

    public void add(MovieViewModel movieViewItem){
        mData.add(movieViewItem);
        notifyDataSetChanged();
    }

    public void addAll(List<MovieViewModel> movieViewItems){
        mData.addAll(movieViewItems);
        notifyDataSetChanged();
    }

    public void clearData(){
        mData.clear();
        notifyDataSetChanged();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        View view;
        int position;
        MovieViewModel movie;

        @Bind(R.id.title) TextView title;
        @Bind(R.id.thumb) ImageView thumb;

        public MovieViewHolder(View movieItemView) {
            super(movieItemView);
            this.view = movieItemView;
            this.view.setOnClickListener(this);
            ButterKnife.bind(this, movieItemView);
        }

        public void bindMovie(MovieViewModel movie, int position){
            this.movie = movie;
            this.position = position;
            title.setText(movie.getTitle());
            ImageUtils.setImage(mContext,
                                APIGlobals.getMoviePosterURI(movie.getPoster_path()),
                                thumb);
        }

        @Override
        public void onClick(View v) {
            mMovieClickListener.onMovieClicked(view, position);
        }
    }

    public interface OnMovieClickListener{
        void onMovieClicked(View view, int position);
    }

}
