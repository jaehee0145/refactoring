package chap07;

public class MoveMethod {

    class Account {
        private AccountType type;
        private int daysOverdrawn;

        double overdraftCharge() {
//            if (type.isPremium()) {
//                double result = 10;
//                if (daysOverdrawn > 7) result += (daysOverdrawn -7) * 0.85;
//                return result;
//            } else {
//                return daysOverdrawn * 1.75;
//            }
            return type.overdraftCharge(daysOverdrawn);
        }

        double bankCharge() {
            double result = 4.5;
            if (daysOverdrawn > 0) {
                result += overdraftCharge();
            }
            return result;
        }

    }

    private class AccountType {
        double overdraftCharge(int daysOverdrawn) {
            if (isPremium()) {
                double result = 10;
                if (daysOverdrawn > 7) result += (daysOverdrawn -7) * 0.85;
                return result;
            } else {
                return daysOverdrawn * 1.75;
            }
        }

        public boolean isPremium() {
            return false;
        }
    }
}
