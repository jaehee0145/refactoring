package chap10;

import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

public class ReplaceParameterWithMethod {

    class Entry {
        private Date chargeDate;
        private double value;

        public Entry(Date chargeDate, double value) {
            this.chargeDate = chargeDate;
            this.value = value;
        }

        public Date getDate() {
            return chargeDate;
        }
        public double getValue() {
            return value;
        }
    }

    class Account {
        double getFlowBetween (Date start, Date end) {
            Vector entries = new Vector();
            double result = 0;
            Enumeration e = entries.elements();
            while (e.hasMoreElements()) {
                Entry each = (Entry) e.nextElement();
                if (each.getDate().equals(start) || each.getDate().equals(end)
                        || (each.getDate().after(start) && each.getDate().before(end))) {
                    result += each.getValue();
                }
            }
            return result;
        }
    }

    class DateRange {
        private final Date start;
        private final Date end;

        public DateRange(Date start, Date end) {
            this.start = start;
            this.end = end;
        }
    }

}
