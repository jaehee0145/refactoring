package chap09;

public class ReplaceTypeCodeWithClass_BloodGroup {

    public static final ReplaceTypeCodeWithClass_BloodGroup O = new ReplaceTypeCodeWithClass_BloodGroup(0);
    public static final ReplaceTypeCodeWithClass_BloodGroup A = new ReplaceTypeCodeWithClass_BloodGroup(1);
    public static final ReplaceTypeCodeWithClass_BloodGroup B = new ReplaceTypeCodeWithClass_BloodGroup(2);
    public static final ReplaceTypeCodeWithClass_BloodGroup AB = new ReplaceTypeCodeWithClass_BloodGroup(3);

    // 분류 부호 숫자가 든 인스턴스를 생성
    private static final ReplaceTypeCodeWithClass_BloodGroup[] values = {O, A, B, AB};

    private final int code;

    private ReplaceTypeCodeWithClass_BloodGroup(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ReplaceTypeCodeWithClass_BloodGroup code(int arg) {
        return values[arg];
    }
}

class Person {
//    public static final int O = 0;
    public static final int O = ReplaceTypeCodeWithClass_BloodGroup.O.getCode();
    public static final int A = ReplaceTypeCodeWithClass_BloodGroup.A.getCode();
    public static final int B = ReplaceTypeCodeWithClass_BloodGroup.B.getCode();
    public static final int AB = ReplaceTypeCodeWithClass_BloodGroup.AB.getCode();

    private ReplaceTypeCodeWithClass_BloodGroup bloodGroup;

    public Person(int bloodGroup) {
        this.bloodGroup = ReplaceTypeCodeWithClass_BloodGroup.code(bloodGroup);
    }

    public int getBloodGroupCode() {
        return bloodGroup.getCode();
    }

    public void setBloodGroup(int arg) {
        this.bloodGroup = ReplaceTypeCodeWithClass_BloodGroup.code(arg);
    }

    public ReplaceTypeCodeWithClass_BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public Person (ReplaceTypeCodeWithClass_BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setBloodGroup(ReplaceTypeCodeWithClass_BloodGroup arg) {
        bloodGroup = arg;
    }
}
