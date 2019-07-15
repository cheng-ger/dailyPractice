package cyl.simpledatastruc.myarray;

import java.util.Arrays;

/**
 * @author chengyuanliang
 * @desc  此处是对数组的应用
 * @since 2019-03-31
 */


/*数组是应用最广泛的一种数据结构（其实数组就是一段连续的内存，即使在物理内存中不是连续的，在逻辑上肯定是连续的）
   数据结构的鼻祖——数组，可以说数组几乎能表示一切的数据结构
   在每一门编程语言中，数组都是重要的数据结构，当然每种语言对数组的实现和处理也不相同，但是本质是都是用来存放数据的的结构，
   在Java中，数组是用来存放同一种数据类型的集合，注意只能存放同一种数据类型(Object类型数组除外)。
   数据的声明方式有两种：
     //声明数组1,声明一个长度为3，只能存放int类型的数据
        int [] myArray = new int[3];
    //声明数组2,声明一个数组元素为 1,2,3的int类型数组
    int [] myArray2 = {1,2,3};
    自带length属性（成员变量）

    自带的基本功能有：
        ①、如何插入一条新的数据项

    　　②、如何寻找某一特定的数据项

    　　③、如何删除某一特定的数据项

    　　④、如何迭代的访问各个数据项，以便进行显示或其他操作

      ps:假设操作人是不会添加重复元素的，这里没有考虑重复元素，

         如果添加重复元素了，后面的查找，删除，修改等操作只会对第一次出现的元素有效。

      通过上面的代码，我们发现数组是能完成一个数据结构所有的功能的，而且实现起来也不难，那数据既然能完成所有的工作，

      我们实际应用中为啥不用它来进行所有的数据存储呢？那肯定是有原因呢。

　　数组的局限性分析：

　　①、 插入快，对于无序数组，上面我们实现的数组就是无序的，

        即元素没有按照从大到小或者某个特定的顺序排列，只是按照插入的顺序排列。无序数组增加一个元素很简单，

        只需要在数组末尾添加元素即可，但是有序数组却不一定了，它需要在指定的位置插入。

　　②、查找慢，当然如果根据下标来查找是很快的。但是通常我们都是根据元素值来查找，给定一个元素值，对于无序数组，

       我们需要从数组第一个元素开始遍历，直到找到那个元素。有序数组通过特定的算法查找的速度会比无需数组快，

       后面我们会讲各种排序算法。

　　③、删除慢，根据元素值删除，我们要先找到该元素所处的位置，然后将元素后面的值整体向前面移动一个位置。也需要比较多的时间。

　　④、数组一旦创建后，大小就固定了，不能动态扩展数组的元素个数。如果初始化你给一个很大的数组大小，

       那会白白浪费内存空间，如果给小了，后面数据个数增加了又添加不进去了。
   */
public class MyArray {

    //  定义一个数组（这里以Integer类型为例）
    private  int[] intArray ;

     //定义数组的实际有效长度
    public   int length ; 

    //定义最大长度或默认长度   如果长度不够自动扩容
    private  int  default_capacity ;

    public MyArray() {

        length = 0;

        default_capacity = 1 << 4 ;

        intArray = new int[default_capacity];
    }

    public MyArray(int default_capacity) {

        if(default_capacity < 1) throw new IllegalArgumentException("参数必需大于0");


        this.length = 0;

        this.default_capacity = default_capacity;

        intArray = new int[default_capacity];

    }

    /**
     * @return
     * 获取素组的有效长度
     */
     public int   getSize(){

        return  length ;
    }

    /**
     * @author chengyuanliang
     * @since 2019/6/3 19:19
     * @desc   获取最大实际长度
     * @param  []
     * @return int
     **/
    public int  getAllSize(){

        return  default_capacity;
    }



    /**
     * @author chengyuanliang
     * @since 2019/4/1 23:07
     * @desc  显示所有
     * @param  []
     * @return void
     **/
    public void   displayAll() {

        for (int i = 0; i < length  ; i++) {
            System.out.print(intArray[i] + "\t");
        }
        System.out.println();
    }

