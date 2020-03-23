package thread;

public class ThreadTest {
    public static void main(String[] args) {
        RedPackage redPackage = new RedPackage();
        Person[] p = new Person[10];
        for (int i = 0; i < p.length; i++) {
            p[i] = new Person("p" + i);
            p[i].setRedPackage(redPackage);
        }
        redPackage.start();
        for (int i = 0; i < p.length; i++) {
            p[i].start();
        }
    }
}