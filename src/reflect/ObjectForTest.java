package reflect;

public class ObjectForTest {
    public ObjectForTest(){
        System.out.println("我是无参数的构造方法");
    }

    public ObjectForTest(Integer i){
        System.out.println("我是有参数的构造方法1：" + i);
    }

    public ObjectForTest(Integer i, String str){
        System.out.println("我是有参数的构造方法2：" + i + "," + str);
    }
}