package chap10;

public class ReplaceConstructorWithFactoryMethod {

    class Employee {
        private int type;
        static final int ENGINEER = 0;
        static final int SALESMAN = 1;
        static final int MANAGER = 2;

        Employee (int type) {
            this.type = type;
        }
    }

    static class Employee2 {
        private int type;
        static final int ENGINEER = 0;
        static final int SALESMAN = 1;
        static final int MANAGER = 2;

        Employee2 (int type) {
            this.type = type;
        }

        static Employee2 create(int type) {
            return new Employee2(type);
        }
    }

    public static void main(String[] args) {
        Employee2 em = Employee2.create(Employee2.ENGINEER);
    }
}
