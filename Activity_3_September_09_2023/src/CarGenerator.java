public class CarGenerator
{
    private Car car;

    public CarGenerator(Car car)
    {
        this.car = car;
    }

    public CarGenerator()
    {

    }

    public Car getInstance(String type)
    {
        switch (type)
        {
            case "Toyota":
                return new Toyota("Vios");
            case "BMW":
                return new BMW("E30");
            default:
                return new Car("Car");
        }
    }
}