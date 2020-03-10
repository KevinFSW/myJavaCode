package tool.mathclass;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.UUID;

public class MathTest{
    public static void main(String[] args) {
        double i = Math.ceil(1.4);//向上取整
        System.out.println(i);
        i = Math.floor(1.4);//向下取整
        System.out.println(i);
        i = Math.rint(2.5);//临近的整数，如果两边距离一样，则返回偶数
        System.out.println(i);
        i = Math.round(1.4);//四舍五入的整数
        System.out.println(i);

        Random r = new Random();
        int ri = r.nextInt(9);
        System.out.println(ri);
        ri = r.nextInt();
        System.out.println(ri);
        float rf = r.nextFloat();
        System.out.println(rf);

        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());

        DecimalFormat df = new DecimalFormat("000.000");
        String value = df.format(123.45);// ==> 123.450
        System.out.println(value);
    }
}