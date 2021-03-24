package ru.netology;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CreditCalculatorTest{

    private static int ROUNDING_MODE;

    @BeforeAll
    public static void before() {
        ROUNDING_MODE = CreditCalculator.ROUNDING_MODE;
    }
    @Test
    public void testMonthlyPayment() {
        BigDecimal expected = new BigDecimal(91.67).setScale(2, ROUNDING_MODE);
        assertThat(CreditCalculator.monthlyPayment(1000, 12, 0.1), is(equalTo(expected)));
    }

    @Test
    public void testTotalReturnedSum() {
        BigDecimal expected = new BigDecimal(1100).setScale(2, ROUNDING_MODE);
        assertThat(CreditCalculator.totalReturnedSum(1000, 0.1), is(equalTo(expected)));
    }

    @Test
    public void testTotalOverpayment() {
        BigDecimal expected = new BigDecimal(100).setScale(2, ROUNDING_MODE);
        assertThat(CreditCalculator.totalOverpayment(1000, 0.1), is(equalTo(expected)));
    }
}