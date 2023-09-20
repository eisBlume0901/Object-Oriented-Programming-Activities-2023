import java.util.*;
import static java.lang.System.*;


public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(in);

        out.println("Welcome to Odette's Sari-sari store");
        out.println("Name");
        out.println("First name: ");
        Name name = new Name();
//        name.setFirstName(scanner.nextLine());
        name.setFirstName("Mary Claire");
        out.println(name.getFirstName());
        out.println("Middle name: ");
//        name.setMiddleName(scanner.nextLine());
        name.setMiddleName("Everett");
        out.println(name.getMiddleName());
        out.println("Last name: ");
//        name.setLastName(scanner.nextLine());
        name.setLastName("Ethereal");
        out.println(name.getLastName());

        out.println("\nAddress");
        out.println("Street: ");
        Address address = new Address();
//        address.setStreetNumber(scanner.nextLine());
        address.setStreetNumber("24th Avenue");
        out.println(address.getStreetNumber());
        out.println("Barangay: ");
//        address.setBarangay(scanner.nextLine());
        address.setBarangay("Milky Street");
        out.println(address.getBarangay());
        out.println("City: ");
//        address.setCity(scanner.nextLine());
        address.setCity("New Found City");
        out.println(address.getCity());

        out.println("\nCard");
        out.println("Credit Card Number (16 Digits): ");
        Card card = new Card();
//        card.setCreditCardNumber(scanner.nextLine());
        card.setCreditCardNumber("3782822463100056");
        out.println(card.getCreditCardNumber());
        out.println("CVV (3 digits): ");
//        card.setCvv(Integer.parseInt(scanner.nextLine()));
        card.setCvv(428);
        out.println(card.getCvv());
        out.println("Credit Card Expiry (Example: 07/2023): ");
//        card.setCreditCardExpiry(scanner.nextLine());
        card.setCreditCardExpiry("07/2023");
        out.println(card.getCreditCardExpiry());


        out.println("\nGCash");
        out.println("Mobile phone number (Example: 09123456789): ");
        GCash gCash = new GCash();
//        gCash.setNumber(scanner.nextLine());
        gCash.setNumber("09123456789");
        out.println(gCash.getNumber());
        out.println("Mpin (Example: 0901) ");
//        gCash.setMpin(Integer.parseInt(scanner.nextLine()));
        gCash.setMpin(1510);
        out.println(gCash.getMpin());

        Customer customer = new Customer(name, address, card, gCash);


        Item soap = new Item("Soap", 45);
        Item detergent = new Item("Detergent", 20);
        Item sponge = new Item("Sponge", 10);
        Item handTowels = new Item("Hand Towels", 50);
        Item rubberGloves = new Item("Rubber Gloves", 26);

        Inventory maryInventoryList = new Inventory();
        maryInventoryList.addItem(soap);
        maryInventoryList.addItem(sponge);
        maryInventoryList.addItem(detergent);
        maryInventoryList.addItem(handTowels);
        maryInventoryList.addItem(rubberGloves);

        maryInventoryList.displayInventory();

        out.println();
        out.println("Enter what items you want to buy");

        ShoppingCart shoppingCart = new ShoppingCart(customer);

        while (true)
        {
            String itemName = scanner.nextLine();

            if (itemName.isEmpty()) break;

            if (maryInventoryList.itemExists(itemName))
            {
                String itemFound = maryInventoryList.retrieveItem(itemName);
                String[] parts = itemFound.split(",");
                Item item = new Item(parts[0], Integer.parseInt(parts[1]));
                shoppingCart.addItem(item);

            }
            else
            {
                out.println(itemName + " does not exists!");;
            }
        }



        out.println("Payment Method: ");
        while (true)
        {
            out.println("""
                    [1] Credit Card
                    [2] GCash
                    [3] Exit
                    """);

            int paymentMethodChoice = Integer.parseInt(scanner.nextLine());

            if (paymentMethodChoice == 1)
            {
                String creditCardNumber = customer.getCard().getCreditCardNumber();
                String lastFourDigits = creditCardNumber.substring(creditCardNumber.length()  - 4, creditCardNumber.length());
                out.println("CCV last four digits: " + lastFourDigits);
                out.println("Credit Card Expiry: " + customer.getCard().getCreditCardExpiry());
            }
            else if (paymentMethodChoice == 2)
            {
                out.println("Please enter your MPIN: ");

                int mpin;
                do
                {
                    mpin = Integer.parseInt(scanner.nextLine());

                    if (mpin == customer.getGcash().getMpin())
                    {
                        out.println("GCash Number: " + customer.getGcash().getNumber());
                        out.println("Name: " + maskName(customer.getName().toString()));
                    }
                }
                while (mpin != customer.getGcash().getMpin());
            }
            else if (paymentMethodChoice == 3) break;
            else out.println("Invalid input. Please try again!");
        }

        shoppingCart.printReceipt();
    }

    public static String maskName(String name)
    {
        StringBuilder maskedName = new StringBuilder();
        for (int i = 0; i < name.length(); i++)
        {
            char c = name.charAt(i);
            if (i % 2 == 0)
                maskedName.append('*');
            else
                maskedName.append(c);
        }
        return maskedName.toString();
    }
}