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
    private Accountant accountant;
    private SoftwareDeveloper softwareDev;
    private HumanResourcesManager humanResourceManager;
    public JobPreferenceController()
    {
        this.scanner = new Scanner(in);
        this.job = new Job();
        this.userInterface = new UserInterface();
        this.person = new Person();
        this.companyFactoryList = new ArrayList<>();
        this.accountant = new Accountant();
        this.softwareDev = new SoftwareDeveloper();
        this.humanResourceManager = new HumanResourcesManager();
    }


    public void start()
    {
        enterPersonalDetails();
        runJobPreferenceSystem();


        out.println("Which company you would like to apply? ");
        String preferredCompany = scanner.nextLine();
        JobLevel jobLevel = getJobLevelBeingApplied();
        findJobFromACompany(preferredCompany, person.getDesiredJob(), person.getEducationalLevel(), person.getCourseName());

        if (preferredCompany.matches(".*[aeiouAEIOU].*"))
        {
            start();
        }
        else
        {
            out.println(this.job.getJobType());
            this.job.generateSalaryRange(jobLevel);
            work();
        }
    }
    public void addAllCompanies()
    {
        CompanyFactory accenture = new Accenture();
        companyFactoryList.add(accenture);
        CompanyFactory canva = new Canva();
        companyFactoryList.add(canva);
        CompanyFactory citiBank = new Citibank();
        companyFactoryList.add(citiBank);
        CompanyFactory pbcom = new PBCOM();
        companyFactoryList.add(pbcom);
        CompanyFactory philAmLife = new PhilAmLife();
        companyFactoryList.add(philAmLife);
    }

    public void findCompaniesBasedOnJobType(String type) {

        out.println();
        out.println("List of Companies: ");
        for (CompanyFactory company : companyFactoryList) {
            company.offerJob(type);
            String result = company.isHiringJob(type);
            out.println(result);
        }
    }

    public void findJobFromACompany(String companyName,
                                    String jobName,
                                    EducationalLevel educationalLevel,
                                    String requirement)
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
                        out.println(jobName + " is available at " + company.getName());
                        if (job.getEducationalLevel().equals(educationalLevel)
                        && job.getRequirements().contains(requirement))
                        {
                            out.println("You match the job requirements offered by " + company.getName());
                            break;
                        }
                    }
                    else out.println(company.getName() + " does not have a job for " + jobName);
                }
            }
        }
    }


    public String getCourseName()
    {
        int userChoice = userInterface.validChoice(1, 8);
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
        int userChoice = userInterface.validChoice(1, 3);

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
        int userChoice = userInterface.validChoice(1, 3);

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

        int userChoice = userInterface.validChoice(1, 3);

        switch (userChoice)
        {
            case 1:
                findCompaniesBasedOnJobType("Accountant");
                person.setDesiredJob("Accountant");
                userInterface.displayAccountantJobResponsibilities();
                userInterface.displayAccountantJobRequirements();
                break;
            case 2:
                findCompaniesBasedOnJobType("Software Developer");
                person.setDesiredJob("Software Developer");
                userInterface.displaySoftwareDeveloperJobResponsibilities();
                userInterface.displaySoftwareDeveloperJobRequirements();
                break;
            case 3:
                findCompaniesBasedOnJobType("Human Resources Manager");
                person.setDesiredJob("Human Resources Manager");
                userInterface.displayHumanResourcesManagerJobResponsibilities();
                userInterface.displayHumanResourcesManagerRequirements();
                break;
            default:
                out.println("Invalid job type");
        }
    }

    public void work()
    {
        switch (person.getDesiredJob())
        {
            case "Accountant":
                accountantWork();
                break;
            case "Sofware Developer":
                softwareDevWork();
                break;
            case "Human Resource Manager":
                humanResourceManagerWork();
                break;
            default:
                out.println("Nothing to do");
        }
    }

    public void accountantWork()
    {

        accountant.addInvoice("Invoice #001");
        accountant.addInvoice("Invoice #002");

        accountant.recordExpense(1000.0);
        accountant.recordExpense(5000.0);

        accountant.printInvoiceList();
        accountant.printExpenseList();

        accountant.generateFinancialReport();
    }
    public void softwareDevWork(){
        softwareDev.addInvoice("01234");
        softwareDev.recordExpense(25000);

        softwareDev.printInvoiceList();
        softwareDev.printExpenseList();

        softwareDev.generateFinancialReport();
    }
    public void humanResourceManagerWork(){
        humanResourceManager.addInvoice("56789");
        humanResourceManager.recordExpense(18000);

        humanResourceManager.printInvoiceList();
        humanResourceManager.printExpenseList();

        humanResourceManager.generateFinancialReport();
    }
}
