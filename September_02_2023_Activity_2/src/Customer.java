public class Customer
{
    private Name name;
    private Address address;
    private Card card;
    private GCash gcash;

    public Customer(Name name, Address address, Card card, GCash gcash)
    {
        this.name = name;
        this.address = address;
        this.card = card;
        this.gcash = gcash;
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Card getCard() {
        return card;
    }

    public GCash getGcash() {
        return gcash;
    }
}