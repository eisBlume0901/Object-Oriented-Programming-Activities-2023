package Lesson;

public class A
{
    public void print()
    {
        System.out.println("Hello A");
    }

    // Method Overloading
    public int add(int a, int b)
    {
        return a + b;
    }

    public int add(int a, int b, int c)
    {
        return a + b + c;
    }

    public double add(double a, double b)
    {
        return a + b;
    }
}

class B extends A
{
    // Method Overriding
    @Override
    public void print()
    {
        System.out.println("Hello B");
    }
}

class Main
{
    public static void main(String[] args)
    {
        A a = new B();
        a.print(); // Hello B
    }
}