package chap09;


import java.time.LocalDate;

public class DecomposeConditional {

    static final LocalDate SUMMER_START = LocalDate.of(2021, 7, 1);
    static final LocalDate SUMMER_END = LocalDate.of(2021, 10, 1);

    public Double calculateCharge(LocalDate date, Double quantity, Double winterRate, Double winterServiceCharge, Double summerRate) {
        Double charge;
        if (notSummer(date)) {
            charge = getWinterCharge(quantity, winterRate, winterServiceCharge);
        } else {
            charge = getSummerCharge(quantity, summerRate);
        }
        return charge;
    }

    private double getSummerCharge(Double quantity, Double summerRate) {
        return quantity * summerRate;
    }

    private double getWinterCharge(Double quantity, Double winterRate, Double winterServiceCharge) {
        return quantity * winterRate + winterServiceCharge;
    }

    private boolean notSummer(LocalDate date) {
        return date.isBefore(SUMMER_START) || date.isAfter(SUMMER_END);
    }
}
