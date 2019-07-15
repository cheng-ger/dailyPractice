package cyl;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chengyuanliang
 * @desc  此工程主要是用作平常的practice
 *        这里主要模仿源码的数据结构用
 * @since 2019-03-31
 */
public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("hello，world ！》》》》这个是用IDEA搭建的第一个普通项目");
        List objectArrayList =  Arrays.asList( "a", "b" , (3 >> 1));
        int[] aInt = new int[4];
        System.out.println(aInt.length);
        System.out.println((1 << 4) + "+:"  + (3 >> 1) + "+:" +  (3/2)  + "+:"  + (0 >> 1));

        LinkedList l = new LinkedList();


        String str = "0123456789";
        System.out.println(str.substring(1));//默认从当前到最后idx
    }
}
