package lv.javaguru.junit.workshop.section1;

import lv.javaguru.junit.workshop.section0.TaxBarrierProvider;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class TaxCalculationImpTest {
    private TaxBarrierProvider taxBarrierProvider;
    private TaxCalculator calculator;
    private EmailSender emailSender;

    @Before
    public void init() {
        emailSender = Mockito.mock(EmailSender.class);
        taxBarrierProvider = Mockito.mock(TaxBarrierProvider.class); //задавать поведение //Mock - зааглушка
        Mockito.when(taxBarrierProvider.getBarrier(2017))
                .thenReturn(20000.0);
        Mockito.when(taxBarrierProvider.getBarrier(2018))
                .thenReturn(20000.0);
        calculator = new TaxCalculationImp(taxBarrierProvider, emailSender);
    }

    @Test
    public void returnZeroIfIncomeZero() {
        assertEquals(calculator.calculateTax(2018, 0.0), 0.0, 0.001);
    }

    @Test
    public void returnZeroIf10000() {
        double tax = calculator.calculateTax(2017, 100000.0);
        assertEquals(tax, 37000.0, 0.001);
        Mockito.verify(emailSender).sendEmail(2017, 100000.0);
    }

    @Test
    public void returnZeroIf1000() {
        assertEquals(calculator.calculateTax(2017, 10000.0), 2500.0, 0.001);
    }

}