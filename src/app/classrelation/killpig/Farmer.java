package app.classrelation.killpig;

public class Farmer{

    private Pig farmersPig;//农民有一头猪

    /**
     * 农民买了一头猪
     * @param type 猪的种类
     */
    public void farmerBuyPig(String type){
        this.farmersPig = new Pig(type);
    }

    /**
     * 农民养猪
     */
    public void farmerFeedPig(){
        farmersPig.pigGrowUp();
    }

    /**
     * 农民卖猪
     * @return 猪
     */
    public Pig farmerSellPig(){
        return this.farmersPig;
    }
}