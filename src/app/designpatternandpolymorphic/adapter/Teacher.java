package app.designpatternandpolymorphic.adapter;

public class Teacher extends Person{
    public String name = "Teacher";

    @Override
    public String getName(){
        return name;
    }

    @Override
    public void eat() {
        // TODO Auto-generated method stub
        System.out.println("Teacher eat");
    }

    @Override
    public void sleep() {
        // TODO Auto-generated method stub
        System.out.println("Teacher sleep");
    }

    public void teach(){
        System.out.println("Teacher teach");
    }
    
}