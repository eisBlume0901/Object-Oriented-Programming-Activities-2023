public class BlueMarker extends Marker
{
    // removing instance variable is better to avoid redundancy in code
    // since we used constructor matching the super
    private String color;
    private String ink;
    public BlueMarker(String color, String ink)
    {
        super(color, ink);
    }

    @Override
    public void refill() {
        System.out.println("refilling blue marker");
    }

    @Override
    public void cap() {
        System.out.println("Blue cap");
    }

    @Override
    public void body() {
        System.out.println("Blue body");
    }

    @Override
    public void catridge(String color) {
        System.out.println("put ink color" + color);
    }
}
