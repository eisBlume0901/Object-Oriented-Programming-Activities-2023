public class BlackMarker extends Marker
{
    private String color;
    private String ink;
    public BlackMarker(String color, String ink) {
        super(color, ink);
    }

    @Override
    public void cap() {
        System.out.println("Black cap");
    }

    @Override
    public void body() {
        System.out.println("Black body");
    }

    @Override
    public void catridge(String color) {
        super.refill();
        System.out.println("put ink color " + color);
    }
}
