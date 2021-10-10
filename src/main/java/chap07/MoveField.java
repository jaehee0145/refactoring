package chap07;

public class MoveField {
    class Account {
        private AccountType type;

        double interestForAmountdays (double amount, int days) {
            return type.getInterestRate() * amount * days / 365;
        }
    }

    private class AccountType {
        private double interestRate;

        public double getInterestRate() {
            return interestRate;
        }

        public void setInterestRate(double interestRate) {
            this.interestRate = interestRate;
        }
    }
}
