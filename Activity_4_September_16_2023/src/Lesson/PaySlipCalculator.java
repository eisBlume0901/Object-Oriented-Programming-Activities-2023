package Lesson;

public abstract class PaySlipCalculator
{
    private Company company;
    private String department;

    public PaySlipCalculator(Company company, String department)
    {
        this.company = company;
        this.department = department;
    }

    public void printPayslip()
    {
        Payslip payslip = calculate();

        System.out.println("Salary: " +  payslip.getTotal());
    }

    public abstract Payslip calculate();

}
