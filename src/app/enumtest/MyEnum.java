package app.enumtest;

public enum MyEnum{
    E1("MyEnum"), E2, E3;//分号表示枚举结束

    //可以添加自己的属性和方法，构造方法只能是私有的
    private String name;

    private MyEnum(){}

    private MyEnum(String name){
        this.name = name;
    }

    public final String getName(){
        return this.name;
    }
}