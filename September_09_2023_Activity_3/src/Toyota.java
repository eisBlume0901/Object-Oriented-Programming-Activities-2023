public class Toyota extends Car
{
    private String model;

    public Toyota(String model)
    {
        super(model);
    }

    // I wrote this
    @Override
    public void start()
    {
        System.out.println("Engine failed");
    }

    // I wrote this
    @Override
    public void engineSound()
    {
        System.out.println("Brrrrrr...");
    }
}