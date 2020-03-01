package app.modifier;

public final class Modifier {
    private final int point;
    protected String[] content = {
        "public         公共的    本类  同包  子类（同一工程任何地方）",
        "protected      受保护的  本类  同包  子类（通过子类在子类内部访问）",
        "默认不写        默认的    本类  同包  ",
        "private        私有的    本类  ",
    };

    {
        this.point = 0;//没有初始化的final属性，只能在程序块中赋值？？？？
    }

    public final boolean setPoint(int point){
        if(point < this.content.length){
            //this.point = point; //没有初始化的final属性，只能在程序块中赋值？？？？
            return true;
        }

        final int test;
        test = point;
        //test = point;

        return false;
    }

    public final int getPoint(){
        return this.point;
    }

    public String getContent(){
        return this.content[this.point];
    }

    public void setContent(String ct){
        this.content[this.point] = ct;
    }

}