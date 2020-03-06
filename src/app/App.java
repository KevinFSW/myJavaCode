/**
 * Edit and run with VSCode, default encoding: UTF-8
 */

package app;

import app.arraybox.ArrayBox;
import app.designpatternandpolymorphic.adapter.Person;
import app.designpatternandpolymorphic.adapter.Teacher;
import app.designpatternandpolymorphic.polymorphic.Bank;
import app.designpatternandpolymorphic.polymorphic.OldMan;
import app.designpatternandpolymorphic.polymorphic.RichMan;
import app.designpatternandpolymorphic.polymorphic.YoungMan;
import app.enumtest.MyEnum;
import app.innerclass.InnerClass;
import app.innerclass.InnerClass.ItemInnerClass;
import app.linkedbox.LinkedBox;

public class App {

    public static void main(String[] args) throws Exception {
        /*
        LinkedBox<String> arrayBox = new LinkedBox<String>();
        // ArrayBox<String> arrayBox = new ArrayBox<String>();
        for (int i = 0; i < 10; i++) {
            arrayBox.add("i"+i);
        }

        for (int i = 0; i < arrayBox.size(); i++) {
            System.out.print(arrayBox.get(i) + "\t");
        }
        System.out.println();

        //arrayBox.remove(5);
        for (int i = 0; i < arrayBox.size(); i++) {
            System.out.print(arrayBox.remove(i) + "\t");
        }
        System.out.println();

        for (int i = 0; i < arrayBox.size(); i++) {
            System.out.print(arrayBox.get(i) + "\t");
        }
        System.out.println();

        System.out.println(arrayBox.get(5));
        */
        /*
        Person teacher = new Teacher();

        teacher.drive();
        teacher.eat();
        teacher.sleep();
        System.out.println(teacher.name);
        System.out.println(teacher.getName());
        //teacher.teach();
        if(teacher instanceof Teacher){
            Teacher teacher2 = (Teacher)teacher;
            System.out.println(teacher2.name);
            teacher2.teach();
        }
        teacher.walk();
        */
        /*
        Bank bank = new Bank();
        YoungMan youngMan = new YoungMan();
        OldMan oldMan = new OldMan();
        RichMan richMan = new RichMan();

        bank.acceptBusiness(youngMan);
        bank.acceptBusiness(oldMan);
        bank.acceptBusiness(richMan);
        */
        /*
        InnerClass innerClass = new InnerClass();
        
        innerClass.innerClassFun();
        innerClass.unamedInnerTest();
        ItemInnerClass itemInnerClass = innerClass.new ItemInnerClass();
        itemInnerClass.innerClassFun();
        */

        MyEnum[] myEnum = MyEnum.values();
        for (MyEnum myEnum2 : myEnum) {
            System.out.println(myEnum2.name());
        }

        MyEnum me = MyEnum.valueOf("E1");

        switch(me){
            case E1:
                System.out.println("get E1");
                break;
            case E2:
                System.out.println("get E2");
                break;
            case E3:
                System.out.println("get E3");
                break;
            default:
                System.out.println("error");
                break;
            
        }

        Runtime rt = Runtime.getRuntime();
        System.out.println(rt.maxMemory());
        System.out.println(rt.totalMemory());
        System.out.println(rt.freeMemory());
        System.out.println(rt.toString());
    }
}