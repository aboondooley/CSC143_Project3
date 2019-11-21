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
        // Returns root, left, right
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
        // Returns left, root, right
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
        // Returns left, right, root
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
        // Returns the node with the value of interest from a Binary Search Tree
        if (root==null || root.payload==value) {
            return root;
        }
        if (root.payload>value){  // if value is less than payload, go left
             return binarySearch(root.left, value);
        } else { // value is greater than payload
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
        // Inserts the specific node at it's correct location, if it doesn't already exist there
        // Also return the node
         if (root == null){
             root = new BinaryNode<>(value); // create node if the root is null
             return root;
         }
         if (root.payload==value){
             return root;
         }
         if (value < root.payload){ // if value is less than payload, go left
             if (root.left == null){
                 root.left = new BinaryNode<>(value);
                 return root.left;
             }
             return insert(root.left, value);
         } else {
             if (root.right == null) { // if value is greater than payload, go right
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
        // This method compares two Binary Trees recursively and returns if they are
        // equal in structure and value
        boolean pay_val = false; // this is for values
        boolean side_val = false; // this is to see if the side nodes are the same

        if (A.payload==B.payload){pay_val= true;} // set to whether the payloads are equal
        if (A.left==null&&B.left==null){
            side_val = true; // set the other indicator
        } else if (A.left!=null&&B.left!=null){
            side_val = equals(A.left, B.left);
        } else {side_val = false;}
        if (A.right==null&&B.right==null){
            side_val = true;
        } else if (A.right!=null&&B.right!=null){
            side_val = equals(A.right, B.right);
        } else {side_val = false;}

        return side_val&&pay_val; // return whether either are false
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
        // Returns the directions that lead to the target value
        LinkedList<BinaryNode.Direction> returnList = new LinkedList<>();
        if (root==null){
            return null;
        }
        if (root.payload==value){
            // return empty if the value matches
            return returnList;
        }
        if (root.left!=null){ // avoid NullPointerException
            if (root.left.payload==value) {
                // if the last node contained the value, add left to returnList
                returnList.add(BinaryNode.Direction.left);
                return returnList;
            }
            // Have to preview what is being returned first
            // Unfortunately this means O(n^2)
            LinkedList<BinaryNode.Direction> i = path(root.left, value);
            if (i.size()>0){
                // If that result was not empty, then add left to the front, then add the rest of the directions list
                returnList.add(BinaryNode.Direction.left);
                returnList.addAll(i);
            }
        }

        if (root.right!=null){ // avoid NPE
            if (root.right.payload==value) {
                // if the last node contained the value, add right to returnList
                returnList.add(BinaryNode.Direction.right);
                return returnList;
            }

            LinkedList<BinaryNode.Direction> i = path(root.right, value);
            if (i.size()>0){
                returnList.add(BinaryNode.Direction.right);
                returnList.addAll(i);
            }
        }
        // finally, return the list!
        return returnList;
    }
}
