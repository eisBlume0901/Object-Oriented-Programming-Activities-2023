package model.person;

import java.util.*;
import model.company.*;
import static java.lang.System.*;

public class Accountant extends Job {

    private List<String> invoices;
    private List<Double> expenses;

    public Accountant() {
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
    @Override
    public String toString() {
        return "Accountant";
    }
}
