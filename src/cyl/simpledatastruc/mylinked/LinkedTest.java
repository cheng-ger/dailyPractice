package cyl.simpledatastruc.mylinked;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-06-04
 */
public class LinkedTest {


    public static void main(String[] args) {


        MylinkedList mylinkedList = new MylinkedList();

        mylinkedList.addLast("0");
        mylinkedList.addLast("1");
        mylinkedList.addLast("2");
        mylinkedList.displayAll();
        System.out.println(String.format("双向链表length：%s",mylinkedList.getLength()));


        System.out.println("<<<<<<<<<=====================>>>>>>>>>>>>>>>>");
        mylinkedList.add(1, "0.5");
        mylinkedList.displayAll();

        System.out.println(mylinkedList.find("0.5") +"\t"+ mylinkedList.getNode(1)+ ""+ mylinkedList.getValue(1));

        System.out.println("<<<<<<<<<=====================>>>>>>>>>>>>>>>>");
        mylinkedList.delete(1);
        mylinkedList.displayAll();
        System.out.println(String.format("双向链表length：%s",mylinkedList.getLength()));
    }
}
