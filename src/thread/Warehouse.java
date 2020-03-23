package thread;

import java.util.ArrayList;

public class Warehouse extends Thread{
    private static final Warehouse warehouse = new Warehouse();
    private ArrayList<String> arrayList = new ArrayList<>();

    private Warehouse() {
    }

    public static Warehouse getWarehouse() {
        return warehouse;
    }

    public synchronized void add() {
        if (arrayList.size() < 10) {
            System.out.println("add " + arrayList.size());
            arrayList.add("" + arrayList.size());
        } else {
            try {
                this.notifyAll();
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public synchronized void get(){
        if (arrayList.size() > 0) {
            System.out.println("get " + arrayList.remove(0));
        } else {
            try {
                this.notifyAll();
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            this.add();
        }
    }
}