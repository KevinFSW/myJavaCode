package thread;

public class Three extends Thread {
    private Two two = null;

    public Three(Two two){
        this.two = two;
    }

    @Override
    public void run() {
        System.out.println("three start");
        synchronized (two) {
            try {
                sleep(10000);
                System.out.println("three end");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}