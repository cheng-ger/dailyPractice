package cyl.simpledatastruc.mylinked;



import java.util.NoSuchElementException;

/**
 * @author chengyuanliang
 * @desc  双向链表结构
 *
 * @since 2019-06-03
 */
public class MylinkedList<T> {

    /*成员变量*/
    //链头
    private Node<T> first;
    //链尾
    private Node<T> last;
    //链表长度
    private int length;

    /*<<<<<<<<<<<<<<<<<============================>>>>>>>>>>>>>>>>>>>>>*/

    //链表节点 内部类
    private  static  class Node<T>{

        //前一个节点
        private Node<T> perv;
        //后一个节点
        private Node<T> next;
        //当前节点值
        private T value;

        public Node(Node perv, T value ,Node next ) {
            this.perv = perv;
            this.next = next;
            this.value = value;
        }
    }


    public MylinkedList() {

        length = 0;

        first = null;

        last = null;

    }

    public int  getLength(){
        return length;
    }

    /*添加头节点*/
    public void  addFirst(T value){
        Node<T> f = first;
        Node<T> addNode = new Node<>(null, value, f);

        first = addNode;

        if(f == null){
            last = addNode;
        }else {
            f.perv = addNode;
        }
        length++;
    }


    /*添加尾节点*/
    public void addLast(T value) {

        Node<T> l = last;

        Node<T> addNode = new Node<>(l, value, null);

        last = addNode;

        if (l == null) {
            first = addNode;
        } else {
            l.next = addNode;
        }
        length++;
    }

    /*根据下标 添加数据*/
    public void  add(int index , T value) {

        if(index < 0 || index > length ) throw new IndexOutOfBoundsException("下标越界");

        if(index == 0) addFirst(value);
        else if(index == length ) addLast(value);
        else {

            Node<T> indexNode = getNode(index);

            Node<T> prevNode = indexNode.perv;

            Node addNode = new Node(prevNode, value, indexNode);

            prevNode.next = addNode;

            indexNode.perv = addNode;
            length++;

        }
    }

    /*public T getFirst() {
        final Node<T> f = first;
        if (f == null)
            throw new NoSuchElementException("无元素");
        return f.value;
    }

    public T getLast() {
        final Node<T> l = last;
        if (l == null)
            throw new NoSuchElementException("无元素");
        return l.value;
    }*/

    /*获取节点头*/
    public Node<T> getFirstNode() {
        final Node<T> f = first;
        if (f == null)
            throw new NoSuchElementException("无元素");
        return f;
    }

    /*获取节点尾*/
    public Node<T> getLastNode() {
        final Node<T> l = last;
        if (l == null)
            throw new NoSuchElementException("无元素");
        return l;
    }

    /*获取节点 根据下标*/
    public  Node<T> getNode(int index){
        if(length == 0 ) throw new NoSuchElementException("无元素");
        if(index < 0 || index > length -1) throw new IndexOutOfBoundsException("超出范围");
        if(index == 0) getFirstNode();
        else if(index == length - 1) getLastNode();
        else {
            int mid = (length - 1) >> 1;
            Node<T> currentNode ;
            int i ;
            if(mid > index){

                for (i = 0, currentNode = first; i < index; i++, currentNode = currentNode.next) {

                }
            }else{
                for ( i = 0 ,currentNode = last; i < length -index -1 ; i++,currentNode = currentNode.perv){

                }
            }
            return currentNode;
        }


        return null;
    }


    /*获取节点值 根据下标*/
    public  T getValue(int index) {

        return getNode(index).value;

    }

    /*寻找值  返回下标*/
    public  int find(T value) {

        int index = -1;

        int i;

        Node<T> currentNode;

        for (i = 0,currentNode= first; currentNode != null  ; i++,currentNode = currentNode.next) {

            if(value.equals(currentNode.value)){
                index = i;
            }

        }


        return index;
    }


    public  void  delete(T Value) {

    }

    /*删除头部节点*/
    public void deleteFirstNode(){
        Node<T> f = first;
        if(f == null) throw new NoSuchElementException("无元素");
        Node<T> fNode = first.next;
        first = fNode;
        if(fNode == null) {
            last = null;
        }else {
            fNode.perv = null;
        }
        length--;
    }


    /*删除尾部节点*/
    public void deleteLastNode(){
        Node<T> l =last ;
        if(l == null) throw new NoSuchElementException("无元素");
        Node<T> lNode = last.perv;
        last = lNode;
        if(lNode == null){
            first = null;
        }else {
            last.next = null;
        }
        length--;
    }

    /*删除下标节点*/
    public void delete(int index){
        if(index < 0 || index > length -1) throw new IndexOutOfBoundsException("下标越界");

        if(index == 0) deleteFirstNode();

        else if(index == length - 1) deleteLastNode();

        else {
            Node<T> deleteNode = getNode(index);

            Node<T> prevNode = deleteNode.perv;

            Node<T> nextNode = deleteNode.next;

            prevNode.next = nextNode;
            nextNode.perv = prevNode;

            /*deleteNode.perv.next = deleteNode.next;

            deleteNode.next.perv = deleteNode.perv;*/

            deleteNode = null;
            length--;

        }
    }

    /*获取所有值*/
    public  void displayAll(){
        Node currentNode;
        for (  currentNode= first ; currentNode != null ;currentNode = currentNode.next ) {
            System.out.println(currentNode.value);
        }
    }

    /*根据下标修改值*/
    public  void modify(int index , T value){
        Node<T> currentNode = getNode(index);
        currentNode.value = value;

    }

}
