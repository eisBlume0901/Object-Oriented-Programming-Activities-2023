public abstract class  Marker
{
    private final String color;
    private final String ink;

    public Marker(String color, String ink)
    {
        this.color = color;
        this.ink = ink;
    }

    public void refill()
    {
        System.out.println("Refilling ink " + ink);
    }

    public abstract void cap();
    public abstract void body();
    public abstract void catridge(String color);

    public void assemble()
    {
        cap();
        body();
        catridge(color);
    }

    public void useMarker()
    {
        System.out.println("Marker created with " + color);
    }

//    @Override
//    public String toString() {
//        return this.color + " " + this.ink;
//    }
}
