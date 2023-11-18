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

    public JobPreferenceController()
    {
        this.scanner = new Scanner(in);
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


    public void runJobPreferenceSystem()
    {
        addAllCompanies();
        // Integer.parseInt(scanner.nextLine())
        userInterface.displayJobType();

        int userChoice = userInterface.validChoice(1, 1, 3);

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


}
