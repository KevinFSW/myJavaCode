package app.classrelation.computerlab;

public class ComputerLab{
    static final int DEFUALT_USABLE = 5;
    public int usable;
    public Computer[] pcArray;

    public ComputerLab(){
        this.usable = DEFUALT_USABLE;

        pcArray = new Computer[DEFUALT_USABLE];
        for (int i = 0; i < pcArray.length; i++) {
            pcArray[i] = new Computer(i);//创建total台电脑
        }
    }

    /**
     * 构造方法重载
     * @param total 电脑的数量
     */
    public ComputerLab(int total){
        this.usable = total;

        pcArray = new Computer[total];
        for (int i = 0; i < pcArray.length; i++) {
            pcArray[i] = new Computer(i);//创建total台电脑
        }
    }

    /**
     * 进入机房用电脑
     * @param user
     * @return
     */
    public int acceptUserToUseComputer(ComputerUser user){
        if(user.computer != null){
            return -2;//已经在用电脑了
        }
        else if(this.usable == 0){
            return -1;//没有电脑，不允许上机
        }

        for (Computer computer : pcArray) {
            //找空闲的电脑上机
            if(!computer.busy){
                user.startUsingComputer(computer);
                user.computer = computer;
                break;
            }
        }
        
        this.usable--;//空闲电脑数量减一
        return 1;
    }

    public boolean allowUserToFinishUsingComputer(ComputerUser user){
        if(user.computer == null){
            return false;//没有在上机
        }
        user.stopUsingComputer(user.computer);
        this.usable++;
        return true;
    }
}