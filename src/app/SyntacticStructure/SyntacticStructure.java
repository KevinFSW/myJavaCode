/**
 * Edit and run with VSCode, default encoding: UTF-8
 */

package app.SyntacticStructure;

import java.util.Scanner;

public class SyntacticStructure{
    public static void test0(){
    /*      
        单分支if   条件必须是boolean，可实现比较复杂的逻辑判断，执行效率低
        
        练习利用if
        根据月份判断季节
    */
        Scanner input = new Scanner(System.in);

        System.out.println("请输入月份，帮你查询季节：");
        int month = input.nextInt();

        if(month > 12 || month < 1)//超出范围了，不需要再继续执行
        {
            System.out.println("输入错误，没有这个月份！");
            return;
        }

        if(month >= 3 && month <= 5)
        {
            System.out.println("春季");
        }
        else if(month >= 6 && month <= 8)
        {
            System.out.println("夏季");
        }
        else if(month >= 9 && month <= 11)
        {
            System.out.println("秋季");
        }
        else
        {
            System.out.println("冬季");
        }
    }

    public static void test1(){
    /*
        单分支if   条件必须是boolean，可实现比较复杂的逻辑判断，执行效率低
        
        练习利用if
        判断学生成绩的区间
    */
        Scanner input = new Scanner(System.in);

        System.out.println("请输入学生的成绩：");
        int score = input.nextInt();//假设成绩只有整数

        if(score > 100 || score < 0)//超出范围了，不需要再继续执行
        {
            System.out.println("输入错误！请检查！");
            return;
        }

        if(score < 60)
        {
            System.out.println("没有及格，好好努力！");
        }
        else if(score < 70)
        {
            System.out.println("及格了，但还要努力！");
        }
        else if(score < 80)
        {
            System.out.println("还可以，也还要努力！");
        }
        else if(score < 90)
        {
            System.out.println("良好了，继续发扬哦！");
        }
        else if(score < 100)
        {
            System.out.println("优秀了，下次100分！");
        }
        else
        {
            System.out.println("学霸，终于有人跟我一样牛逼了！");
        }

    }

    public static void test2(){
    /*
        单分支if   条件必须是boolean，可实现比较复杂的逻辑判断，执行效率低
        
        练习利用if
        实现随机骰子小游戏
    */
        Scanner input = new Scanner(System.in);

        double dice = Math.random();
        System.out.println("买大买小？");
        String choose = input.next();

        if(((int)(dice*6 + 1) > 3 && choose.equals("大")) 
            || ((int)(dice*6 + 1) < 4 && choose.equals("小")))//当前文件编码是UTF8，默认要改成ANSI才能判断成功
        {
            System.out.println("开 " + (int)(dice*6 + 1) + "，猜对了！");
        }
        else
        {
            System.out.println("开 " + (int)(dice*6 + 1) + "，猜错了！");
        }
        
    }

            
    public static void test3(){
    /*
        多分支switch  条件可用byte，short，int，char，1.5版本及后可用enum，1.7版本及后可用String，执行效率高，只能实现==判断
        
        练习利用switch
            判断学生成绩的区间
    */
        Scanner input = new Scanner(System.in);

        System.out.println("请输入学生的成绩：");
        int score = input.nextInt();//假设成绩只有整数

        if(score > 100 || score < 0)//超出范围了，不需要再继续执行
        {
            System.out.println("输入错误！请检查！");
            return;
        }

        switch(score/10)
        {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("没有及格，好好努力！");
                break;
            case 6:
                System.out.println("及格了，但还要努力！");
                break;
            case 7:
                System.out.println("还可以，也还要努力！");
                break;
            case 8:
                System.out.println("良好了，继续发扬哦！");
                break;
            case 9:
                System.out.println("优秀了，下次100分！");
                break;
            case 10:
                System.out.println("学霸，终于有人跟我一样牛逼了！"); 
                break; 
            default://switch之前已经限定范围，因此此处非必要
                System.out.println("输入错误！请检查！");  
                break;
        }
    }

    
    public static void test4(){
    /*
        多分支switch  条件可用byte，short，int，char，1.5版本及后可用enum，1.7版本及后可用String，执行效率高，只能实现==判断
        
        练习利用switch
            给小明制定学习计划
    */
        Scanner input = new Scanner(System.in);

        System.out.println("今天星期几？");
        int week = input.nextInt();

        switch(week)
        {
            case 1:
            case 3:
            case 5:
                System.out.println("今天学编程");
                break;
            case 2:
            case 4:
            case 6:
                System.out.println("今天学英语");
                break;
            case 7:
                System.out.println("今天做作业");
                break;
            default:
                System.out.println("好好学习，天天向上！");
                break;
        }
    }
                        
/*      待完成
        循环结构
            for   
        
            练习 
            操场上有x个人，三人一组多一个，四人一组多两个，五人一组多两个，求x。
            甲乙丙丁加工370个零件，如果甲多10，乙少20个，丙乘以2，丁除以2，则四人加工数相等，求四人实际每人加工多少。
            鸡兔同笼问题，鸡兔总数50，脚160，求鸡和兔各多少。
            通过循环寻找三位数的水仙花数，例如153，1^3+5^3+3^3 = 153。
        
        while   do…while
        
            import java.util.Scanner;
            Scanner练习    
 */        

}