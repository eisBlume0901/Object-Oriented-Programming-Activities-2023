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

    public void displayAccountantJobResponsibilities(){
        out.println("Responsibilities: Preparing and maintaining financial records, reports, and tax returns, \n" +
                "reconciling bank statements and ledgers, analyzing financial data and operations, offering guidance \n" +
                "on cost reduction, revenue enhancement, and profit maximization.");
    }

    public void displaySoftwareDeveloperJobResponsibilities(){

        out.println("Responsibilities: Designing algorithms and flowcharts, \n" +
                "producing clean, efficient code based on specifications, \n" +
                "integrating software components and third-party programs, \n" +
                "verifying and deploying programs and systems, troubleshooting, \n" +
                "debugging and upgrading existing software, gathering and evaluating user feedback.");
    }

    public void displayHumanResourcesManagerJobResponsibilities(){

        out.println("Responsibilities: Developing and implementing HR strategies \n" +
                "and initiatives aligned with the overall business strategy, managing \n" +
                "the recruitment and selection process, supporting current and future \n" +
                "business needs through the development, engagement, motivation and preservation \n" +
                "of human capital, nurturing a positive working environment, overseeing and managing \n" +
                "a performance appraisal system that drives high performance, ensuring legal compliance \n" +
                "throughout human resource management.");
    }

    public void displayAccountantJobRequirements()
    {
        out.println("Job Requirements:\n- " +
                "Able to use English as the working language\n- " +
                "Bachelor’s/College Degree or above in Accountancy/Banking/Finance\n- " +
                "3+ years working experience in Accountancy/Finance/Banking\n- " +
                "Able to make financial reports independently\n- " +
                "Advanced computer skills on MS Office, Accounting software and database");
    }

    public void displaySoftwareDeveloperJobRequirements()
    {
        out.println("Job Requirements:\n- " +
                "With Bachelor's Degree in Computer Science/Information Technology or equivalent" +
                "\n- Minimum of 3 years of experience as a software developer\n- " +
                "Have exposure in Tech Stack: C#, ASP.NET or (HTML, JavaScript, CSS) and MS SQL Server" +
                "\n- With ability to work in a fast-paced environment" +
                "\n- Willing to take a Software Developer Examination as part of the recruitment process");
    }

    public void displayHumanResourcesManagerRequirements()
    {
        out.println("Job Requirements:\n- " +
                "Strong MS Excel skills\n- " +
                "Excellent recruitment skills\n- " +
                "Strong work ethic and motivation\n- " +
                "5 years management experience\n- " +
                "Excellent planning and execution skills\n- " +
                "Performance management experience");
    }
}
