public class GCash
{
    private String number;
    private int Mpin;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (number.matches("^09\\d{9}$"))
        {
            this.number = number;
        }
        else throw new IllegalArgumentException("Phone number is invalid");
    }

    public int getMpin() {
        return Mpin;
    }

    public void setMpin(int mpin) {
        if (mpin >= 0000 && mpin <= 9999)
        {
            this.Mpin = mpin;
        }
        else throw new IllegalArgumentException("Mpin is invalid");
    }
}