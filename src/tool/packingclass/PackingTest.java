package tool.packingclass;

public class PackingTest {
    public static void main(String[] args) {
        Integer i1 = 10;
        Integer i2 = 10;
        Integer i3 = new Integer(10);
        Integer i4 = new Integer(10);

        System.out.println(i1 == i2);
        System.out.println(i1 == i3);
        System.out.println(i3 == i4);
        System.out.println(i1.equals(i2));
        System.out.println(i1.equals(i3));
        System.out.println(i3.equals(i4));

        Integer i5 = 1000;
        Integer i6 = 1000;
        Integer i7 = new Integer(1000);
        Integer i8 = new Integer(1000);

        System.out.println(i5 == i6);
        System.out.println(i5 == i7);
        System.out.println(i7 == i8);
        System.out.println(i5.equals(i6));
        System.out.println(i5.equals(i7));
        System.out.println(i7.equals(i8));

        int i = i1;
        int s = i1.parseInt("123");

        System.out.println(i);
        System.out.println(s);
    }
}