package controller;

import model.company.*;
import model.person.*;
import view.UserInterface;
import java.util.*;

import static java.lang.System.*;

public class JobPreferenceController
{
    private Scanner scanner;
    private Person person;
    private List<CompanyFactory> companyFactoryList;
    private UserInterface userInterface;

    private Job job;
    public JobPreferenceController()
    {
        this.scanner = new Scanner(in);
        this.job = new Job();
        this.userInterface = new UserInterface();
        this.person = new Person();
        this.companyFactoryList = new ArrayList<>();
    }


    public void addAllCompanies()
    {
        CompanyFactory accenture = new Accenture();
        companyFactoryList.add(accenture);
    }

    public void findCompaniesBasedOnJobType(String type) {

        for (CompanyFactory company : companyFactoryList) {
            company.offerJob(type);
            String result = company.isHiringJob(type);
            out.println(result);
        }
    }

    public void findJobFromACompany(String companyName, String jobName)
    {
        for (CompanyFactory company : companyFactoryList)
        {
            if (company.getName().equalsIgnoreCase(companyName))
            {
                List<Job> jobs = company.getJobHiringPositionList();

                for (Job job : jobs)
                {
                    if (job.toString().equalsIgnoreCase(jobName))
                    {
                        this.job = job;
                    }
                }
            }
        }
    }

    public String getCourseName()
    {
        int userChoice = userInterface.validChoice(Integer.parseInt(scanner.nextLine()), 1, 8);
        switch(userChoice)
        {
            case 1: return "Accountancy";
            case 2: return "Business and Management";
            case 3: return "Marketing Management";
            case 4: return "Finance Management";
            case 5: return "Computer Science";
            case 6: return "Information Technology";
            case 7: return "Computer Engineering";
            case 8: return "Psychology";
            default: return "Course Degree is not available";
        }
    }

    public EducationalLevel getEducationalLevel()
    {
        int userChoice = userInterface.validChoice(Integer.parseInt(scanner.nextLine()), 1, 3);

        switch (userChoice)
        {
            case 1: return EducationalLevel.BACHELOR;
            case 2: return EducationalLevel.MASTERAL;
            default: return EducationalLevel.DOCTORAL;
        }
    }

    public JobLevel getJobLevelBeingApplied()
    {
        userInterface.displayJobLevel();
        int userChoice = userInterface.validChoice(Integer.parseInt(scanner.nextLine()), 1, 3);

        switch (userChoice)
        {
            case 1:
                return JobLevel.ENTRY;
            case 2:
                return JobLevel.MID;
            default:
                return JobLevel.SENIOR;
        }
    }
    public void enterPersonalDetails()
    {
        userInterface.displayAskUserDetails();
        String applicant = scanner.nextLine();
        person.setName(applicant);

        userInterface.displayCourseNames();
        person.setCourseName(getCourseName());

        userInterface.displayEducationalLevel();
        person.setEducationalLevel(getEducationalLevel());

    }

    public void runJobPreferenceSystem()
    {
        addAllCompanies();
        userInterface.displayJobType();

        int userChoice = userInterface.validChoice(Integer.parseInt(scanner.nextLine()), 1, 3);

        switch (userChoice)
        {
            case 1:
                findCompaniesBasedOnJobType("Accountant");
                break;
            case 2:
                findCompaniesBasedOnJobType("Software Developer");
                break;
            case 3:
                findCompaniesBasedOnJobType("Human Resources Manager");
                break;
            default:
                out.println("Invalid job type");
        }
    }


    public void runJobLevelSystem()
    {
        out.println("What job? ");
        String jobType = scanner.nextLine();
        findJobFromACompany("Accenture", "Accountant");
        this.job = new Job.JobBuilder().setJobLevel(getJobLevelBeingApplied()).build();
        out.println(this.job.getJobLevel());

    }

}
