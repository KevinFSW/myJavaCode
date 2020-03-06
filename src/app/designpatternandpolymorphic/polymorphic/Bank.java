package app.designpatternandpolymorphic.polymorphic;

public class Bank{
    public void acceptBusiness(BusinessProcess bp){
        bp.lineUp();
        bp.business();
        bp.finish();
    }
}