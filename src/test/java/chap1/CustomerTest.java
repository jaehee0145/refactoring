package chap1;

import org.junit.Test;

public class CustomerTest {

    @Test
    public void customer_정체를_보기위한_테스트() {
        Movie movie1 = new Movie("아이언맨1", Movie.CHILDREN);
        Movie movie2 = new Movie("아이언맨2", Movie.REGULAR);
        Movie movie3 = new Movie("아이언맨3", Movie.NEW_RELEASE);

        Rental rental1 = new Rental(movie1, 1);
        Rental rental2 = new Rental(movie2, 2);
        Rental rental3 = new Rental(movie3, 3);

        Customer customer = new Customer("jaehee");
        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);

        System.out.println(customer.statement());
        //jaehee 고객님의 대여 기록
        //	아이언맨1	1.5
        //	아이언맨2	2.0
        //	아이언맨3	9.0
        //누적 대여료: 12.5
        //적립 포인트: 4
    }

}