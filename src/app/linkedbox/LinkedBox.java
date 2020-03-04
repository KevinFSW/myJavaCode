package app.linkedbox;

import app.box.Box;
import app.exception.BoxIndexOutOfBoundsException;

public class LinkedBox<E> implements Box<E> {
    /**
     * 存储首节点
     */
    private Node<E> first;

    /**
     * 存储尾节点
     */
    private Node<E> last;

    /**
     * 存储有效数据长度
     */
    private int size;

    /**
     * 构造方法
     */
    public LinkedBox(){
        this.first = new Node<E>();//创建头尾节点
        this.last = new Node<E>();
        this.first.setNext(this.last);
        this.last.setPrev(this.first);
        this.size = 0;
    }

    /**
     * 索引范围检查
     * @param index 需要检查的索引
     */
    private void rangeCheck(int index){
        if(index >= this.size || index < 0){
            throw new BoxIndexOutOfBoundsException("index:" + index + ", size:" + this.size);
        }
    }

    /**
     * 根据索引获取节点
     * @param index
     * @return 返回获取到的节点
     */
    private Node<E> getNode(int index){
        Node<E> tempNode;

        //判断范围查找，节约时间
        if(index <= this.size/2){
            tempNode = this.first;
            for (int i = 0; i < index; i++) {
                tempNode = tempNode.getNext();
            }
        }
        else{
            tempNode = this.last;
            for (int i = this.size - 1; i > index; i--) {
                tempNode = tempNode.getPrev();
            }
        }

        return tempNode;
    }

    @Override
    public boolean add(E element) {
        // TODO Auto-generated method stub
        //第一和第二个元素的空间已经创建好了（就是first和last），直接填进去就可以了
        if(this.size == 0){
            this.first.setItem(element);
        }
        else if(this.size == 1){
            this.last.setItem(element);
        }
        else{
            //插到末尾
            Node<E> addTarget = new Node<E>(this.last, null, element);
            this.last.setNext(addTarget);
            this.last = addTarget;
        }

        this.size++;

        return true;
    }

    @Override
    public E remove(int index) {
        // TODO Auto-generated method stub
        this.rangeCheck(index);
        Node<E> tempNode = this.getNode(index);

        //找到的节点是首尾节点，特殊处理一下
        if(tempNode == this.first){
            this.first = this.first.getNext();
            this.first.setPrev(null);
        }
        else if(tempNode == this.last){
            this.last = this.last.getPrev();
            this.last.setNext(null);
        }
        else{
            tempNode.getPrev().setNext(tempNode.getNext());
            tempNode.getNext().setPrev(tempNode.getPrev());
        }

        E removeValue = tempNode.getItem();
        tempNode = null;
        this.size--;

        return removeValue;
    }

    @Override
    public E get(int index) {
        // TODO Auto-generated method stub
        this.rangeCheck(index);

        return this.getNode(index).getItem();
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return this.size;
    }
    
}