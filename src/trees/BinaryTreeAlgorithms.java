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

    public static <T> List<T> preOrder(BinaryNode<T> root) {
        // Cannot append null to a list
        List<T> returnList = new LinkedList<>();
        if (root==null){
            return null;
        }
        returnList.add(root.payload);
        if (root.left!=null){returnList.addAll(preOrder(root.left));}
        if (root.right!=null){returnList.addAll(preOrder(root.right));}
        return returnList;
    }

    /**
     * Performs a in-order traversal of a binary tree.
     * @param root Root of binary tree.
     * @param <T> Type of node payload.
     * @return A Collection containing the node payloads in traversal order.
     */

    public static <T> List<T> inOrder(BinaryNode<T> root) {
        //
        List<T> returnList = new LinkedList<>();
        if (root==null){
            return null;
        }
        if (root.left!=null){returnList.addAll(inOrder(root.left));}
        returnList.add(root.payload);
        if (root.right!=null){returnList.addAll(inOrder(root.right));}
        return returnList;
    }

    /**
     * Performs a post-order traversal of a binary tree.
     * @param root Root of binary tree.
     * @param <T> Type of node payload.
     * @return A Collection containing the node payloads in traversal order.
     */

    public static <T> List<T> postOrder(BinaryNode<T> root) {
        //
        List<T> returnList = new LinkedList<>();
        if (root==null){
            return null;
        }
        if (root.left!=null){returnList.addAll(postOrder(root.left));}
        if (root.right!=null){returnList.addAll(postOrder(root.right));}
        returnList.add(root.payload);
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
         if (root == null){
             root = new BinaryNode<>(value);
             return root;
         }
         if (root.payload==value){
             return root;
         }
         if (value < root.payload){
             if (root.left == null){
                 root.left = new BinaryNode<>(value);
                 return root.left;
             }
             return insert(root.left, value);
         } else {
             if (root.right == null) {
                 root.right = new BinaryNode<>(value);
                 return root.right;
             }
             return insert(root.right, value);
         }

    }

    /**
     * Determines if two BSTs are equal in value.
     * @param A Root of first tree.
     * @param B Root of second tree.
     * @return True or false depending on the equality of the two trees.
     */
    public static boolean equals(BinaryNode<Integer> A, BinaryNode<Integer> B) {
        //
        boolean pay_val = false;
        boolean side_val = false;

        if (A.payload==B.payload){pay_val= true;}
        if (A.left==null&&B.left==null){
            side_val = true;
        } else if (A.left!=null&&B.left!=null){
            side_val = equals(A.left, B.left);
        } else {side_val = false;}
        if (A.right==null&&B.right==null){
            side_val = true;
        } else if (A.right!=null&&B.right!=null){
            side_val = equals(A.right, B.right);
        } else {side_val = false;}

        return side_val&&pay_val;
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
        //
        LinkedList<BinaryNode.Direction> returnList = new LinkedList<>();
        if (root==null){
            return null;
        }
        if (root.payload==value){
            return returnList;
        }
        if (root.left!=null){
            if (root.left.payload==value) {
                returnList.add(BinaryNode.Direction.left);
                return returnList;
            }
            LinkedList<BinaryNode.Direction> i = (path(root.left, value));
            if (i != null){
                returnList.add(BinaryNode.Direction.left);
                returnList.addAll(i);
            }

        }

        if (root.right!=null){
            if (root.right.payload==value) {
                returnList.add(BinaryNode.Direction.right);
                return returnList;
            }

            LinkedList<BinaryNode.Direction> i = (path(root.right, value));
            if (i != null){
                returnList.add(BinaryNode.Direction.right);
                returnList.addAll(i);
            }
        }

        if (returnList.size()==0){return null;}
        return returnList;
    }
}
