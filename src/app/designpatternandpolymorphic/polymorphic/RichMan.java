package app.designpatternandpolymorphic.polymorphic;

public class RichMan extends BusinessProcess{
    
    @Override
    public void lineUp() {
        // TODO Auto-generated method stub
        System.out.println("RichMan line up");
    }

    @Override
    public void business() {
        // TODO Auto-generated method stub
        System.out.println("RichMan business");
    }

    @Override
    public void finish() {
        // TODO Auto-generated method stub
        System.out.println("RichMan finish");

    }
}