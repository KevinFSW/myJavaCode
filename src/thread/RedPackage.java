package thread;

import java.util.Random;
import java.util.Scanner;

public class RedPackage extends Thread {

    //volatile这个修饰符很重要，因为是在线程间使用变量
    private volatile float money = 0;    //红包总额
    private volatile int packageNum = 0; //红包个数
    private volatile float basic = 0;    //随机红包的基数（在这个基数的基础上加或减一个随机数）
    private volatile int packageId = 0;  //红包ID，person通过判断这个ID是否更新来决定要不要抢

    public RedPackage() {

    }

    public RedPackage(float money, int num) {
        this.money = money;
        this.packageNum = num;
    }

    public int getPackageId() {
        return this.packageId;
    }

    /**
     * 生成随机金额的红包
     * @return
     */
    public synchronized float getMoneyRandom() { //synchronized，避免两个及以上的线程同时调这个方法
        if (this.packageNum == 0) {
            return 0f;
        }

        if (this.packageNum == 1) { //只剩下最后一个红包，直接return money
            this.packageNum = 0;
            return this.money;
        }

        //如果当前basic大于当前剩余总金额和剩余红包个数的商（也就是剩余平均值）
        //则重新计算basic，等于剩余平均值
        if((this.money / (float) this.packageNum) < this.basic){
            System.out.println("  x   ");
            this.basic = (this.money / (float) this.packageNum);
        }

        Random r = new Random();
        //在basic的基础上加减一个随机数，这个随机数可能是正数也可能是负数
        //basic和随机数跟当前剩余总金额和剩余红包个数有关，主要是避免还有剩余红包个数但是总金额没了的情况
        //设置basic，能够避免每个红包的金额差别太大（比如发50，避免会有0.1和40的情况）
        float randomMoney = this.basic + (0.5f - r.nextFloat()) * (this.money / (float) this.packageNum);
        this.money -= randomMoney; //总金额减少
        this.packageNum--; //红包个数减少

        return randomMoney;
    }

    @Override
    public void run() {
        Scanner input = new Scanner(System.in);
        while (true) {
            if (this.packageNum == 0) {
                System.out.println("你要发多少钱？");
                this.money = Float.parseFloat(input.nextLine());
                System.out.println("你要发多少个红包？");
                this.packageNum = Integer.parseInt(input.nextLine());
                this.basic = this.money/(float) this.packageNum;
                this.packageId++;
            }

            try {
                sleep(1000); //sleep一下减少资源消耗
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}