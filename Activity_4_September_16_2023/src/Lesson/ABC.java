package Lesson;

public class ABC extends PaySlipCalculator
{
    // using final means we have to initialize it
    // we can use a constructor to initialize it
    private final double rate;
    private final int hours;

    public ABC(Company company, String department, double rate, int hours) {
        super(company, department);
        this.rate = rate;
        this.hours = hours;
    }

    //    Invalid since we extended the class
//    public ABC(double rate, int hours)
//    {
//        this.rate = rate;
//        this.hours = hours;
//    }
    public Payslip calculate()
    {
        Payslip p = new Payslip();
        double pay = this.rate * this.hours;
        p.setTotal(pay);
        p.setHours(this.hours);
        p.setRate(this.rate);
        return p;
    }
}
