package chap06;

public class IntroduceExplainingVariable {
    private int quantity;
    private int itemPrice;

    double price() {
        // 결제액(price) = 총 구매액(base price) -
        // 대량 구매 할인(quantity discount) + 배송비(shipping)

        return quantity * itemPrice -
                Math.max(0, quantity - 500) * itemPrice * 0.05 +
                Math.min(quantity * itemPrice * 0.1, 100);
    }

    // 임시변수 사용
    double price2() {
        // 결제액(price) = 총 구매액(base price) -
        // 대량 구매 할인(quantity discount) + 배송비(shipping)

        final double basePrice = basePrice();
        final double quantityDiscount = Math.max(0, quantity - 500) * itemPrice * 0.05 ;
        final double shipping = Math.min(basePrice * 0.1, 100);
        return basePrice - quantityDiscount + shipping;
    }

    // 메서드 추출
    double price3() {
        return basePrice() - getQuantityDiscount() + getShipping();
    }

    private double getShipping() {
        return Math.min(basePrice() * 0.1, 100);
    }

    private double getQuantityDiscount() {
        return Math.max(0, quantity - 500) * itemPrice * 0.05;
    }

    private int basePrice() {
        return quantity * itemPrice;
    }




}
