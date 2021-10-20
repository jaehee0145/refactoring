package chap09;

public class ReplaceConditionalWithPolymorphism {
    class Employee {
        public static final int ENGINEER = 0;
        public static final int SALESMAN = 1;
        private EmployeeType type;
        private int monthlySalary;
        private int commission;

        public int getType() {
            return type.getTypeCode();
        }

        int payAmount(Employee emp) {
            return type.payAmount(this);
        }

        public int getMonthlySalary() {
            return 0;
        }
    }

    abstract class EmployeeType {

        abstract int getTypeCode();
        abstract int payAmount(Employee employee);
    }

    class Engineer extends EmployeeType {

        @Override
        int getTypeCode() {
            return Employee.ENGINEER;
        }

        @Override
        int payAmount(Employee employee) {
            return employee.getMonthlySalary();
        }
    }
}
