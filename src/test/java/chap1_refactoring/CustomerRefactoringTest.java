package chap1_refactoring;

import org.junit.Test;

public class CustomerRefactoringTest {

    @Test
    public void 혼자_리팩토링_테스트() {
        Movie movie1 = new Movie("아이언맨1", MovieCode.CHILDREN);
        Movie movie2 = new Movie("아이언맨2", MovieCode.REGULAR);
        Movie movie3 = new Movie("아이언맨3", MovieCode.NEW_RELEASE);

        Rental rental1 = new Rental(movie1, 1);
        Rental rental2 = new Rental(movie2, 3);
        Rental rental3 = new Rental(movie3, 5);

        Customer customer = new Customer("jaehee");
        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);

        System.out.println(customer.statement());
        //jaehee 고객님의 대여 기록
        //	아이언맨1	1.5
        //	아이언맨2	3.5
        //	아이언맨3	15.0
        //누적 대여료: 20.0
        //적립 포인트: 4

    }
}
