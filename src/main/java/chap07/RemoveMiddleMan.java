package chap07;

public class RemoveMiddleMan {

    class Person {
        // department 호출 메서드 추가
        public Department getDepartment() {
            return department;
        }

        Department department;
        public Person getManager() {
//            return department.getManager();
            return getDepartment().getManager();
        }
    }

    class Department {
        // 불필요시 삭제
        public Person getManager() {
            return manager;
        }

        private Person manager;
        public Department (Person manager) {
            manager = manager;
        }
    }
}
