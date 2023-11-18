package view;

public interface Validator
{
    default int validChoice(int userChoice, int min, int max)
    {
        int validChoice;
        while (true)
        {
            try
            {
                if (userChoice >= min && userChoice <= max) {
                    validChoice = userChoice;
                    break;
                }
                else throw new Exception();
            }
            catch (Exception e)
            {
                System.out.println("Please enter a number from " + min + " to " + max + " only!");
            }
        }
        return validChoice;
    }
}
