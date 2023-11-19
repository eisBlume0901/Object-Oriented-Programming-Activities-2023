package model.person;

import model.company.*;



import static java.lang.System.out;

public class HumanResourcesManager extends Job implements SalaryGenerator {
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
        return "HumanResourcesManager";
    }
}
