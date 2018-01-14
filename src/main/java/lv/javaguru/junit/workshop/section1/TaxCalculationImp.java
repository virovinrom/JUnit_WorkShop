package lv.javaguru.junit.workshop.section1;

import lv.javaguru.junit.workshop.section0.TaxBarrierProvider;

public class TaxCalculationImp implements TaxCalculator {
    private EmailSender emailSender;
    private TaxBarrierProvider taxBarrierProvider;

    public TaxCalculationImp(TaxBarrierProvider taxBarrierProvider, EmailSender emailSender) {
        this.taxBarrierProvider = taxBarrierProvider;
        this.emailSender = emailSender;
    }

    @Override
    public double calculateTax(int year, double income) {
        double taxBarrier = taxBarrierProvider.getBarrier(year);
        if ((0 < income) && income <= taxBarrier) {
            return income * 0.25;
        } else if (income > taxBarrier) {
            emailSender.sendEmail(year, income);
            return taxBarrier * 0.25 + (income - taxBarrier) * 0.40;
        }
        return 0.0;
    }

}
