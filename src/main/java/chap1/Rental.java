package chap1;

class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie _movie, int _daysRented) {
        this._movie = _movie;
        this._daysRented = _daysRented;
    }

    public Movie get_movie() {
        return _movie;
    }

    public int get_daysRented() {
        return _daysRented;
    }

    double getCharge() {
        double result = 0;
        switch (get_movie().get_priceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (get_daysRented() > 2) {
                    result += (get_daysRented() -2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += get_daysRented() * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (get_daysRented() > 3) {
                    result += (get_daysRented() - 3) * 1.5;
                }
                break;
        }
        return result;
    }
}
