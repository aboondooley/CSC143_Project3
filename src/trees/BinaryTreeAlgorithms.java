package trees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeAlgorithms {
    /**
     * Performs a pre-order traversal of a binary tree.
     * @param root Root of binary tree.
     * @param <T> Type of node payload.
     * @return A Collection containing the node payloads in traversal order.
     */
    public static <T> void preOrderHelper(BinaryNode<T> root, List<T> returnList){
        if (root == null){
            return;
        }
        returnList.add(root.payload);
        preOrderHelper(root.left, returnList);
        preOrderHelper(root.right, returnList);
    }

    public static <T> List<T> preOrder(BinaryNode<T> root) {
        // Cannot append null to a list
        List<T> returnList = new LinkedList<>();
        preOrderHelper(root, returnList);
        //System.out.println(returnList.toString());
        return returnList;
    }

    /**
     * Performs a in-order traversal of a binary tree.
     * @param root Root of binary tree.
     * @param <T> Type of node payload.
     * @return A Collection containing the node payloads in traversal order.
     */

    public static <T> void inOrderHelper(BinaryNode<T> root, List<T> returnList){
        if (root == null){
            return;
        }
        inOrderHelper(root.left, returnList);
        returnList.add(root.payload);
        inOrderHelper(root.right, returnList);
    }


    public static <T> List<T> inOrder(BinaryNode<T> root) {
        //
        List<T> returnList = new LinkedList<T>();
        inOrderHelper(root, returnList);
        return returnList;

        /*
        This doesn't work as it appends null to the list :/
        returnList.addAll(inOrder(root.left));
        returnList.add(root.payload);
        returnList.addAll(inOrder(root.right));
        return returnList;


        inOrder(root.left);
        returnList.add(root.payload);
        System.out.println(returnList.toString());
        inOrder(root.right);
        return null;
                 */
    }

    /**
     * Performs a post-order traversal of a binary tree.
     * @param root Root of binary tree.
     * @param <T> Type of node payload.
     * @return A Collection containing the node payloads in traversal order.
     */

    public static <T> void postOrderHelper(BinaryNode<T> root, List<T> returnList){
        if (root == null){
            return;
        }
        postOrderHelper(root.left, returnList);
        postOrderHelper(root.right, returnList);
        returnList.add(root.payload);
    }

    public static <T> List<T> postOrder(BinaryNode<T> root) {
        //
        List<T> returnList = new LinkedList<>();
        postOrderHelper(root, returnList);
        return returnList;
    }

    /**
     * Conduct a binary seach on a binary search tree for a target value.
     * @param root Root of the binary search tree.
     * @param value The value to search for.
     * @return The node containing the value, or null if the value is not present in the tree.
     */
    public static BinaryNode<Integer> binarySearch(BinaryNode<Integer> root, Integer value) {
        //
        if (root==null || root.payload==value) {
            return root;
        }
        if (root.payload>value){
             return binarySearch(root.left, value);
        } else {
            return binarySearch(root.right, value);
        }
    }

    /**
     * Inserts an Integer value into a Binary Search Tree.
     * @param root Root of the binary search tree.
     * @param value The value to insert.
     * @return The BinaryNode containing the newly inserted value, or an existing BinaryNode with an equal value.
     */
    public static BinaryNode<Integer> insert(BinaryNode<Integer> root, Integer value) {
        //
         if (root == null| root.payload==value){
             root.payload = value;
             return root;
         }
         if (root.left.payload > value){
             insert(root.left, value);
         }
         insert(root.right, value);

        return root;
    }

    /**
     * Determines if two BSTs are equal in value.
     * @param A Root of first tree.
     * @param B Root of second tree.
     * @return True or false depending on the equality of the two trees.
     */
    public static boolean equals(BinaryNode<Integer> A, BinaryNode<Integer> B) {
        //
        if (A == B){
            return true;
        }
        List<Integer> aList = inOrder(A);
        List<Integer> bList = inOrder(B);
        if (aList.size()!=bList.size()){
            return false;
        }
        for (int i=0; i < aList.size(); i++){
            if (aList.get(i)!=bList.get(i)){
                return false;
            }
        }
        return true;
    }

    /**
     * Finds the path from the tree root to a target element.
     * This algorithm does NOT assume the tree is a Binary Search Tree,
     * only that it is a Binary Tree.
     *
     * Hint: This method is a bit harder than the ones above.
     * Consider implementing some TreeAlgorithms first to get some more recursion practice.
     *
     * Hint: You can use the LinkedList::addAll method to append all the contents of
     * another list to a list (like a join, but copies and is non-destructive).
     * You may also use the LinkedList::addFirst method to push to the front of the list.
     *
     * @param root Root of the tree.
     * @param value The value to search for.
     * @param <T> The type of the value to search for.
     * @return A LinkedList of Directions that lead to the target value.
     * If the target value is at the root element, return an empty list.
     * If the target value is not present in the tree, return null.
     */
    public static <T> LinkedList<BinaryNode.Direction> path(BinaryNode<T> root, T value) {
        /* YOUR CODE HERE */
        return null;
    }
}
