package com.h2;

import java.text.DecimalFormat;

public class MortgageCalculator {
    private long loanAmount;
    private int termInYears;
    private float annualRate;
    private double monthlyPayment;

    public MortgageCalculator(long loanAmount, int termInYears, float annualRate) {
        this.loanAmount = loanAmount;
        this.termInYears = termInYears;
        this.annualRate = annualRate;
    }

    private int getNumberOfPayments() {
        return 12 * termInYears;
    }

    private float getMonthlyInterestRate() {
        float interestRate = annualRate / 100;
        return interestRate / 12;
    }

    public void calculateMonthlyPayment() {
        long p = loanAmount;
        float r = getMonthlyInterestRate();
        int n = getNumberOfPayments();
        double M = p * (((r * Math.pow(1 + r, n))) / ((Math.pow((1 + r), n)) - 1));
        this.monthlyPayment = M;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("####0.00");
        return "monthlyPayment: " + df.format(monthlyPayment);
    }

    public static void main(String[] args) {
        long loanAmount = Utilities.getLongValue(args[0]);
        int termInYears = Utilities.getIntValue(args[1]);
        float annualRates = Utilities.getFloatValue(args[2]);

        MortgageCalculator calculator = new MortgageCalculator(loanAmount, termInYears, annualRates);
        calculator.calculateMonthlyPayment();
        System.out.println(calculator.toString());
    }
}