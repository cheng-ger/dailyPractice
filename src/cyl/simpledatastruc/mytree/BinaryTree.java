package cyl.simpledatastruc.mytree;

import java.util.NoSuchElementException;

/**
 * @author chengyuanliang
 *有序数组可以利用二分查找法快速的查找特定的值，时间复杂度为O(log2N)，但是插入数据时很慢，时间复杂度为O(N)；
 * 链表的插入和删除速度都很快，时间复杂度为O(1)，但是查找特定值很慢，时间复杂度为O(N)。
 *有一种数据结构既能像有序数组那样快速的查找数据，又能像链表那样快速的插入数据呢？
 * 树就能满足这种要求。不过依然是以算法的复杂度为代价
 *
 * @desc  此处为搜索二叉树
 * 一个父节点下最多只有两个节点 左，右子节点
 * 二叉搜索树的特点是，一个节点的左子节点的关键字值小于这个节点，右子节点的关键字值大于或等于这个父节点。
 *关于树，还有一个平衡树与非平衡树的概念。非平衡就是说树的大部分节点在根的一边
 * @since 2019-06-04
 */

/*
   树的基本概念
    ①、路径：顺着节点的边从一个节点走到另一个节点，所经过的节点的顺序排列就称为“路径”。

　　②、根：树顶端的节点称为根。一棵树只有一个根，如果要把一个节点和边的集合称为树，
       那么从根到其他任何一个节点都必须有且只有一条路径。A是根节点。

　　③、父节点：若一个节点含有子节点，则这个节点称为其子节点的父节点；B是D的父节点。

　　④、子节点：一个节点含有的子树的根节点称为该节点的子节点；D是B的子节点。

　　⑤、兄弟节点：具有相同父节点的节点互称为兄弟节点；比如上图的D和E就互称为兄弟节点。

　　⑥、叶节点：没有子节点的节点称为叶节点，也叫叶子节点，比如上图的H、E、F、G都是叶子节点。

　　⑦、子树：每个节点都可以作为子树的根，它和它所有的子节点、子节点的子节点等都包含在子树中。

　　⑧、节点的层次：从根开始定义，根为第一层，根的子节点为第二层，以此类推。

　　⑨、深度：对于任意节点n,n的深度为从根到n的唯一路径长，根的深度为0；

　　⑩、高度：对于任意节点n,n的高度为从n到一片树叶的最长路径长，所有树叶的高度为0；




 */
public class BinaryTree {

    /*成员变量*/

    //根节点
    private Node rootNode;


    /*搜素二叉树的节点内部类*/

    public static class Node {

        private Integer value;

        private Node leftChildNode;

        private Node rightChildNode;

        public Node( Node leftChildNode,Integer value, Node rightChildNode) {
            this.value = value;
            this.leftChildNode = leftChildNode;
            this.rightChildNode = rightChildNode;
        }
    }


    /*初始化构造器*/

    public BinaryTree() {

        this.rootNode = null;
    }

    public Node find(int value) {
        if(rootNode == null) throw new NoSuchElementException("空数");

        Node currentNode = rootNode;

        while(currentNode != null){

            if(value == currentNode.value){
                break;
            }else if(value < currentNode.value ){
                currentNode = currentNode.leftChildNode;
            }else {
                currentNode = currentNode.rightChildNode;
            }
        }
        return currentNode;

    }


    public void addNode(int value) {

        Node addNode = new Node(null, value, null);

        if(rootNode == null ){
            rootNode = addNode;
        }else{
            Node currentNode = rootNode;
            Node parentNode ;
            while (currentNode != null){
                parentNode = currentNode;
                //左节点
                if(value < currentNode.value){
                    currentNode = currentNode.leftChildNode;
                    if(currentNode == null){
                        parentNode.leftChildNode = addNode;
                    }
                }else {
                    currentNode = currentNode.rightChildNode;
                    if(currentNode == null){
                        parentNode.rightChildNode = addNode;
                    }
                }
            }

        }

    }


    public void display(int type) {
        switch (type) {
            case  1:
                prevSort(rootNode);
             break;
            case  2:
                nextSort(rootNode);
                break;
             default:
                 midSort(rootNode);
                 break;
        }
    }

    private void midSort(Node currentNode) {

        if(currentNode != null){
            midSort(currentNode.leftChildNode);
            System.out.print("\t" + currentNode.value);
            midSort(currentNode.rightChildNode);
        }
    }

    private void nextSort(Node currentNode) {

        if(currentNode != null){

            nextSort(currentNode.leftChildNode);
            nextSort(currentNode.rightChildNode);
            System.out.print("\t" +currentNode.value);
        }
    }

    private void prevSort(Node currentNode) {

        if(currentNode != null){
            System.out.print("\t" +currentNode.value);
            prevSort(currentNode.leftChildNode);
            prevSort(currentNode.rightChildNode);

        }
    }


    public boolean delete(int value){
        if(rootNode == null) throw new NoSuchElementException("无元素");

        //寻找该节点
        Node currentNode = rootNode;
        Node parentNode = null;
        boolean isLeft = true;
        while(value != currentNode.value){
            parentNode = currentNode;
            if(value < currentNode.value){
                currentNode = currentNode.leftChildNode;

            }else{
                isLeft = false;
                currentNode = currentNode.rightChildNode;
            }

            if(currentNode == null){
                return false;
            }
        }



        //判读删除节点下有几个子节点
        if(currentNode.leftChildNode == null && currentNode.rightChildNode == null){
            if(currentNode == rootNode){
                rootNode = null;
            }else {
                if(isLeft){
                    parentNode.leftChildNode = null;
                }else {
                    parentNode.rightChildNode = null;
                }
            }
        }else if(currentNode.leftChildNode == null && currentNode.rightChildNode != null){

            if(currentNode == rootNode){
                rootNode = currentNode.rightChildNode;
            }else {
                if(isLeft){
                    parentNode.leftChildNode = currentNode.rightChildNode ;
                }else {
                    parentNode.rightChildNode = currentNode.rightChildNode ;
                }
            }
        } else if (currentNode.leftChildNode != null && currentNode.rightChildNode == null) {

            if(currentNode == rootNode){
                rootNode = currentNode.leftChildNode;
            }else {
                if(isLeft){
                    parentNode.leftChildNode = currentNode.leftChildNode ;
                }else {
                    parentNode.rightChildNode = currentNode.leftChildNode ;
                }
            }
        }else {//删除有两个子节点

            //找到删除节点的后继节点   后继节点为右子节点下的最小值的节点（不停的左子节点）
            Node nextNode = currentNode.rightChildNode;
            Node nextParentNode = null;
            while (nextNode.leftChildNode != null){
                nextParentNode = nextNode;
                nextNode = nextNode.leftChildNode;
            }

            //判读删除的节点是否为后继节点的父节点

            if(nextParentNode == null){
                //nextNode.rightChildNode = null;
            }else {
                //nextParentNode.leftChildNode = null;
                nextParentNode.leftChildNode = nextNode.rightChildNode;
                nextNode.rightChildNode = currentNode.rightChildNode;
            }



            //为左节点填充
            if(currentNode ==rootNode){
                rootNode = nextNode;
                nextNode.leftChildNode = currentNode.leftChildNode;

            }else {
                if(isLeft){
                    parentNode.leftChildNode = nextNode;

                }else {

                    parentNode.rightChildNode = nextNode;
                }
            }
         //   System.out.println("nextParentNode:" + nextParentNode.value);
           // System.out.println("nextNode:" + nextNode.value);
        }

       // System.out.println("parentNode:" + parentNode.value );

        return true;

    }


}
