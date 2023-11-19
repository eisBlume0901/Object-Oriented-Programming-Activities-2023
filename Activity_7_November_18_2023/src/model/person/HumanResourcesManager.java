package model.person;

import model.company.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class HumanResourcesManager extends Job implements SalaryGenerator {
    private List<String> invoices;
    private List<Double> expenses;
    public HumanResourcesManager(){
        this.invoices = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }
    public void addInvoice(String invoiceNumber) {
        invoices.add(invoiceNumber);
        System.out.println("Invoice added: " + invoiceNumber);
    }

    public void recordExpense(double amount) {
        expenses.add(amount);
        System.out.println("Expense recorded: Php" + amount);
    }

    public double calculateTotalExpenses() {
        double totalExpenses = expenses.stream().mapToDouble(Double::doubleValue).sum();
        System.out.println("Total expenses: Php" + totalExpenses);
        return totalExpenses;
    }

    public void printInvoiceList() {
        System.out.println("List of Invoices:");
        for (String invoice : invoices) {
            System.out.println(invoice);
        }
    }

    public void printExpenseList() {
        System.out.println("List of Expenses:");
        for (Double expense : expenses) {
            System.out.println("Php" + expense);
        }
    }

    public void generateFinancialReport() {
        double totalExpenses = calculateTotalExpenses();
        double netIncome = calculateNetIncome(totalExpenses);
        System.out.println("Financial Report:");
        System.out.println("Net Income: Php" + netIncome);
    }

    private double calculateNetIncome(double totalExpenses) {
        // Assume total revenue is Php5000 (you can replace this with your actual revenue calculation)
        double totalRevenue = 100_000.0;
        return totalRevenue - totalExpenses;
    }
    @Override
    public void generateSalaryRange(JobLevel jobLevel) {

        switch (jobLevel)
        {
            case ENTRY -> out.println("Php 15,000 - Php 25,000");
            case MID -> out.println("Php 25,000 - Php 40,000");
            default -> out.println("Php 40,000 - above");
        }
    }
    public void calculateTax(double salary){
        double tax = salary * 0.12;
        out.println(" The tax for this salary is: " + tax);
    }
    public void calculateNetSalary(double salary){
        double tax = salary * 0.12;
        double netSalary = salary - tax;
        out.println("Bonus: " + netSalary);
    }
    public void calculateBonus(double salary){
        double bonus = salary * 0.05;
        out.println("Bonus: " + bonus);
    }
    public void calculateTotalCompensation(double salary){
        double tax = salary * 0.12;
        double bonus = salary * 0.05;
        double totalCompensation = salary - tax + bonus;
        out.println("The total compensation is: " + totalCompensation);
    }
    public void printSalarySlip(double salary){
        calculateTax(salary);
        calculateNetSalary(salary);
        calculateBonus(salary);
        calculateTotalCompensation(salary);
    }
    public void printJobDescription(){
        //Highly suggest that Requirements and Responsibility are to be called here
        HumanResourcesManager hrm = new HumanResourcesManager();
        hrm.getResponsibilities();
        hrm.getRequirements();
    }

    @Override
    public String toString() {
        return "HumanResourcesManager{" +
                "invoices=" + invoices +
                ", expenses=" + expenses +
                '}';
    }
}
