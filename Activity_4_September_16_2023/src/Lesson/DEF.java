package Lesson;

public class DEF extends PaySlipCalculator
{
    private int hours;
    private double rate;

    public DEF(Company company, String department) {
        super(company, department);
    }

    public DEF(Company company, String department, double rate, int hours)
    {
        super(company, department);
        this.rate = rate;
        this.hours = hours;
    }

    @Override
    public Payslip calculate() {
        Payslip p = new Payslip();
        double pay = this.hours * 7 * this.rate;
        p.setTotal(pay);
        p.setRate(this.rate);
        p.setHours(this.hours);
        return p;
    }
}
