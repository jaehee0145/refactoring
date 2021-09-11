package chap1;

public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String _title;
    private int _priceCode;

    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    public String get_title() {
        return _title;
    }

    public int get_priceCode() {
        return _priceCode;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public void set_priceCode(int _priceCode) {
        this._priceCode = _priceCode;
    }

    double getCharge(int daysRented) {
        double result = 0;
        switch (get_priceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (daysRented > 2) {
                    result += (daysRented - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += daysRented * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (daysRented > 3) {
                    result += (daysRented - 3) * 1.5;
                }
                break;
        }
        return result;
    }
    int getFrequentRenterPoints(int daysRented) {
        // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
        if ((get_priceCode() == Movie.NEW_RELEASE) &&
                daysRented > 1) {
            return 2;
        }
        return 1;
    }
}
