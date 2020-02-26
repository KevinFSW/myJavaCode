package app.arraybox;

/**
 * 设计一个数组容器，能够不限定长度，能添加，删除，取出元素，能查询有效元素的个数
 */
public class IntArrayBox{
    /**
     * 属性：一个真实的数组
     */
    private int[] intArray;

    /**
     * 属性：ArrayBox的有效长度
     */
    private int size = 0;

    /**
     * 构造方法
     */
    public IntArrayBox(){
        this.size = 0;
    }

//======================================================================

    /**
     * 方法：往ArrayBox里面添加元素
     * @param element
     */
    public void add(int element){
        int size = this.size + 1;//长度加1

        int[] newArray = new int[size];//创建新的数组

        if(this.size > 0){
            for (int i = 0; i < this.size; i++) {
                newArray[i] = this.intArray[i];//复制原有元素到新数组
            }
        }

        newArray[size - 1] = element;//添加元素到新数组
        this.intArray = newArray;//把新数组的引用赋给intArray
        this.size = size;//更新size
        newArray = null;
    }

//======================================================================

    /**
     * 方法：从ArrayBox里面删除指定索引的元素
     * @param index
     */
    public void remove(int index){
        if(this.size == 0){
            System.out.println("数组里面没有元素！");
            return;
        }

        int size = this.size - 1;//长度减1
        int[] newArray = new int[size];//创建新的数组

        int newIndex = 0;//用于记录新数组的索引

        for (int i = 0; i < this.size; i++) {
            if(i != index){
                newArray[newIndex++] = this.intArray[i];//非index索引的元素保留
            }
        }

        this.intArray = newArray;//把新数组的引用赋给intArray
        this.size = size;//更新size
        newArray = null;
    }

//======================================================================

    /**
     * 方法：获取ArrayBox指定索引的值
     * @param index
     * @return ArrayBox指定索引的值
     */
    public int get(int index){
        return this.intArray[index];//直接从intArray通过索引拿元素
    }

//======================================================================

    /**
     * 方法：获取ArrayBox的长度
     * @return ArrayBox的长度
     */
    public int size(){
        return this.size;
    }

    //测试看看
    public static void main(String[] args) {
        IntArrayBox arrayBox = new IntArrayBox();

        for (int i = 0; i < 10; i++) {
            arrayBox.add(i);
            System.out.println("size:" + arrayBox.size());
        }

        for (int i = 0; i < arrayBox.size(); i++) {
            System.out.println("element:" + arrayBox.get(i));
        }

        arrayBox.remove(7);
        System.out.println("size:" + arrayBox.size());

        for (int i = 0; i < arrayBox.size(); i++) {
            System.out.println("element:" + arrayBox.get(i));
        }

        for (int i = 0; i < 10; i++) {
            arrayBox.add(i);
            System.out.println("size:" + arrayBox.size());
        }

        for (int i = 0; i < arrayBox.size(); i++) {
            System.out.println("element:" + arrayBox.get(i));
        }

    }

}