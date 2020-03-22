package thread;

import java.util.Random;
import java.util.Scanner;

public class RedPackage extends Thread {
    private volatile float money = 0;
    private volatile int packageNum = 0;
    private volatile float basic = 0;
    private volatile int packageId = 0;

    public RedPackage() {

    }

    public RedPackage(float money, int num) {
        this.money = money;
        this.packageNum = num;
    }

    public int getPackageId() {
        return this.packageId;
    }

    public synchronized float getMoneyRandom() {
        if (this.packageNum == 0) {
            return 0f;
        }

        Random r = new Random();
        if (this.packageNum == 1) {
            this.packageNum = 0;
            return this.money;
        }

        if((this.money / (float) this.packageNum) < this.basic){
            System.out.println("  x   ");
            this.basic = (this.money / (float) this.packageNum);
        }

        float randomMoney = this.basic + (0.5f - r.nextFloat()) * (this.money / (float) this.packageNum);
        this.money -= randomMoney;
        this.packageNum--;

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
                sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}