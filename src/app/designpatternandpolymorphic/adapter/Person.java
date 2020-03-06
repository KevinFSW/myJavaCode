package app.designpatternandpolymorphic.adapter;

public abstract class Person implements Animal{
    public String name = "Person";
    
    public void walk(){
        System.out.println("Person walk");
    }

    public void drive(){
        System.out.println("Person drive");
    }
}