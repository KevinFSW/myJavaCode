package app.classrelation.computerlab;

public class Computer{
    public boolean powerOn = false;//开关机状态
    public boolean busy = false;//是否正在被使用
    public int pcID = 0;

    public Computer(int pcID){
        this.pcID = pcID;
    }
    /**
     * 打开电脑
     */
    public void computerSwitchOn(){
        System.out.println(this.pcID + " computer poweron");
        this.powerOn = true;
        this.busy = false;
    }

    /**
     * 使用电脑
     */
    public void computerStartWorking(){
        this.busy = true;
        System.out.println(this.pcID + " computer start working");
    }

    /**
     * 关闭电脑
     */
    public void computerPowerOff(){
        this.powerOn = false;
        this.busy = false;
        System.out.println(this.pcID + " computer poweroff");
    }
}