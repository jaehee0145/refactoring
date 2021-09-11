package chap1_refactoring;

public enum MovieCode {

    CHILDREN(1.5, 1, false),
    REGULAR(2, 1, false),
    NEW_RELEASE(3, 1, true);

    MovieCode(double price, int point, boolean bonusPoint) {
        this.price = price;
        this.point = point;
        this.bonusPoint = bonusPoint;
    }

    double price;
    int point;
    boolean bonusPoint;

    public int getPoint() {
        return point;
    }

    public double getPrice(int daysRented) {
        double thisAmount = 0;
        switch (this) {
            case REGULAR:
                thisAmount += this.price;
                if (daysRented > 2) {
                    thisAmount += (daysRented -2) * 1.5;
                }
                break;
            case NEW_RELEASE:
                thisAmount += daysRented * this.price;
                break;
            case CHILDREN:
                thisAmount += this.price;
                if (daysRented > 3) {
                    thisAmount += (daysRented - 3) * this.price;
                }
                break;
        }
        return thisAmount;
    }

    public int getBonusPoint(int daysRented) {
        int point = 0;
        switch (this) {
            case NEW_RELEASE:
                if (daysRented > 1) {
                point ++;
                break;
            }
        }
        return point;
    }
}
