package app.classrelation;

public class PigKiller{
    private Pig pigKillersPig = null;

    public boolean pigKillerBuyPig(Pig pig){
        if(pig.weight > 100){
            System.out.println("这只猪够重了，我要了");
            this.pigKillersPig = pig;
            return true;
        }
        else{
            System.out.println("这只猪" + pig.weight + "斤，不够重，再养养");
            return false;
        }
    }

    public void pigKillerKillPig(){
        if(this.pigKillersPig == null){
            System.out.println("还没猪，要卖猪");
            return;
        }
        System.out.println("这只" + this.pigKillersPig.weight + "斤重的"+ this.pigKillersPig.type + "被宰了");
    }
}