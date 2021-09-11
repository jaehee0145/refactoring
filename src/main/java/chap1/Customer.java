package chap1;

import java.util.Enumeration;
import java.util.Vector;

class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String _name) {
        this._name = _name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = getName() + " 고객님의 대여 기록\n";
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            // 비디오 종류별 대여료 계산
            thisAmount = each.getCharge();

            // 적립 포인트를 1 포인트 증가
            frequentRenterPoints ++;
            // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
            if ((each.get_movie().get_priceCode() == Movie.NEW_RELEASE) &&
            each.get_daysRented() > 1) {
                frequentRenterPoints ++;

            }

            // 이번에 대여하는 비디오 정보와 대여료를 출력
            result += "\t" + each.get_movie().get_title() + "\t" + String.valueOf(thisAmount) + "\n";
            // 현재까지 누적된 총 대여료
            totalAmount += thisAmount;
        }
        // 푸터 행 추가
        result += "누적 대여료: " + String.valueOf(totalAmount) + "\n";
        result += "적립 포인트: " + String.valueOf(frequentRenterPoints);
        return result;
    }
}
