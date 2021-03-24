package ru.netology;

import java.math.BigDecimal;

public class CreditCalculator {

    public final static int ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;

    public static BigDecimal monthlyPayment(int sum, int month, double percent) {
        BigDecimal totalSum = new BigDecimal(sum + (sum * percent));
        return totalSum.divide(new BigDecimal(month), 2, ROUNDING_MODE);
    }

    public static BigDecimal totalReturnedSum(int sum, double percent) {
        return new BigDecimal(sum + (sum * percent)).setScale(2, ROUNDING_MODE);
    }

    public static BigDecimal totalOverpayment(int sum, double percent) {
        BigDecimal totalSum = new BigDecimal(sum + (sum * percent));
        return totalSum.subtract(new BigDecimal(sum)).setScale(2, ROUNDING_MODE);
    }
}
