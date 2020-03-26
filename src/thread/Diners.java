package thread;

public class Diners extends Thread {

    private String name;
    private Chopstick left;
    private Chopstick right;
    private int time = 0;

    public Diners(String name, Chopstick left, Chopstick right, int time) {
        this.name = name;
        this.left = left;
        this.right = right;
        this.time = time;
    }

    @Override
    public void run() {
        try {
            sleep(this.time);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        synchronized (this.left) {
            System.out.println(this.name + " get left " + this.left.id);
            synchronized(this.right){
                System.out.println(this.name + " get right " + this.right.id);
                System.out.println(this.name + " start eat ");
            }
        }
    }
}