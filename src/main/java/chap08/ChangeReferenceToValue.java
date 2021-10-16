package chap08;

public class ChangeReferenceToValue {

    class Currency {
        private String code;

        public String getCode() {
            return code;
        }
        private Currency (String code) {
            this.code = code;
        }
        // 참조 객체는 변경불가이므로 equals 메서드 정의
        public boolean equals(Object arg) {
            if (! (arg instanceof Currency)) return false;
            Currency other = (Currency) arg;
            return (code.equals(other.code));
        }
        // equals 정의할때 hashCode 메서드도 정의해야 한다
        public int hashCode() {
            return code.hashCode();
        }
    }

    class Test {
        // 참조 객체이므로 사용할 인스턴스를 가져오려면 다음과 같이 주어진 code에
        // Currency의 동일 인스턴스를 반환하는 메서드를 사용해야 한다. ??
//        Currency usd = Currency.get("USD");

        // Currency 클래스에는 여러 인스턴스가 들어있다.
        // 생성자만 사용하는 것은 불가능하다. 그래서 private인 것이다.??

//        new Currency("USD").equals(new Currency("USD")); // false 반환
    }
}
