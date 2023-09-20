import java.util.*;

import static java.lang.System.*;

public class ShoppingCart
{
    private Customer customer;
    private List<Item> shoppingList;

    public ShoppingCart(Customer customer)
    {
        this.customer = customer;
        this.shoppingList = new ArrayList<>();
    }

    public void addItem(Item item)
    {
        shoppingList.add(item);
    }

    public double calculateTotal()
    {
        double total = 0;

        for (Item item : shoppingList)
            total += item.getPrice();

        return total;
    }

    public void printReceipt()
    {
        out.println();
        out.println("Name: " + customer.getName());
        out.println("Address: " + customer.getAddress() + "\n");

        // Convert the HashMap to a list of Item objects
        List<Item> Items = new ArrayList<>();
        for (Item item : shoppingList) {
            Items.add(new Item(item.getItem(), item.getPrice()));
        }

        // Calculate maximum lengths for formatting
        int maxItemNameLength = Items.stream()
                .mapToInt(item -> item.getItem().length())
                .max()
                .orElse(0);
        int maxItemPriceLength = Items.stream()
                .mapToInt(item -> String.valueOf(item.getPrice()).length())
                .max()
                .orElse(0);

        // Format and print the receipt
        String format = "%-" + (maxItemNameLength + 15) + "s%-" + (maxItemPriceLength + 5) + "s%n";
        out.printf(format, "Item", "Price");
        out.println("".repeat(maxItemNameLength + maxItemPriceLength + 20));
        for (Item item : Items) {
            out.printf(format, item.getItem(), item.getPrice());
        }

        out.printf(format, "Total: ", calculateTotal());
    }


}