import java.util.*;
public class Manufacturer implements Factory
{
    private List<Marker> list = new ArrayList<>();
    private List<Marker> list2 = new ArrayList<>();
    private int size;
    public Manufacturer(int size)
    {
        this.size = size;
    }

    public void letsGo()
    {
        start();
    }
    public List<Marker> getMarker(String type)
    {
        if (type.equals("Blue"))
            return list2;
        return list;
    }
    public void build()
    {
        Marker mb = new BlackMarker("Black black", "ink 250");
        Marker mbl = new BlackMarker("Black blue", "ink 300");

        list.add(mb);
        list2.add(mbl);
    }

    public void massProduce()
    {
        for (int i = 0; i < size; i++)
        {
            build();
        }

        System.out.println(getList());
        System.out.println(getList2());
    }

    public Marker m(String type)
    {
        if (type.equals("Blue"))
            return new BlackMarker("Black", "ink");
        return new BlueMarker("Blue", "ink");
    }


    // Getters and Setters

    public List<Marker> getList() {
        return list;
    }

    public void setList(List<Marker> list) {
        this.list = list;
    }

    public List<Marker> getList2() {
        return list2;
    }

    public void setList2(List<Marker> list2) {
        this.list2 = list2;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
