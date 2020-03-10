package tool.stringclass;

public class BuilderTest{
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("0123456789");
        System.out.println(builder.capacity());
        System.out.println(builder.length());
        builder.append("9876543210", 2, 9);//把9876543210的第二位到第八位追加到builder后面
        System.out.println(builder.capacity());
        System.out.println(builder.length());
        System.out.println(builder);
        builder.delete(0, 1);//把第0位删除
        builder.deleteCharAt(1);
        builder.reverse();
        System.out.println(builder);
        builder.insert(2, "w");//把w插入到第二个位置
        System.out.println(builder);
        builder.replace(3, 5, "w");//把第三第四位这两个字符换成一个w
        System.out.println(builder);
        builder.setCharAt(0, 'o');//把第0位改成o
        System.out.println(builder);
        System.out.println(builder.capacity());
        System.out.println(builder.length());
        builder.trimToSize();//把capacity() trim 到 length()
        System.out.println(builder.capacity());
        System.out.println(builder.length());        
        builder.substring(7);
    }
}