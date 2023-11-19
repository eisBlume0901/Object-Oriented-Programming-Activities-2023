package view;

import java.util.Scanner;

public interface Validator
{
    default int validChoice(int min, int max)
    {
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        while (true)
        {
            try
            {
                userChoice = Integer.parseInt(scanner.nextLine());
                if (userChoice >= min && userChoice <= max) {
                    break;
                }
                else throw new Exception();
            }
            catch (Exception e)
            {
                System.out.println("Please enter a number from " + min + " to " + max + " only!");
            }
        }
        return userChoice;
    }
}
