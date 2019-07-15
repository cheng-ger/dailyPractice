package cyl.simpledatastruc.mysort;

import java.util.*;

/**
 * @author chengyuanliang
 * @desc  排序
 *         选择排序、插入排序、冒泡排序、归并排序、快速排序、希尔排序、堆排序、
 *
 * 　　　　最后对各种排序算法进行比较，理清楚各种排序的优缺点。　　
 *
 * 　　　　其中快速排序是冒泡排序的增强，堆排序是对选择排序的增强，希尔排序是对插入排序的增强，
 *
 *         这就6种了，最后一种就是归并排序。
 * @since 2019-06-05
 */
public class MySort {


    public static void main(String[] args) {
        int[] intArray = {1,6,4,59,6,10};
        //bubbleSort(intArray);
        //selectSort(intArray);
        //insertSort(intArray);
        shellSort(intArray);
        display(intArray);

        /*h = key.hashCode()) ^ (h >>> 16*/
       // Map m = new HashMap();
    }


    public  static  void display(int[] intArray){

        for (int i = 0; i < intArray.length; i++) {

            System.out.println(intArray[i]);

        }
    }

    /*冒泡排序*/
    //假设从小到大排序，对于给定的n个记录，从第一个记录开始依次对相邻的两个记录进行比较，当前面的记录大于后面的记录时，
    // 交换位置，进行一轮比较后，第n位上就是整个记录中最大的数，然后在对前n-1个记录进行第二轮比较，
    // 重复该过程直到进行比较的记录只剩下一个为止
    public  static void bubbleSort(int[] intArray){

        int temp;
        for (int i = 0; i < intArray.length -1  ; i++) {//外层循环：每循环一次就确定了一个相对最大元素

            for (int j = i + 1 ; j < intArray.length ; j++) {
                if(intArray[i] > intArray[j]){
                    temp = intArray[j];
                    intArray[j] = intArray[i];
                    intArray[i] = temp;
                }
            }
        }
    }

    /*选择排序*/
    //从第一个元素开始，扫描整个待排数组，找到最小的元素放之后再与第一个元素交换位置，然后再从第二个元素开始，
    // 继续寻找最小的元素与第二个元素交换位置
    public  static  void selectSort(int[] intArray){

        int minIndex;

        int temp ;

        for (int i = 0; i < intArray.length -1 ; i++) {
            minIndex = i;
            for (int j = i; j < intArray.length; j++) {
                if(intArray[minIndex] > intArray[j]){
                    minIndex = j;
                }
            }

            if(minIndex != i){
                temp = intArray[i];

                intArray[i] = intArray[minIndex];

                intArray[minIndex] = temp;

            }
        }
    }

    /*插入排序*/
    //在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排好顺序的，现在要把第n个数找到相应位置并插入，
    // 使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
    public static void insertSort(int[] intArray){
        //int minIndex;
        int j;
        int temp;

        for (int i = 1; i < intArray.length; i++) {
            temp = intArray[i];
            for (j = 0 /*, minIndex = -1*/; j < i; j++) {
                if (intArray[i] < intArray[j] ) {
                    /*minIndex++;*/
                    intArray[i] = intArray[j];
                    intArray[j] = temp;
                }
            }
        }
    }

    /*归并排序*/
    public static void mergeSort(){

    }

    /*归并排序--递归*/
    public static void mergeRecSort(){

    }

