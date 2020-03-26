package thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ThreadTest {
    public static void main(String[] args) {
        // RedPackage redPackage = new RedPackage();
        // Person[] p = new Person[10];
        // redPackage.start();
        // for (int i = 0; i < p.length; i++) {
        // p[i] = new Person("p" + i);
        // p[i].setRedPackage(redPackage);
        // p[i].start();
        // }
        // Consumer consumer = new Consumer();
        // consumer.start();
        // Warehouse.getWarehouse().start();
        // One one = new One();
        // one.start();
        // Chopstick c0 = new Chopstick(0);
        // Chopstick c1 = new Chopstick(1);
        // Chopstick c2 = new Chopstick(2);
        // Chopstick c3 = new Chopstick(3);

        // Diners d0 = new Diners("a", c1, c0, 0);
        // Diners d1 = new Diners("b", c2, c1, 100);
        // Diners d2 = new Diners("c", c3, c2, 0);
        // Diners d3 = new Diners("d", c0, c3, 100);

        // d0.start();
        // d1.start();
        // d2.start();
        // d3.start();

        Timer timer = new Timer();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        try {
            date = sf.parse("2020-3-27 00:36:20");
            timer.schedule(new TimerTask(){
                int cnt = 0;
                @Override
                public void run() {
                    System.out.println("cnt " + cnt++);
                    if(this.cnt > 5){
                        this.cancel();
                        timer.cancel();
                    }
                }
                
            }, date, 3000);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}