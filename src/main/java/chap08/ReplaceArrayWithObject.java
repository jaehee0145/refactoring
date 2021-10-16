package chap08;

public class ReplaceArrayWithObject {

    public static void main(String[] args) {

        String[] row = new String[3];
        row[0] ="Liverpool";
        row[1] ="15";

        String name = row[0];
        int wins = Integer.parseInt(row[1]);
    }

    static class Performance {
        private String[] data = new String[3];
        private String name;

        public String getName() {
            return name;
        }
        public void setName(String arg) {
            name = arg;
        }
        public String getWins() {
            return data[1];
        }
        public void setWins(String arg) {
            data[1] = arg;
        }
    }

    public static void main2(String[] args) {

        Performance row = new Performance();
        row.setName("Liverpool");
        row.setWins("15");

        String name = row.getName();
        int wins = Integer.parseInt(row.getWins());
    }
}