    /*快速排序*/
    // 　快速排序是对冒泡排序的增强，增强得点在于：冒泡排序中，记录的比较和移动是在相邻两个位置进行的，
    // 记录每次交换只能后移一个位置，因而总的比较次数和移动次数较多，而快排记录的比较和移动是从两端向中间进行的，
    // 较大的记录一次就能从前面移动到后面，较小的记录一次就能从后面移动到前面，这样就减少了比较次数和移动次数
    //
    // 快速排序原理：选取一个轴值(比较的基准)，将待排序记录分为独立的两个部分，左侧记录都是小于或等于轴值，
    // 右侧记录都是大于或等于轴值，然后分别对左侧部分和右侧部分重复前面的过程，也就是左侧部分又选择一个轴值，
    // 又分为两个独立的部分，这就使用了递归了。到最后，整个序列就变得有序了
    //轴值的选择有三种：
    //
    //　　　　　　1、选取序列的第一个位置上的记录
    //
    //　　　　　　2、选择序列的中间位置上的记录
    //
    //　　　　　　3、将序列第一个位置 和 中间位置 和 末尾位置上的记录进行比较，选择大小居中的记录，
    public static void quickSort(int[] intArray,int left, int right){

        if(left < right){
            int baseIndex = partiton(intArray,left,right);

            quickSort(intArray, left, baseIndex - 1);
            quickSort(intArray, baseIndex + 1, right);
        }
    }

    private static int  partiton(int[] intArray , int left , int right) {
       /* int left = 0;
        int right = intArray.length - 1;*/

        int baseNum = intArray[left];
        while (left <  right) {

           while(intArray[right] >= baseNum && left <  right ) right--;

            intArray[left] = intArray[right];

           while(intArray[left] <= baseNum && left <  right) left++;

            intArray[right] = intArray[left];

        }
        intArray[left] = baseNum;
        return left;
    }



    /*快速排序-非递归*/
    public static void quickRecSort(int[] a, int start, int end){
        // 用栈模拟
        Stack<Integer> stack = new Stack<>();
        if (start < end) {
            stack.push(end);/*压进栈  栈的特点：FILO 先进后出*/
            stack.push(start);
            while (!stack.isEmpty()) {
                int l = stack.pop();
                int r = stack.pop();
                int index = partitionB(a, l, r);
                if (l < index - 1) {
                    stack.push(index - 1);
                    stack.push(l);
                }
                if (r > index + 1) {
                    stack.push(r);
                    stack.push(index + 1);
                }
            }
        }
    }


    void quicksortC(int[] inArray,int left,int right){
        if(left<right){
            int temp,i=left,j=right;
            temp=inArray[right];
            while(i<j){
                //寻找左边第一个大于基准值的下标
                while(inArray[i]<=temp&&i<j)   i++;

                if(i<j)inArray[j--]=inArray[i];

                //寻找右边第一个小于基准值的下标
                while(inArray[j]>=temp&&i<j)  j--;

                if(i<j)inArray[i++]=inArray[j];
            }
            inArray[i]=temp;
            quicksortC(inArray,left,i-1);      //递归左边部分数组
            quicksortC(inArray,i+1,right);     //递归右边部分数组
        }
    }


    void quickSortCC(int[] s,int left,int right){
        LinkedHashMap<Integer,Integer> lhp=new LinkedHashMap<>();
        //将0,n放入LinkedHashMap
        lhp.put(left,right);
        while(!lhp.isEmpty()){      //只要有需要排序的段
            //读取left，right
            Iterator<Map.Entry<Integer,Integer>> it=lhp.entrySet().iterator();
            left=it.next().getKey();
            right=lhp.get(left);
            //并从LinkedHashMap中删除
            lhp.remove(left,right);
            if(left>=right)continue;
            int i=left,j=right,temp=s[right];
            while(i<j){         //遍历排序一遍
                while(s[i]<=temp&&i<j)i++;
                if(i<j)s[j--]=s[i];
                while(s[j]>=temp&&i<j)j--;
                if(i<j)s[i++]=s[j];
            }
            s[i]=temp;
            lhp.put(left,i-1);
            lhp.put(i+1,right);
        }
    }

    private static int PartitionA(int[] arr, int start, int end) {
        //arr[start]为挖的第一个坑
        int key = arr[start];
        while (start < end) {
            while (arr[end] >= key && end > start)
                end--;
            arr[start] = arr[end];
            while (arr[start] <= key && end > start)
                start++;
            arr[end] = arr[start];
        }
        arr[start] = key;
        return start;
    }

