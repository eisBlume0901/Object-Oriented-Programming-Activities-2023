package model.person;

import model.company.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class SoftwareDeveloper extends Job implements SalaryGenerator
{
    @Override
    public void generateSalaryRange(JobLevel jobLevel) {

        switch (jobLevel)
        {
            case ENTRY -> out.println("Php 15,000 - Php 25,000");
            case MID -> out.println("Php 25,000 - Php 40,000");
            default -> out.println("Php 40,000 - above");
        }
    }
    public void addProject(String projectName){
        out.println("Added project: " + projectName);
    }
    public void completedProject(String projectName){
        out.println("Completed project: " + projectName);
    }
    public void calculatedHoursWorked(int hours){
        out.println("Hours worked: " + hours);
    }
    public void calculateOvertime(int hours){
        if(hours > 40){
            int overtime = hours - 40;
            out.println("Overtime hrs: " + overtime);
        }
        else out.println("No overtime hours");
    }
    public void printTimeSheet(int hours){
        calculatedHoursWorked(hours);
        calculateOvertime(hours);
    }
    public void jobDescription(){
        SoftwareDeveloper softDev = new SoftwareDeveloper();
        softDev.getResponsibilities();
        softDev.getRequirements();
    }

    @Override
    public String toString() {
        return "SoftwareDeveloper";
    }
}
