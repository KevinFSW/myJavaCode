package app.modifier;

public class SingleTon{
    //private static SingleTon single = new SingleTon();//定义就创建对象，饿汉模式
    private static SingleTon single;//这里不创建
    private SingleTon(){

    }

    public static SingleTon getSingle(){
        if(single == null){
            single = new SingleTon();//调用才创建，懒汉模式
        }
        return single;
    }
}