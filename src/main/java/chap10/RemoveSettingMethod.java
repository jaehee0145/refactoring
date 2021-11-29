package chap10;

public class RemoveSettingMethod {

    class Account {
        private String id;
        Account (String id) {
            setId(id);
        }
        void setId(String arg) {
            id = arg;
        }
    }
    class Account2 {
        private String id;
        Account2 (String id) {
            this.id = id;
        }
    }
    class Account3 {
        private String id;
        Account3 (String id) {
            initializeId(id);
        }
        void initializeId (String arg) {
            id = "zz" + arg;
        }
    }
}
