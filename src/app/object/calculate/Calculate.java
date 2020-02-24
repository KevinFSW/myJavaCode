package app.object.calculate;

import java.util.Scanner;

public class Calculate{

    /**
     * //计算
     * @param num1 输入的第一个数
     * @param opt 输入的运算符号
     * @param num2 输入的第二个数
     */
    public void showCalResult(double num1, String opt, double num2){
        double result = 0;

        switch (opt) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if(num2 == 0){
                    System.out.println("除数不能是0！");
                    return;
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("无法识别这个运算符号！");
                return;
        }

        System.out.printf("%f %s %f = %f\n", num1, opt, num2, result);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("请输入第一个数");
        double num1 = input.nextDouble();
        System.out.println("请输入运算符号");
        String opt = input.next();
        System.out.println("请输入第二个数");
        double num2 = input.nextDouble();

        Calculate calculate = new Calculate();
        calculate.showCalResult(num1, opt, num2);
    }

}