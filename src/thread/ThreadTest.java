package thread;

public class ThreadTest {
    public static void main(String[] args) {
        // RedPackage redPackage = new RedPackage();
        // Person[] p = new Person[10];
        // redPackage.start();
        // for (int i = 0; i < p.length; i++) {
        //     p[i] = new Person("p" + i);
        //     p[i].setRedPackage(redPackage);
        //     p[i].start();
        // }
        Consumer consumer = new Consumer();
        consumer.start();
        Warehouse.getWarehouse().start();
    }
}