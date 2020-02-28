/**
 * Edit and run with VSCode, default encoding: UTF-8
 */
package app.arraybox;

import app.exception.*;

/**
 * 设计一个数组容器，能够不限定长度，能添加，删除，取出元素，能查询有效元素的个数
 */
public class ArrayBox<E>{
    /**
     * 常量：默认的初始化长度
     */
    private static final int DEFAULT_INIT_CAPACITY = 10;

    /**
     * 属性：一个真实的数组
     */
    private Object[] array;

    /**
     * 属性：ArrayBox的有效长度
     */
    private int size = 0;

    /**
     * 构造方法
     */
    public ArrayBox() {
        this.size = 0;
        this.array = new Object[DEFAULT_INIT_CAPACITY];
    }

    /**
     * 构造方法重载
     * @param initSize 初始化一个长度
     */
    public ArrayBox(int initSize) {
        if(initSize < 0){
            throw new ArrayBoxNegativeSizeException("initSize:" + initSize);
        }
        this.size = 0;
        this.array = new Object[initSize];
    }

    /**
     * 索引范围检查
     * @param index 需要检查的索引
     */
    private void rangeCheck(int index){
        if(index >= this.size || index < 0){
            throw new ArrayBoxIndexOutOfBoundsException("index:" + index + ", size:" + this.size);
        }
    }

    /**
     * ArrayBox容量检查
     * @param need 需要的容量
     */
    private void capacityCheck(int need){
        if (need > this.array.length) {
            int needSize = need - this.array.length + 2 * this.array.length;
            this.expandCapacity(needSize);
        }
    }

    /**
     * 扩大容量
     * @param need 需要扩大到这个容量
     */
    private void expandCapacity(int need){
        Object[] newArray = new Object[need];//创建新的数组

        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.array[i];//复制原有元素到新数组
        }
        System.out.println("expandCapacity: " + this.array.length + " ==> " + newArray.length);
        this.array = newArray;//把新数组的引用赋给intArray
        newArray = null;
    }

//======================================================================

    /**
     * 方法：往ArrayBox里面添加元素
     * @param element
     */
    public boolean add(E element){
        int size = this.size + 1;//长度加1
        this.capacityCheck(size);//检查容量
        array[this.size++] = element;//添加元素
        return true;
    }

//======================================================================

    /**
     * 方法：从ArrayBox里面删除指定索引的元素
     * @param index
     */
    public E remove(int index){
        rangeCheck(index);

        E oldValue = (E) this.array[index];

        for (int i = index; i < this.size - 1; i++) {
            this.array[i] = this.array[i+1];//非index索引的元素保留
        }

        this.array[--this.size] = null;//长度减一，同时清空末尾的元素

        return oldValue;
    }

//======================================================================

    /**
     * 方法：获取ArrayBox指定索引的值
     * @param index
     * @return ArrayBox指定索引的值
     */
    public E get(int index){
        rangeCheck(index);
        return (E) this.array[index];//直接从intArray通过索引拿元素
    }

//======================================================================

    /**
     * 方法：获取ArrayBox的长度
     * @return ArrayBox的长度
     */
    public int size(){
        return this.size;
    }

}