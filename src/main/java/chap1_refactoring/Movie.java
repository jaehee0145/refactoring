package chap1_refactoring;

public class Movie {
    private String _title;
    private MovieCode _movieCode;

    public Movie(String title, MovieCode movieCode) {
        _title = title;
        _movieCode = movieCode;
    }

    public String get_title() {
        return _title;
    }

    public MovieCode getMovieCode() {
        return _movieCode;
    }
}
