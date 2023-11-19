package view;

import java.util.*;
import static java.lang.System.*;

public class UserInterface implements Validator
{
    public void displayAskUserDetails()
    {
        out.println("What is your name?");
    }
    public void displayJobType()
    {
        out.println("What job are you hiring for? ");
        out.println("""
                [1] Accountant
                [2] Software Developer
                [3] Human Resources Manager
                """);
    }

    public void displayJobLevel()
    {
        out.println("What job level are you aiming for? ");
        out.println("""
                [1] Entry
                [2] Mid
                [3] Senior
                """);
    }

    public void displayEducationalLevel()
    {
        out.println("What educational level you achieved? ");
        out.println("""
                [1] Bachelor
                [2] Masteral
                [3] Doctoral
                """);
    }


    public void displayCourseNames()
    {
        out.println("What is your course degree? ");
        out.println("""
                [1] Accountancy
                [2] Business and Management
                [3] Marketing Management
                [4] Finance Management
                [5] Computer Science
                [6] Information Technology
                [7] Computer Engineering
                [8] Psychology
                """);
    }

    public void displayAccountantJobResponsibilities()
    {
        out.println("Responsibilities");
    }

    public void displaySoftwareDeveloperJobResponsibilities()
    {
        out.println("Requirements");
    }

    public void displayHumanResourcesManagerJobResponsibilities()
    {
        out.println("Responsibilities");

    }

    public void displayAccountantJobRequirements()
    {
        out.println("Requirements");

    }

    public void displaySoftwareDeveloperJobRequirements()
    {
        out.println("Responsibilities");

    }

    public void displayHumanResourcesManagerRequirements()
    {
        out.println("Requirements");

    }
}
