public class Car extends Vehicle
{
    private String name;

    public Car(String name)
    {
        super(name);
    }
    @Override
    public void engineSound()
    {
        System.out.println("Werrrrr");
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}