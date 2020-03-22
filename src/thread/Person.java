package thread;

public class Person extends Thread {
    private String name = null;
    private RedPackage redPackage = null;
    private int oldRedPackageId = 0;

    public void setRedPackage(RedPackage redPackage) {
        this.redPackage = redPackage;
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            if (redPackage == null || oldRedPackageId == redPackage.getPackageId()) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                continue;
            }
            
            oldRedPackageId = redPackage.getPackageId();
        
            float get = this.redPackage.getMoneyRandom();
            if(get != 0f){
                System.out.println(this.name + "抢到了 " + get);
            }
            else{
                System.out.println(this.name + "没抢到");
            }
        }
    }
}