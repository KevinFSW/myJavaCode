package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestMain {

    public static void main(String[] args) {
        Class<?> clazz = AnnotationTest.class;
        Method[] method = clazz.getMethods();
        for (Method method2 : method) {
            Annotation[] a = method2.getAnnotations();
            if(a != null){
                for (Annotation annotation : a) {
                    System.out.println(annotation.getClass().getName());
                    Method[] ms = annotation.getClass().getMethods();
                    for (Method method3 : ms) {
                        try {
                            if(method3.getReturnType().getSimpleName().equals("String[]")){
                                String[] sts = (String[])method3.invoke(annotation);
                                for (String str : sts) {
                                    System.out.println(str);
                                }
                            }
                            else{
                                System.out.println("    " + method3.getReturnType().getSimpleName() + " " + method3.getName());
                            }
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}