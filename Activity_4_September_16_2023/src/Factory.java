public interface Factory
{
    public void build();

    public void massProduce();

    default void start()
    {
        System.out.println("Starting factory");
    }

    default void end()
    {
        System.out.println("Ending factory");
    }
}
