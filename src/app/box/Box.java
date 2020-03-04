package app.box;

public interface Box<E>{
//======================================================================

    /**
     * 方法：往Box里面添加元素
     * @param element
     */
    public boolean add(E element);

//======================================================================

    /**
     * 方法：从Box里面删除指定索引的元素
     * @param index
     */
    public E remove(int index);

//======================================================================

    /**
     * 方法：获取Box指定索引的值
     * @param index
     * @return Box指定索引的值
     */
    public E get(int index);

//======================================================================

    /**
     * 方法：获取Box的长度
     * @return Box的长度
     */
    public int size();
}