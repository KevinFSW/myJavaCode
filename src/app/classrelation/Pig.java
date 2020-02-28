package app.classrelation;

public class Pig{
    public String type;
    public int weight;

    /**
     * 构造方法：买了一头type品种的猪
     * @param type 品种
     */
    public Pig(String type){
        this.type = type;
        this.weight = (int)(Math.random() * 10) + 5;//体重
    }

    /**
     * 方法：每次喂猪猪会长大
     * @return 每次喂完后猪的总体重
     */
    public void pigGrowUpPerFeed(){
        this.weight += (int)(Math.random() * 20);
    }
}

