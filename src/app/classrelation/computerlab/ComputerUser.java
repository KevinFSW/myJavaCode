package app.classrelation.computerlab;

public class ComputerUser{

    public String name;
    //使用电脑的人知道他用的是哪台电脑
    //或者说，电脑使用者需要有一台电脑
    public Computer computer = null;

    /**
     * 开始使用电脑
     * @param pc
     */
    public void startUsingComputer(Computer pc){
        pc.computerSwitchOn();
        pc.computerStartWorking();
        this.computer = pc;
    }

    /**
     * 停止使用电脑
     * @param pc
     */
    public void stopUsingComputer(Computer pc){
        pc.computerPowerOff();
        this.computer = null;
    }

}