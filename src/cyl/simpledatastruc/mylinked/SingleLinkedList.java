package cyl.simpledatastruc.mylinked;

/**
 * @author chengyuanliang
 * @desc 单向链表
 * @since 2019-06-04
 */
public class SingleLinkedList<T> {
    /*成员变量*/

    private Node<T> first;

    private int length;



    //类部类
    private static class Node<T> {

         private T value;


        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }


    /*初始化构造器*/

    public SingleLinkedList() {

        length = 0;

        first = null;
    }



    //单链比双链  简单   仿照着 MylinkedList 就行

    //todo method
}
