package chap06;

import java.util.Enumeration;
import java.util.Vector;

public class ExtractMethod {

    private String _name;
    private Vector _orders = new Vector();

    void printOwing() {
        // 1. 지역변수 사용 안하는 메서드 추출
        printBanner();

        // 3. 지역변수를 다시 대입
        double outstanding = getOutStanding();

        // 2. 지역변수 사용 하는 메서드 추출 - 지역변수가 읽히기만 하고 변경되지 않을 때
        printDetails(outstanding);
    }

    private double getOutStanding() {
        Enumeration e = _orders.elements();
        double outstanding = 0.0;
        // 외상액 계산
        while (e.hasMoreElements()) {
            Order each = (Order) e.nextElement();
            outstanding += each.getAmount();
        }
        // 3-1. 반환값 이름 변경하기
        return outstanding;
    }

    private void printDetails(double outstanding) {
        // 세부 내역 출력
        System.out.println("고객명: " + _name);
        System.out.println("외상액: " + outstanding);
    }

    private void printBanner() {
        // 배너 출력
        System.out.println("*****");
        System.out.println("**고객 외상**");
        System.out.println("*****");
    }


    static class Order {
        double amount;

        public double getAmount() {
            return amount;
        }
    }
}


