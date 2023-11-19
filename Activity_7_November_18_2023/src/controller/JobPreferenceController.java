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
        addAllCompanies();
        runJobPreferenceSystem();


        out.println("Which company you would like to apply? ");
        String preferredCompany = scanner.nextLine();
        JobLevel jobLevel = getJobLevelBeingApplied();

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
            this.job = company.offerJob(type);
            out.println(company.getName());
        }
        companyFactoryList.clear();
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
        userInterface.displayJobType();

        int userChoice = userInterface.validChoice(1, 3);

        String jobType = null;
        switch (userChoice)
        {
            case 1:
                jobType = "Accountant";
                person.setDesiredJob(jobType);
                userInterface.displayAccountantJobResponsibilities();
                userInterface.displayAccountantJobRequirements();
                break;
            case 2:
                jobType = "Software Developer";
                person.setDesiredJob(jobType);
                userInterface.displaySoftwareDeveloperJobResponsibilities();
                userInterface.displaySoftwareDeveloperJobRequirements();
                break;
            case 3:
                jobType = "Human Resources Manager";
                person.setDesiredJob(jobType);
                userInterface.displayHumanResourcesManagerJobResponsibilities();
                userInterface.displayHumanResourcesManagerRequirements();
                break;
            default:
                out.println("Invalid job type");
        }
        findCompaniesBasedOnJobType(jobType);

    }

    public void work()
    {
        switch (person.getDesiredJob())
        {
            case "Accountant":
                accountantWork();
                break;
            case "Software Developer":
                softwareDevWork();
                break;
            case "Human Resource Manager":
                humanResourceManagerWork();
                break;
            default:
                out.println("Nothing to do");
                break;
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
