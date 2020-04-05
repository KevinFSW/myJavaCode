package reflect;

public class Person implements Comparable{

    public String name;
    public int age;
    private int money;

    @Override
    public String toString() {
        return '[' + name + ',' + age + ']';
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    public void personEat(){
        System.out.println("personEat()");
    }

    public void personEat(String food){
        System.out.println("personEat(" + food + ")");
    }

    private String personSleep(String sleep){
        System.out.println("personSleep(" + sleep + ")");
        return sleep;
    }

}