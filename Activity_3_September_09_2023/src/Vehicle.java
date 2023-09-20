public class Vehicle
{
    // I wrote this
    private String name;
    public Vehicle(String name)
    {
        this.name = name;
    }

    public void engineSound()
    {
        System.out.println("Vehicle making sound");
    }

    public void start()
    {
        System.out.println("Vehicle is starting");
    }
}