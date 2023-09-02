public class Address
{
    private String streetNumber;
    private String barangay;
    private String city;

    public String getStreetNumber()
    {
        return streetNumber;
    }

    public String getBarangay()
    {
        return barangay;
    }

    public String getCity()
    {
        return city;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return this.streetNumber + ", " + this.barangay + ", " + this.city;
    }
}