    public static void quickSortA(int[] arr, int start, int end) {
        if (start < end) {
            int index = PartitionA(arr, start, end);
            quickSortA(arr, start, index - 1);
            quickSortA(arr, index + 1, end);
        }
    }



    // start和end为前闭后闭
    private static void nonRec_quickSort(int[] a, int start, int end) {
        // 用栈模拟
        Stack<Integer> stack = new Stack<>();
        if (start < end) {
            stack.push(end);
            stack.push(start);
            while (!stack.isEmpty()) {
                int l = stack.pop();
                int r = stack.pop();
                int index = partitionB(a, l, r);
                if (l < index - 1) {
                    stack.push(index - 1);
                    stack.push(l);
                }
                if (r > index + 1) {
                    stack.push(r);
                    stack.push(index + 1);
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
    private static int partitionB(int[] a, int start, int end) {
        int pivot = a[start];
        while (start < end) {
            while (start < end && a[end] >= pivot)
                end--;
            a[start] = a[end];
            while (start < end && a[start] <= pivot)
                start++;
            a[end] = a[start];
        }
        a[start] = pivot;
        return start;
    }


    /*希尔排序*/
    //数列以逆向的形式从1开始，通过递归表达式：
    //这种序列生成方法是由Donald Knuth(可以百度一下，图灵奖获得者，一位计算机领域的大牛)提出来的。
    //h=3*h+1
    //来产生后面的间隔。
    //希尔排序其实是插入排序的升级版本，本质上进行的也是插入排序的操作，但是希尔排序并不是把一组记录看成一个整体，
    // 而将整个记录分为了若干组记录，然后在对每组记录进行插入排序，
    //
    //　　分组规则为如下所示：假设有 1 2 3 4 5  6 7 8 9 10 十个位置(每个位置上都会放数，这里忽略数，只讨论位置)。
    //      (省略了插入排序操作，只对如何分组进行讲解，而完整的希尔排序就是在每次分组完之后进行插入排序操作即可)
    //
    //　　步长为：5、3、1
    //
    //　　第一次分为5组记录(组数跟步长是一样的)：1,6 、2,7、3,8、 4,9、 5,10 这五组记录，分别对这五组记录进行插入排序。
    //
    //　　第二次分为3组记录：1,4,7,10、2,5,8、3,6,9 这三组记录，分别对这三组记录进行插入排序
    //
    //　　第三次分为1组记录：1 2 3 4 5 6  7 8 9 10， 为这组记录进行插入排序，
    //
    //　　　　　　 而步长只要满足最后一次为1，并且是从大到小即可。一般使用(数组长度/2) 或者 (数组长度/3 +1) 来代表步长。
    //
    //　　　　这样做的好处是：
    //
    //　　　　　　　　　　将待排序的数组元素分成多组，每组中记录数相对较少
    //
    //　　　　　　　　　　经过前几次的排序后，整个序列变为了“基本有序序列”，最后在对所有元素进行一次直接插入排序。
    //
    //　　　　　　直接插入排序对基本有序和记录数少的序列的效率是非常高的，而希尔排序就是利用了这两点。
    public static void shellSort(int[] intArray){

        int step = 1;
        int len = intArray.length;
        while (3 * step + 1 < len) {  //确定第一轮排序时的间隔  也可以 length/2
            step = 3 * step + 1;
        }


        int temp;


        while (step > 0){

            for (int i = step; i < len; i++) {
                temp = intArray[i];
                int j;
                for( j= i; j > step -1 && temp <= intArray[j-step]; j-=step) {
                    intArray[j] = intArray[j-step];
                }
                intArray[j] = temp;
            }

            step = (step - 1) / 3;

        }

    }


    /*堆排序*/
    public static void heapSort() {

    }


    //3*h+1
    public static void a(Integer h) {


        if (h < 1000) {
            System.out.println(h);
            a(h * 3 + 1);

        }
    }
}
