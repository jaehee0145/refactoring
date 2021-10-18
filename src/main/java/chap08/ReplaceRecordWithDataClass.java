package chap08;

public class ReplaceRecordWithDataClass {

    class person {
        public final int O = BloodGroup.O.getCode();
        public static final int A = 1;
        public static final int B = 2;
        public static final int AB = 3;

        private int bloodGroup;

        public person(int bloodGroup) {
            this.bloodGroup = bloodGroup;
        }

        public int getBloodGroup() {
            return bloodGroup;
        }

        public void setBloodGroup(int bloodGroup) {
            this.bloodGroup = bloodGroup;
        }
    }

    static class BloodGroup {
        public static final BloodGroup O = new BloodGroup(0);
        public static final BloodGroup A = new BloodGroup(1);
        public static final BloodGroup B = new BloodGroup(2);
        public static final BloodGroup AB = new BloodGroup(3);
        private static final BloodGroup[] values = {O, A, B, AB};

        private final int code;
        public BloodGroup(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public static BloodGroup code(int arg) {
            return values[arg];
        }
    }
}
