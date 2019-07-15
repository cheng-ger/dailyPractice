package cyl.simpledatastruc.myarray;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-04-01
 */
public class MyArrayTest {


    public static void main(String[] args) {

        MyArray myArray = new MyArray(10);

        System.out.println( "数组的初始长度："+ myArray.length);

        myArray.add(0);
        myArray.add(2);
        myArray.add(1, 1);
        System.out.println("查看所有有效元素：" + myArray.length);
        myArray.displayAll();
        System.out.println("<<<=============================>>>");
        System.out.println("判断是否含有此值（返回下标）" + myArray.find(1));
        System.out.println("判断是否含有此值（返回下标）" + myArray.find(0));
        System.out.println("<<<=============================>>>");
        System.out.println("获取下标数据："+myArray.get(0));
        System.out.println("<<<=============================>>>");
        myArray.add(3);
        //myArray.delete(1);
        System.out.println(myArray.length +"判断是否含有此值（返回下标）" + myArray.find(3));
        myArray.displayAll();
        System.out.println("<<<=============================>>>");
        System.out.println(myArray.modifyByValue(1, 11));
        System.out.println("判断是否含有此值（返回下标）" + myArray.find(11));
    }
}
