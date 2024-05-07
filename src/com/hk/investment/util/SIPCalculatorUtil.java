package com.hk.investment.util;
public class SIPCalculatorUtil {

    public static double calculateMaturityAmount(double monthlyInvestment, int totalNumberOfMonths, double monthlyInterestRate, double annualIncreaseRate) {
        double maturityAmount = 0;

        for (int month = 1; month <= totalNumberOfMonths; month++) {
            // Adding interest to the maturity amount
            maturityAmount += monthlyInvestment;

            // Adding interest to the maturity amount
            maturityAmount += maturityAmount * monthlyInterestRate;
        }
        return maturityAmount;
    }

    public static double calculateMaturityAmountWithIncrement(double initialMonthlyInvestment, int totalNumberOfMonths, double monthlyInterestRate, double annualIncreaseRate) {
        double maturityAmount = 0;
        double monthlyInvestment = initialMonthlyInvestment;

        for (int month = 1; month <= totalNumberOfMonths; month++) {
            // Adding interest to the maturity amount
            maturityAmount += monthlyInvestment;

            // Increasing monthly investment by the annual increase rate at the end of each year
            if (month % 12 == 0 && month != totalNumberOfMonths) {
                monthlyInvestment *= (1 + annualIncreaseRate / 100);
            }

            // Adding interest to the maturity amount
            maturityAmount += maturityAmount * monthlyInterestRate;
        }
        return maturityAmount;
    }

    public static double calculatePresentValue(double maturityAmount, double inflationRate, int numberOfYears) {
        return maturityAmount / Math.pow(1 + inflationRate / 100, numberOfYears);
    }
}
