package app.object.calculate;

import java.util.Scanner;

public class Calculate{

    /**
     * //计算
     * @param num1 输入的第一个数
     * @param opt 输入的运算符号
     * @param num2 输入的第二个数
     */
    public float showCalResult(float num1, String opt, float num2){
        float result = 0;

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
                    return 0;
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("无法识别这个运算符号！");
                return 0;
        }

        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Calculate calculate = new Calculate();
        System.out.println("请输入第一个数");
        String a = input.nextLine();
        float num1 = Float.parseFloat(a);
        while(true){
            System.out.println("请输入运算符号");
            String opt = input.nextLine();
            if(opt.equals("=")){
                System.out.println(num1);
                System.out.println("计算完毕。");
                break;
            }

            if(!(opt.equals("+") || opt.equals("-") || opt.equals("*") || opt.equals("/"))){
                System.out.println("运算符号输入错误, 只能输入[+ - * /], 结束请输入“=”号. ");
                continue;
            }
            
            System.out.println("请输入第二个数");
            String b = input.nextLine();
            float num2 = Float.parseFloat(b);

            num1 = calculate.showCalResult(num1, opt, num2);
        }
    }

}