import java.util.*;

import static java.lang.System.*;

public class Inventory
{
    private List<Item> inventoryList;

    public Inventory()
    {
        this.inventoryList = new ArrayList<>();
    }

    public void addItem(Item item)
    {
        this.inventoryList.add(item);
    }

    public void displayInventory()
    {
        out.println();
        List<Item> Items = new ArrayList<>();
        for (Item item : inventoryList)
        {
            Items.add(new Item(item.getItem(), item.getPrice()));
        }

        int maxItemNameLength = Items.stream()
                .mapToInt(item -> item.getItem().length())
                .max()
                .orElse(0);
        int maxItemPriceLength = Items.stream()
                .mapToInt(item -> String.valueOf(item.getPrice()).length())
                .max()
                .orElse(0);

        String format = "%-" + (maxItemNameLength + 15) + "s%-" + (maxItemPriceLength + 5) + "s%n";
        out.printf(format, "Item", "Price");
        out.println("".repeat(maxItemNameLength + maxItemPriceLength + 20));
        for (Item item : Items) {
            out.printf(format, item.getItem(), item.getPrice());
        }
    }

    public boolean itemExists(String itemName)
    {
        boolean exists = false;
        for (Item item : inventoryList)
            if (item.getItem().equalsIgnoreCase(itemName))
                exists = true;
        return exists;
    }

    public String retrieveItem(String itemName)
    {
        for (Item item : inventoryList)
            if (item.getItem().equalsIgnoreCase(itemName))
                return item.getItem() + "," + item.getPrice();
        return null;
    }
}