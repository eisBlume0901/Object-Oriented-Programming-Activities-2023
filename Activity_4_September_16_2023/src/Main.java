import Lesson.*;

public class Main
{
    public static void main(String[] args)
    {
//        Company c = new Company();
//        c.setName("ABC");
//        c.setDescription("Coffee Company");
//        PaySlipCalculator p = new ABC(c, "accounting department", 80, 30);
//        System.out.println(p.calculate());
//        p.printPayslip();
//
//        Company d = new Company();
//        d.setName("DEF");
//        d.setDescription("computer company");
//        PaySlipCalculator q = new DEF(d, "IT department", 5, 5);
//        System.out.println(q.calculate());
//        q.printPayslip();


        // Question 1
        Manufacturer f = new Manufacturer(5);
        f.start();
        f.build();
        /*
        We add 1 marker to List
        We add 1 marker to List2
         */
        f.massProduce();
        /*
        List has 6 markers
        List2 has 6 markers
         */
        f.end();

        System.out.println(f.getMarker("Blue"));
        System.out.println(f.getMarker("Black"));
        Marker m = f.m("Blue");
        m.assemble();
        m.useMarker();
        m.refill();

        // Question 2
    }
}