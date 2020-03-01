package app.classrelation.killpig;

public class Pig {
    public String type;
    public int weight;

    /**
     * 构造方法：买了一头type品种的猪
     * @param type 品种
     */
    public Pig(String type){
        this.type = type;
        this.weight = (int)(Math.random() * 10) + 5;//体重随机
    }

    /**
     * 方法：猪长大
     */
    public void pigGrowUp(){
        this.weight += (int)(Math.random() * 20);
    }
}

