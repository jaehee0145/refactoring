package chap06;

public class ReplaceMethodWithMethodObject {
    class Account {
        int gamma (int inputVal, int quantity, int yearToDate) {
            int importantValue1 = (inputVal * quantity) + delta();
            int importantValue2 = (inputVal * yearToDate) + 100;
            if ((yearToDate - importantValue1) > 100) {
                importantValue2 -= 20;
            }
            int importantValue3 = importantValue2 * 7;
            // 기타 복잡한 작업
            return importantValue3 - 2 * importantValue1;
        }

        private int delta() {
            return 0;
        }
    }

    class Account2 {
        int gamma (int inputVal, int quantity, int yearToDate) {
            return new gamma(this, inputVal, quantity, yearToDate).compute();
        }

        private int delta() {
            return 0;
        }
    }

    class gamma {
        private final Account2 account2;
        private int inputVal;
        private int quantity;
        private int yearToDate;
        private int importantValue1;
        private int importantValue2;
        private int importantValue3;

        gamma(Account2 account2, int inputVal, int quantity, int yearToDate) {
            this.account2 = account2;
            this.inputVal = inputVal;
            this.quantity = quantity;
            this.yearToDate = yearToDate;
        }

        int compute() {
            importantValue1 = (inputVal * quantity) + account2.delta();
            importantValue2 = (inputVal * yearToDate) + 100;
            if ((yearToDate - importantValue1) > 100) {
                importantValue2 -= 20;
            }
            importantValue3 = importantValue2 * 7;
            // 기타 복잡한 작업
            return importantValue3 - 2 * importantValue1;
        }
    }
}
