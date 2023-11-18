package Recitation;

public class A
{
    private String i;
    private String b;

    public A(String i, String b)
    {
        this.i = i;
        this.b = b;
    }

    public void print()
    {
        System.out.println("Hello " + this.b); // concatenate
    }

    public void doSomething(String x)
    {
        try
        {
            int z = Integer.parseInt(x); // will be Integer
            System.out.println(Integer.parseInt(this.i) + z); // will add
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

class B extends A
{
    public B(String i, String b)
    {
        super(i, b);
    }

    @Override
    public void print()
    {
        System.out.println("Hello");
    }

    @Override
    public void doSomething(String x)
    {
        super.doSomething(x);
    }
}

class Main
{
    public static void main(String[] args)
    {
//        A a = new B(); // Error since there is no declared parameters
//        a.print(); // Error, but if correct A a = new B("String1", "String1"), "Hello"
//        a.doSomething("A"); // Still error, since "A" is not an integer but a String

//        B b = new B(); // Error since there is no declared parameters
//        b.print(); // Error, but if correct B b = new B("String1" "String1")
//        b.doSomething("1"); // Error, but if correct sum of "String1" (if this is not a string
//        // but an integer) and 1

//        A a = new B("1", "2");
//        a.print(); // Hello
//        a.doSomething("3"); // 1 + 3 = 4
//
//        B b = new B("3", "2");
//        b.print(); // Hello
//        b.doSomething("4"); // 3 + 4 = 7

//        A a = new B("3","4");
//        a.print();
//        a.doSomething("Given"); // Error since String input cannot be converted to Integer
    }
}