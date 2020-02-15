package app.OperationalSymbol;

public class OperationalSymbol{
    public static void test0() {
        byte a = 1;
        short b = 2;
        int c = 3;
        long d = 4L;
        float e = 5.1F;
        double f = 5.1;
        char g = 'a';
        boolean h = true;

        System.out.println("OperationalSymbol test0");

        c = 1000;
        System.out.println("a = " + a + ", c = " + c);
        a = (byte)c;        
        System.out.println("a = (byte)c" + " = " + a);

        System.out.println("b = " + b + ", c = " + c);
        c = b++;
        System.out.println("c = b++, b = " + b + ", c = " + c);

        System.out.println("b = " + b);
        b = b++;
        System.out.println("b = b++" + ", b = " + b);
    }

    public static void test1() {
        int m = 1;
        int n = 2;

        System.out.println("OperationalSymbol test1");
        System.out.println("m = " + m);
        System.out.println("n = " + n);

        int sum = m++ + ++n - n-- - --m + n-- - --m;
        System.out.println("sum = m++ + ++n - n-- - --m + n-- - --m");
        System.out.println("m = " + m);
        System.out.println("n = " + n);
        System.out.println("sum = " + sum);
    }
}