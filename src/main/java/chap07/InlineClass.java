package chap07;

public class InlineClass {
    class Person {
        private String name;
        private String number;
        private String areaCode;

        public String getName() {
            return name;
        }

        public String getTelephoneNumber() {
            return ("(" + areaCode + ")" + number);
        }

        String getAreaCode() {
            return areaCode;
        }

        void setAreaCode(String arg) {
            areaCode = arg;
        }
        String getNumber() {
            return number;
        }
        void setNumber(String arg) {
            number = arg;
        }

    }

    class TelephoneNumber {

    }
}
