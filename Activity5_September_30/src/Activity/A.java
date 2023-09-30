package Activity;

public class A
{
    private String a;
    private int b;

    public A(String a, String b)
    {
        this.a = a;
        this.b = Integer.parseInt(b);
    }

    // Method overloading
    public void print(String x)
    {
        System.out.println(x); // Value of x
    }

    public void print(String x, String y)
    {
        System.out.println(x + " " + y); // Concatenate
    }
    public int print(String x, int y)
    {
        return Integer.parseInt(x); // Convert number string to integer
    }
}

class B extends A
{
    public B(String a, String b)
    {
        super(a, b);
    }

    @Override
    public void print(String x)
    {
        System.out.println("x"); // x
    }

    @Override
    public void print(String x, String y)
    {
        super.print(x, y);
        super.print(x, y);
    }

    public void test()
    {
        C c = new C();
        c.print();
    }
}

class C
{
    public C(String a, String b)
    {
        System.out.println(a); // Display a
        System.out.println(b); // Display b
    }

    public C()
    {

    }

    public void print()
    {
        System.out.println("x");
    }
}

class Main
{
    public static void main(String[] args)
    {
//        B b = new B("B", "C"); // Number Format Exception, if correct B should be number string
//        b.print("B"); // Number Format Exception, if correct x
//        b.print("A", "B"); // Number Format Exception, if correct A B, A B
//        b.test(); // x

//        A a = new A("A", "B"); // Number Format Exception, if correct B should be number string
//        a.print("B", "B"); // Number Format Exception
//        a.print("B", ""); // Number Format Exception
//        a.print("B"); // B

//        A a = new A("A", "B"); // Number Format Exception, if correct B should be number string
//        a.print("B", "B"); // B B
//        a.print("B", 1); // Number Format Exception, since B should be number string
//        a.print("B"); // B

        A a = new C(); // Incompatible since C does not extends A
        a.print("B");
        a.print("C", 33);

        B b = new B();
        b.print("C");
        b.print("C", "B");
        b.print("C", 1);

    }
}