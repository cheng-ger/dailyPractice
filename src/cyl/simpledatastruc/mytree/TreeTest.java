package cyl.simpledatastruc.mytree;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-06-04
 */
public class TreeTest {





    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        tree.addNode(20);
        tree.addNode(30);
        tree.addNode(10);

        /*tree.addNode(31);
        tree.addNode(32);*/
        /*tree.addNode(35);*/
        tree.display(3);

        System.out.println();
        tree.delete(20);

        tree.display(3);
        System.out.println();
        tree.display(1);

    }
}
