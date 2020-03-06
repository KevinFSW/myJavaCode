package app.innerclass;

import app.designpatternandpolymorphic.adapter.Animal;

public class InnerClass{

    //成员内部类
    public class ItemInnerClass{
        public void innerClassFun(){
            System.out.println("这个是成员内部类的方法");
        }
    }

    public void innerClassFun(){
        System.out.println("这个是普通的方法0");
        ItemInnerClass itemInnerClass = new ItemInnerClass();
        itemInnerClass.innerClassFun();
        
        //局部内部类
        class LocalInnerClass {
            String name = "LocalInnerClass";
            public void localInnerClassFunction(){
                System.out.println("这个是局部内部类的方法" + this.name);
            }
        }

        LocalInnerClass localInnerClass = new LocalInnerClass();
        localInnerClass.localInnerClassFunction();
    }

    public void unamedInnerTest(){
        System.out.println("这个是普通的方法1");

        //匿名内部类
        Animal animal = new Animal(){
        
            @Override
            public void sleep() {
                // TODO Auto-generated method stub
                System.out.println("这个是匿名内部类的方法sleep");
            }
        
            @Override
            public String getName() {
                // TODO Auto-generated method stub
                System.out.println("这个是匿名内部类的方法getName");
                return null;
            }
        
            @Override
            public void eat() {
                // TODO Auto-generated method stub
                System.out.println("这个是匿名内部类的方法eat");
            }
        };

        animal.eat();
        animal.getName();
        animal.sleep();
    }

    public void finalize(){
        
    }
    
}