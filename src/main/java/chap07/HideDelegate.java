package chap07;

public class HideDelegate {

    class Person{
        Department department;

//          삭제
//        public Department getDepartment() {
//            return department;
//        }

        public void setDepartment(Department department) {
            this.department = department;
        }

        // 추가
        public Person getManager() {
            return department.getManager();
        }
    }

    private class Department {
        private String chargeCode;
        private Person manager;

        public Department (Person manager) {
            manager = manager;
        }

        public Person getManager() {
            return manager;
        }
    }
}
