/**
 * Edit and run with VSCode, default encoding: UTF-8
 */

 package app.operation;

/**
 * 运算符练习代码
 */
public class OperationalSymbol{
    public static void test0() {
        byte a = 1;//大于2的7次方会报错，因为超过了byte能够存放的大小(-128 ~ 127，以下同理)
        short b = 2;
        int c = 3;
        long d = 4L;//整型常量在内存中默认占用 32bit（int）
        float e = 5.1F;//浮点型常量在内存中默认占用 64bit（double）
        double f = 5.1;
        char g = 'a';
        boolean h = true;

        System.out.println("OperationalSymbol test0");

        c = 1000;
        System.out.println("a = " + a + ", c = " + c);
        a = (byte)c;//超过大小会直接截断        
        System.out.println("a = (byte)c" + " = " + a);
        f = e;
        //e = f;//大到小要强制转换
        e = (float)f;

        System.out.println("b = " + b + ", c = " + c);
        c = b++;
        System.out.println("c = b++, b = " + b + ", c = " + c);

        System.out.println("b = " + b);
        b = b++;//这里是等于b的备份，而非b++后的值
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

    public static void test2() {
        byte x = 1;
        
        System.out.println("OperationalSymbol test2");
        System.out.println("x = " + x);
        x += 2;
        System.out.println("x += 2, x = " + x);
        //x = x + 2;//变量跟常量计算时，可能会转换类型，这里会先按照int计算再赋值，所以会报错
        x = (byte)(x + 2);
    }

    public static void test3() {
        int x = 6;
        int y = 7;

        System.out.println("OperationalSymbol test3");
        System.out.printf("~%d = %d\n", x, ~x);
        System.out.printf("~%d = %d\n", y, ~y);

        y = -2;
        System.out.printf("%d >> 1 = %d\n", y, y >> 1);
        System.out.printf("%d >>> 1 = %d\n", y, y >>> 1);//>>保留符号位   >>>高位补0
        System.out.printf("%d = %x\n", y, y);
    }
}