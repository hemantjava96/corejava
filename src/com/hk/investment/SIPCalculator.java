package com.hk.investment;
import com.hk.investment.util.SIPCalculatorUtil;

import java.util.Scanner;

public class SIPCalculator {

    public static void main(String[] args) {
        // Creating a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user
        System.out.print("Enter the amount invested per month (in Rs): ");
        double monthlyInvestment = scanner.nextDouble();

        System.out.print("Enter the number of years: ");
        int numberOfYears = scanner.nextInt();
        int totalNumberOfMonths = numberOfYears * 12;

        System.out.print("Enter the annual interest rate (in percentage): ");
        double annualInterestRate = scanner.nextDouble();

        System.out.println("Choose option:");
        System.out.println("1. Calculate without monthly increment");
        System.out.println("2. Calculate with monthly increment");
        int option = scanner.nextInt();

        double annualIncreaseRate = 0;
        if (option == 2) {
            System.out.print("Enter the annual increase rate for monthly investment (in percentage): ");
            annualIncreaseRate = scanner.nextDouble();
        }

        System.out.print("Enter the inflation rate (in percentage): ");
        double inflationRate = scanner.nextDouble();

        // Closing the Scanner object to prevent resource leak
        scanner.close();

        // Calculating maturity amount using the chosen option
        double maturityAmount;
        switch (option) {
            case 1:
                maturityAmount = SIPCalculatorUtil.calculateMaturityAmount(monthlyInvestment, totalNumberOfMonths, annualInterestRate / 12 / 100, 0);
                break;
            case 2:
                maturityAmount = SIPCalculatorUtil.calculateMaturityAmountWithIncrement(monthlyInvestment, totalNumberOfMonths, annualInterestRate / 12 / 100, annualIncreaseRate);
                break;
            default:
                System.out.println("Invalid option. Please choose 1 or 2.");
                return;
        }

        // Calculating total investment amount
        double totalInvestment = monthlyInvestment * totalNumberOfMonths;

        // Calculating estimated return
        double estimatedReturn = maturityAmount - totalInvestment;

        // Calculating present value of maturity amount considering inflation
        double presentValue = SIPCalculatorUtil.calculatePresentValue(maturityAmount, inflationRate, numberOfYears);

        // Displaying the result
        System.out.println("Investment Amount: Rs " + totalInvestment);
        System.out.println("Estimated Return: Rs " + estimatedReturn);
        System.out.println("Maturity Amount: Rs " + maturityAmount);
        System.out.println("Present Value of Maturity Amount (Considering Inflation as "+inflationRate+"%): Rs " + presentValue);
    }
}
