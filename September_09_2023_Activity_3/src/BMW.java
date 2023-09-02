public class BMW extends Car
{
    private String model;
    public BMW(String model)
    {
        super(model);
    }


    // I wrote this
    @Override
    public void start()
    {

    }

    private void checkEngineStatus()
    {
        System.out.println("checking engine");
    }

    private void checkFuelStatus()
    {
        System.out.println("checking fuel status");
    }

    @Override
    public void engineSound()
    {
        super.engineSound();
    }
}