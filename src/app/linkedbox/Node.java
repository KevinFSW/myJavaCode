package app.linkedbox;

public class Node<E>{
    private Node<E> prev;
    private Node<E> next;
    private E item;

    public Node(){
        this.prev = null;
        this.next = null;
        this.item = null;
    }

    public Node(Node<E> prev, Node<E> next, E item){
        this.prev = prev;
        this.next = next;
        this.item = item;
    }

    public Node<E> getPrev(){
        return this.prev;
    }

    public Node<E> getNext(){
        return this.next;
    }

    public E getItem(){
        return this.item;
    }

    public void setPrev(Node<E> prev){
        this.prev = prev;
    }

    public void setNext(Node<E> next){
        this.next = next;
    }

    public void setItem(E item){
        this.item = item;
    }

}