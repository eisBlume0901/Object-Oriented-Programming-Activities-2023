package userinterface;

import java.util.*;
import domain.company.CompanyFactory;
import domain.person.Person;

import static java.lang.System.*;

public class UserInterface
{
    private Scanner scanner;
    private Person person;
    private List<CompanyFactory> companyFactoryList;
    public UserInterface(Scanner scanner)
    {
        this.scanner = scanner;
        this.person = new Person();
        this.companyFactoryList = new ArrayList<>();
    }

    public void chooseJobType()
    {
        out.println("What job are you hiring for? ");


    }


}
