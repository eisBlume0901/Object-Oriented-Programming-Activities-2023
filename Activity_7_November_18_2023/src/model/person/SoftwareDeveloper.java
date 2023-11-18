package model.person;

import model.company.*;

import static java.lang.System.out;

public class SoftwareDeveloper implements SalaryGenerator
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
}