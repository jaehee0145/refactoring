package chap11;

public class ExtractSubclass {
    class JobItem {
        private int unitPrice;
        private int quantity;
        private Employee employee;

        protected JobItem(int unitPrice, int quantity) {
            this.unitPrice = unitPrice;
            this.quantity = quantity;
        }

        public int getUnitPrice() {
            return unitPrice;
        }

        public int getQuantity() {
            return quantity;
        }

        public Employee getEmployee() {
            return employee;
        }

        protected boolean isLabor() {
            return false;
        }
    }

    class Employee {
        private int rate;

        public Employee(int rate) {
            this.rate = rate;
        }

        public int getRate() {
            return rate;
        }
    }

    class LaborItem extends JobItem {

        protected Employee employee;

        @Override
        protected boolean isLabor() {
            return true;
        }

        @Override
        public Employee getEmployee() {
            return employee;
        }

        public LaborItem(int quantity, Employee employee) {
            super(0, quantity);
            this.employee = employee;
        }
    }
}
