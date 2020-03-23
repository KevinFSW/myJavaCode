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
            if(redPackage.isAlive() == false){
                break; //没人发红包了，不用窥屏了
            }
            //没有红包或者已经抢过了，sleep一下等一等
            if (redPackage == null || oldRedPackageId == redPackage.getPackageId()) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                continue;
            }
            
            oldRedPackageId = redPackage.getPackageId();//更新红包ID
        
            float get = this.redPackage.getMoneyRandom();//抢红包，看运气
            if(get != 0f){
                System.out.println(this.name + "抢到了 " + get);
            }
            else{
                System.out.println(this.name + "没抢到");
            }
        }
    }
}