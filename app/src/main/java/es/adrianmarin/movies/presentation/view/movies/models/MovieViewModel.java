package es.adrianmarin.movies.presentation.view.movies.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Adrián Marín González
 * @since 20/10/15.
 */
public class MovieViewModel implements Parcelable{

    private Long id;
    private String title;
    private String overview;
    private String release_date;
    private String original_language;
    private String poster_path;
    private String backdrop_path;
    private Long vote_count;
    private Float vote_average;
    private Float popularity;
    private boolean adult;

    public MovieViewModel() {}

    public MovieViewModel(Long id, String title, String overview, String release_date,
                          String original_language, String poster_path,
                          String backdrop_path, Long vote_count,
                          Float vote_average, Float popularity,
                          boolean adult) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.release_date = release_date;
        this.original_language = original_language;
        this.poster_path = poster_path;
        this.backdrop_path = backdrop_path;
        this.vote_count = vote_count;
        this.vote_average = vote_average;
        this.popularity = popularity;
        this.adult = adult;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public Long getVote_count() {
        return vote_count;
    }

    public void setVote_count(Long vote_count) {
        this.vote_count = vote_count;
    }

    public Float getVote_average() {
        return vote_average;
    }

    public void setVote_average(Float vote_average) {
        this.vote_average = vote_average;
    }

    public Float getPopularity() {
        return popularity;
    }

    public void setPopularity(Float popularity) {
        this.popularity = popularity;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    protected MovieViewModel(Parcel in) {
        id = in.readByte() == 0x00 ? null : in.readLong();
        title = in.readString();
        overview = in.readString();
        release_date = in.readString();
        original_language = in.readString();
        poster_path = in.readString();
        backdrop_path = in.readString();
        vote_count = in.readByte() == 0x00 ? null : in.readLong();
        vote_average = in.readByte() == 0x00 ? null : in.readFloat();
        popularity = in.readByte() == 0x00 ? null : in.readFloat();
        adult = in.readByte() != 0x00;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeLong(id);
        }
        dest.writeString(title);
        dest.writeString(overview);
        dest.writeString(release_date);
        dest.writeString(original_language);
        dest.writeString(poster_path);
        dest.writeString(backdrop_path);
        if (vote_count == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeLong(vote_count);
        }
        if (vote_average == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeFloat(vote_average);
        }
        if (popularity == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeFloat(popularity);
        }
        dest.writeByte((byte) (adult ? 0x01 : 0x00));
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<MovieViewModel> CREATOR = new Parcelable.Creator<MovieViewModel>() {
        @Override
        public MovieViewModel createFromParcel(Parcel in) {
            return new MovieViewModel(in);
        }

        @Override
        public MovieViewModel[] newArray(int size) {
            return new MovieViewModel[size];
        }
    };

}
