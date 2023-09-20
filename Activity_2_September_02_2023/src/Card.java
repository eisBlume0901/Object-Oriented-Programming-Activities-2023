public class Card
{
    private String creditCardNumber;
    private int cvv;
    private String creditCardExpiry;

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber)
    {
        if (creditCardNumber.matches("^[0-9]{16}$"))
        {
            this.creditCardNumber = creditCardNumber;
        }
        else throw new IllegalArgumentException("Credit Card Number Invalid");

    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        if (cvv <= 999)
        {
            this.cvv = cvv;
        }
        else throw new IllegalArgumentException("CVV format is invalid");
    }

    public String getCreditCardExpiry()
    {
        return creditCardExpiry;
    }

    public void setCreditCardExpiry(String creditCardExpiry) {
        if (creditCardExpiry.matches("^(0[1-9]|1[0-2])/(20[2-9][0-9]|2[1-9][0-9]{2})$"))
        {
            this.creditCardExpiry = creditCardExpiry;

        }
        else throw new IllegalArgumentException("Credit Card Expiry is invalid");
    }
}