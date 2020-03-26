package thread;

public class Two extends Thread {

    @Override
    public void run() {
        System.out.println("two start");
        Three three = new Three(this);
        three.start();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("two end");
    }
}