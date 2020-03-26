package thread;

public class One extends Thread {

    @Override
    public void run() {
        System.out.println("one start");
        Two two = new Two();
        two.start();
        try {
            two.join(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("one end");
    }
}