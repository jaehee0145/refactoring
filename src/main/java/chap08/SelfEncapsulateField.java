package chap08;

public class SelfEncapsulateField {

    class IntRange {
        private int low, high;

        boolean includes(int arg) {
            return arg >= low && arg <= high;
        }

        void grow(int factor) {
            high = high * factor;
        }

        public IntRange(int low, int high) {
            this.low = low;
            this.high = high;
        }
    }

    class IntRange2 {
        private int low, high;

        boolean includes(int arg) {
            return arg >= getLow() && arg <= getHigh();
        }

        void grow(int factor) {
            setHigh(getHigh() * factor);
        }

        public int getLow() {
            return low;
        }

        public void setLow(int low) {
            this.low = low;
        }

        public int getHigh() {
            return high;
        }

        public void setHigh(int high) {
            this.high = high;
        }

        public IntRange2(int low, int high) {
            initialize(low, high);
        }

        private void initialize(int low, int high) {
            this.low = low;
            this.high = high;
        }
    }

    class CappedRange extends IntRange2 {

        private int cap;

        public CappedRange(int low, int high, int cap) {
            super(low, high);
            this.cap = cap;
        }
    }

}
