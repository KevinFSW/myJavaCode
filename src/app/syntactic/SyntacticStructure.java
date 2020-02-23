/**
 * Edit and run with VSCode, default encoding: UTF-8
 */

package app.syntactic;

import java.util.Scanner;

public class SyntacticStructure{

    /**
    * 单分支if   条件必须是boolean，可实现比较复杂的逻辑判断，执行效率低
    *    
    * 练习利用if
    * 根据月份判断季节
    */
    public static void test0(){
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

    /**
    * 单分支if   条件必须是boolean，可实现比较复杂的逻辑判断，执行效率低
    *   
    * 练习利用if
    * 判断学生成绩的区间
    */
    public static void test1(){
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

    /**
    * 单分支if   条件必须是boolean，可实现比较复杂的逻辑判断，执行效率低
    *    
    * 练习利用if
    * 实现随机骰子小游戏
    */
    public static void test2(){
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

            
    /**
    * 多分支switch  条件可用byte，short，int，char，1.5版本及后可用enum，1.7版本及后可用String，执行效率高，只能实现==判断
    *    
    * 练习利用switch
    * 判断学生成绩的区间
    */
    public static void test3(){
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

    
    /**
    * 多分支switch  条件可用byte，short，int，char，1.5版本及后可用enum，1.7版本及后可用String，执行效率高，只能实现==判断
    *   
    * 练习利用switch
    * 给小明制定学习计划
    */
    public static void test4(){
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
  
    /**   
    * 循环结构
    * for   
    *    
    * 练习 
    *
    * 操场上有一百多个人，三人一组多一个，四人一组多两个，五人一组多两个，求人数。
    * x%3 = 1; x%4 = 2; x%5 = 2;
    */        
    public static void test5(){
        int x = 100;
        for(x = 100; x < 200; x++)
        {
            if(x%3 == 1 && x%4 == 2 && x%5 == 2)
            {
                System.out.println("总共有" + x + "人");
                break;//去掉break，可以知道答案是否唯一
            }
        }
    }

    /**      
    * 循环结构
    * for   
    *    
    * 练习 
    *
    * 甲a乙b丙c丁d加工370个零件，如果甲多10，乙少20个，丙乘以2，丁除以2，则四人加工数相等，求四人实际每人加工多少。
    * a+10==b-20==c*2==d/2;
    */
    public static void test6(){

        int x = 10;//x=a+10;因为a不会是负数，所以x大于等于10
        //a=x-10;b=x+20;c=x/2;d=x*2;

        for(x = 10; x < 370/2; x++)
        {
            if(x-10+x+20+x/2+x*2 == 370)
            {
                System.out.printf("甲 %d，乙 %d，丙 %d，丁 %d\n", x-10, x+20, x/2, x*2);
                return;
            }
        }
    }

    /**      
    * 循环结构
    * for   
    *    
    * 练习 
    *        
    * 鸡a兔b同笼问题，鸡兔总数50，脚160，求鸡和兔各多少。
    * a*2+b*4=160,b=50-a;
    */
    public static void test7(){
        int a = 0;//鸡
        //50-a=兔

        for(a = 0; a < 50; a++)
        {
            if(a*2+(50-a)*4==160)
            {
                System.out.printf("鸡 %d，兔 %d\n", a, 50-a);
                return;
            }
        }
    }

    /**
    * 循环结构
    * for   
    *
    * 练习 
    *
    *   通过循环寻找三位数的水仙花数，例如153，1^3+5^3+3^3 = 153。
    *   99<x<1000,(x/100)^3+(x%100/10)^3+(x%10)^3 == x;
    */
    public static void test8(){
        int x = 100;

        for(x = 100; x < 1000; x++)
        {
            if(Math.pow(x/100, 3)+Math.pow(x%100/10, 3)+Math.pow(x%10, 3) == x)
            {
                System.out.print(x+",");
            }
        }
        System.out.println("");
    }

    private static void draw(int row, int rank, char drawCh, boolean newLine){
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < rank; j++)
            {
                System.out.print(drawCh);
            }

            if(newLine)
            {
                System.out.println();
            }
        }
    }

    /**
    * 循环嵌套
    * 练习
    * *******
    * ***#***
    * **###**
    * *#####*
    */
    public static void test9(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入行数：");
        int row = input.nextInt();

        for(int i = 0; i < row; i++)
        {
            /*
            ****
            ***#
            **##
            *###
            */
            for(int j = 0; j < row-i; j++)
            {
                System.out.print("*");
            }

            for(int j = 0; j < i; j++)
            {
                System.out.print("#");
            }

            /*
            ****
            #***
            ##**
            ###*
            但是要去掉每行第一个 
            */
            for(int j = 1; j < i; j++)
            {
                System.out.print("#");
            }

            for(int j = 0; j < row-i; j++)
            {
                if(i!=0 || j!=0)
                    System.out.print("*");
            }

            System.out.println();
        }
    }

    /** 
    * 循环嵌套
    * 练习
    *    1   
    *   121  
    *  12321 
    * 1234321
    */
    public static void test10(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入行数：");
        int row = input.nextInt();

        for(int i = 1; i <= row; i++)
        {
            /*
               1
              12
             123
            1234
            */
            for(int j = 1; j <= row-i; j++)
            {
                System.out.print(" ");
            }

            for(int j = 1; j <= i; j++)
            {
                System.out.print(j);
            }

            /*
            1   
            21  
            321 
            4321
            但是要去掉每行第一个 
            */
            for(int j = 2; j <= i; j++)
            {
                System.out.print(i-j+1);
            }

            for(int j = 1; j <= row-i; j++)
            {
                System.out.print(" ");
            }

            System.out.println();
        }
    }

    /**
    * 循环嵌套
    * 练习
    * 1*1=1
    * 1*2=2  2*2=4
    * 1*3=3  2*3=6  3*3=9
    */
    public static void test11(){
        for(int i = 1; i <= 9; i++)
        {
            for(int j = 1; j <= i; j++)
            {
                System.out.print(j+"*"+i+"="+j*i+"\t");
            }
            System.out.println();
        }
    }

    /** 
    * 循环嵌套
    * 练习
    *
    * 找2～100之间的素数
    */
    public static void test12(){
        boolean isPrime = false;//标记从循环出来的结果
        for(int i = 2; i <= 100; i++)
        {
            isPrime = true;
            for(int j = 2; j < i; j++)//对非1和非自身的数取余数，余数为0说明能被整除，不是素数
            {
                if(i%j == 0)
                {
                    isPrime = false;
                    System.out.println(i+"不是素数");
                    break;//不是素数则跳出取余循环，判断下一个数字
                }
            }

            if(isPrime == true)//是素数
            {
                System.out.println(i+"是素数");
            }
        }
    }

    /**
     * 循环标记
     * 练习
     */
    public static void test13(){
        loop1:for (int i = 0; i < 5; i++) {
            System.out.println("loop1 : " + i);
            loop2:for (int j = 0; j < 5; j++) {
                if (j == 3) {
                    //break loop1;
                    continue loop2;
                }
                System.out.println("    loop2 : " + j);
            }
        }
    }
    
    /**
     * while 
     * 练习
     *    *
     *   ***
     *  *****
     * *******
     * 行 空格 *
     * 1   3   1
     * 2   2   3
     * 3   1   5
     * 4   0   7
     */
    public static void test14(){
        int i = 1;
        int j = 1;

        while(i <= 4)
        {
            j = 1;
            while(j <= 4-i)
            {
                System.out.print(" ");
                j++;
            }

            j = 1;
            while (j <= 2*i-1) {
                System.out.print("*");
                j++;                
            }

            System.out.println();
            i++;
        }
    }

    /**
     * while
     * 练习
     * 相遇问题
     * 小明从A以7速度向B出发，哥哥从B以18速度向A出发，
     * AB距离1000，多久相遇。
     */
    public static void test15(){

         int i = 0;//两个人的初始路程为0
         int j = 0;

         while(i + j < 1000)//相遇时，两人路程之和必定等于1000
         {
            i += 7;
            j += 18;
         }

         System.out.println("经过" + i/7 + "小时后相遇");//路程除以速度等于时间
    }

    /**
     * while 
     * 练习
     * 一车西瓜1020个每天卖掉总数的一半多两个，多久能卖完
     */
    public static void test16(){
        int watermelon = 1020;
        int day = 0;

        while(watermelon > 0)
        {
            watermelon = watermelon/2 - 2;
            day++; 
        }

        System.out.println("经过" + day + "天卖完");
    }

}