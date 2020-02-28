package app.classrelation;

public class Farmer{

    private Pig farmersPig;//农民有一头猪

    public void farmerBuyPig(){
        this.farmersPig = new Pig("野猪");
    }

    /**
     * 农民养猪
     * @return
     */
    public void farmerFeedPig(){
        farmersPig.pigGrowUpPerFeed();
    }

    public Pig farmerSellPig(){
        return this.farmersPig;
    }
}