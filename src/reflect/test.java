package reflect;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test {

    public static void main(String[] args) {
        File file = new File("./src/reflect/test.txt");
        if (file.exists() == false) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter(file));
                bw.write("123,str");
                bw.flush();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                if(bw != null){
                    try {
                        bw.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
        MySpring mySpring = new MySpring(file);
        @SuppressWarnings("unused")
        ObjectForTest objectForTest = (ObjectForTest)mySpring.getBeanObject("reflect.ObjectForTest");
        for(int i = 0; i < 10; i++){
            if(mySpring.getBeanObject("reflect.ObjectForTest") == null){
                System.out.println("null");
            }
        }
/*
        try {
            Class clazz = Class.forName("reflect.Person");
            System.out.println(clazz.getModifiers());
            System.out.println(clazz.getPackageName());
            System.out.println(clazz.getName());
            System.out.println(clazz.getSimpleName());
            Package p = clazz.getPackage();
            System.out.println(p.getName());
            System.out.println(clazz.getSuperclass().getName());
            Class[] classes = clazz.getInterfaces();
            for (Class class1 : classes) {
                System.out.println(class1.getModifiers());
                System.out.println(class1.getPackageName());
                System.out.println(class1.getName());
                System.out.println(class1.getSimpleName());
                p = class1.getPackage();
                System.out.println(p.getName());
            }
            try {
                // Field field = clazz.getField("name");//只能获取公有属性（包括继承自父类的）
                // System.out.println(field.getName());
                Field[] fields = clazz.getFields();//只能获取公有属性（包括继承自父类的）
                for (Field field2 : fields) {
                    System.out.print(field2.getType().getSimpleName() + '\t');
                    System.out.println(field2.getName());
                }
                Person person = (Person)clazz.newInstance();
                clazz = person.getClass();
                Field dField = clazz.getDeclaredField("money");
                System.out.println(dField.getName());
                dField.setAccessible(true);
                System.out.println(dField.get(person));
                dField.set(person, 10);
                System.out.println(dField.get(person));
                Method method = clazz.getMethod("personEat", String.class); //只能获取公有方法
                System.out.println(method.getName());
                System.out.println(method.getReturnType().getName());
                Class[] type = method.getParameterTypes();
                for (Class class1 : type) {
                    System.out.println(class1.getName());
                }
                System.out.println(method.getModifiers());
                try {
                    method.invoke(person, "food");
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Method privateMethod = clazz.getDeclaredMethod("personSleep", String.class);
                Method[] privateMethods = clazz.getDeclaredMethods();
                for (Method method2 : privateMethods) {
                    //method2.setAccessible(true);
                    System.out.println(method2.getName());
                    if(method2.getName().equals("personSleep"))
                    {
                        try {
                            method2.setAccessible(true);
                            method2.invoke(person, "sleep");
                        } catch (InvocationTargetException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }

                Constructor constructor = clazz.getConstructor();
                try {
                    Person person2 = (Person) constructor.newInstance();
                    person2.personEat();
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } catch (SecurityException | NoSuchFieldException | IllegalArgumentException | IllegalAccessException
                    | InstantiationException | NoSuchMethodException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
*/    
    }

}