package chap06;

public class ReplaceTempWithQuery {

    private int quantity;
    private int itemPrice;

    double getPrice() {
        return getBasePrice() * getDiscountFactor();
    }

    private int getBasePrice() {
        return quantity * itemPrice;
    }

    private double getDiscountFactor() {
        if (getBasePrice() > 1000) {
            return 0.95;
        } else {
            return 0.98;
        }
    }
}
