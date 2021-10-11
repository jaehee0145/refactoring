package chap07;

public class ExtractClass {
    public String getName() {
        return name;
    }

    public String getTelephoneNumber() {
        return officeTelephone.getTelephoneNumber();
    }

    TelephoneNumber getOfficeTelephone() {
        return officeTelephone;
    }

    private String name;
    private TelephoneNumber officeTelephone = new TelephoneNumber();

    class TelephoneNumber {
        public String getTelephoneNumber() {
            return ("(" + areaCode + ") " + number);
        }
        public String getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(String areaCode) {
            this.areaCode = areaCode;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        private String number;
        private String areaCode;
    }
}
