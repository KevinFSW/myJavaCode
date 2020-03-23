package thread;

public class Consumer extends Thread{

    @Override
    public void run() {
        while (true) {
            Warehouse.getWarehouse().get();
        }
    }
    
}