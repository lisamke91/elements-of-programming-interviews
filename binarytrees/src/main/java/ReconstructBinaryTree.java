import java.lang.reflect.Array;
import java.util.*;

public class ReconstructBinaryTree {

    /*
    10.12
    */

    public static BinaryTree<Integer> binaryTreeFromPreorderInorder(List<Integer> preorder, List<Integer> inorder) {
        // construct hash table of in order sequence and position
        Hashtable<Integer, Integer> inOrderHash = new Hashtable<>();
        int index = 0, inOrderStart = 0, inOrderEnd = inorder.size() - 1,
                preOrderStart = 0, preOrderEnd = preorder.size() - 1;
        ListIterator<Integer> listIterator = inorder.listIterator();
        while(listIterator.hasNext()) {
            inOrderHash.put(listIterator.next(), index);
            index++;
        }

        return binaryTreeBuilder(inOrderHash, new ArrayList<Integer>(preorder), new ArrayList<>(inorder),
                inOrderStart, inOrderEnd, preOrderStart, preOrderEnd);
    }

    private static BinaryTree<Integer> binaryTreeBuilder(Hashtable<Integer, Integer> inorderHash,
                                                         ArrayList<Integer> preorder, ArrayList<Integer> inorder,
                                                         int inOrderStart, int inOrderEnd, int preOrderStart, int preOrderEnd) {

        System.out.println("In Order Start: " + inOrderStart + ", In Order End: " + inOrderEnd
                + ", Pre Order Start: " + preOrderStart + ", Pre Order end: " + preOrderEnd);

        // create node
        BinaryTree<Integer> node = new BinaryTree<>(preorder.get(preOrderStart));

        int indexOfElement = inorderHash.get(node.data);
        System.out.println("Index of element: " + indexOfElement);

        // add left subtree
        if(indexOfElement > inOrderStart) {
            System.out.println("Get left subtree");
            node.left = binaryTreeBuilder(inorderHash, preorder, inorder,
                    inOrderStart, indexOfElement - 1, preOrderStart + 1, preOrderStart + indexOfElement - inOrderStart);
        }

        // add right subtree
        if(indexOfElement < inOrderEnd) {
            System.out.println("Get right subtree");
            node.right = binaryTreeBuilder(inorderHash, preorder, inorder,
                    indexOfElement + 1, inOrderEnd, preOrderStart + inOrderEnd - indexOfElement + 1, preOrderEnd);
        }

        // return
        return node;
    }
}