    /**
     * @author chengyuanliang
     * @since 2019/6/3 19:26
     * @desc   扩容的方法
     * @param  []
     * @return void
     **/
    private   void  ensureDefaultCapacity(){

        if(length == default_capacity ){

            default_capacity = default_capacity + default_capacity >> 1;

            intArray = Arrays.copyOf(intArray, default_capacity);
        }

    }
    /**
     * @author chengyuanliang
     * @since 2019/4/1 23:19
     * @desc   添加一个元素  这个默认是在最后添加
     * @param  [element]
     * @return boolean
     **/
    public  boolean  add(int  elementValue){
             ensureDefaultCapacity();

            intArray[length] = elementValue ;
            length++;


        return true;
    }

    /**
     * @author chengyuanliang
     * @since 2019/6/3 19:36
     * @desc   根据下标添加元素
     * @param  [index, elementValue]
     * @return boolean
     **/
    public boolean add(int index, int elementValue) {
        if (index < 0 || index > length - 1) throw new IllegalArgumentException("下标参数有误");


        ensureDefaultCapacity();

        if (index == 0) {
            addFirst(elementValue);
            return true;
        } else if (index == length) {
            add(elementValue);
            return true;
        }else {
            int indexEle = intArray[index];
            intArray[index] = elementValue;
            int currentEle ;
            int temp = indexEle;
            for (int i = index + 1; i < length + 1; i++) {

                currentEle = intArray[i];
                intArray[i] = temp;

                temp = currentEle;

            }
            length++;
            return true;
        }


    }


    /**
     * @author chengyuanliang
     * @since 2019/6/3 19:34
     * @desc   头部添加
     * @param  [elementValue]
     * @return boolean
     **/
    public boolean addFirst(int  elementValue){
        ensureDefaultCapacity();

        for(int i = length -1 ; i > 0 ; i--){
            intArray[i + 1] = intArray[i];
        }
        intArray[0] = elementValue;
        length++;
        return true;
    }



    /**
     * @author chengyuanliang
     * @since 2019/4/1 23:21
     * @desc   获取元素
     * @param  [i]
     * @return int
     **/
   public int  get(int i ) {
       /* if(i > -1 && i < length){

        }*/
       if (i < 0 ||  i >length -1) {
           throw new IndexOutOfBoundsException("数组越界");
       }
        return  intArray[i];
    }

    /**
     * @author chengyuanliang
     * @since 2019/4/1 23:34
     * @desc  搜所元素 返回下标
     * @param  []
     * @return int
     **/
    public  int find(int elementValue){

        int index = -1;

        for (int i = 0; i < length ; i++) {
            if (intArray[i] == elementValue) {
                index =i ;
                break;
            }
        }
       return  index;

    }

    /**
     * @author chengyuanliang
     * @since 2019/4/1 23:54
     * @desc
     * @param  [elementValue]
     * @return boolean
     **/
    public  boolean  deleteByValue(int elementValue){
       boolean  isDelete = false ;

       int index = find(elementValue);

       if(index != -1){
           isDelete = true;
           if(index < length -1) {
               for(int i = index ; i < length ; i++){
                   intArray[i] = intArray[i + 1];
               }
           }
           length--;
       }

        return isDelete ;
    }


    /**
     * @author chengyuanliang
     * @since 2019/6/3 19:06
     * @desc   根据下标删除
     * @param  [index]
     * @return boolean
     **/
    public boolean deleteByIndexd(int index){

        boolean isDelete = false;

        if(length > index) {

            isDelete = true;


            for (int i = index ; i < length -1; i++) {
                intArray[i]  = intArray[i + 1];
            }

            length--;
        }

        return isDelete;

    }

    /**
     * @author chengyuanliang
     * @since 2019/4/1 23:57
     * @desc   修改对应的数据
     * @param  [oldValue, newValue]
     * @return boolean
     **/
    public  boolean modifyByValue(int oldValue , int newValue){

        boolean isModify = false ;

        int index = find(oldValue);

        if(index != -1){

            intArray[index] = newValue;

            isModify = true;
        }

        return isModify;
    }



    /**
     * @author chengyuanliang
     * @since 2019/4/2 0:00
     * @desc   通过下标修改
     * @param  [index, newValue]
     * @return boolean
     **/
    public  boolean modifyByIndex(int index , int newValue){

        boolean isModify = false ;

        /*if(index < 0 ||  index > length -1){
            isModify = false;
            throw new IndexOutOfBoundsException("数组越界");
        }*/

        if(index > -1 && index < length){

            isModify = true;

            intArray[index] = newValue;
        }

        return isModify;
    }


}
