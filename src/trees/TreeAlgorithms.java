package trees;

import java.util.*;

public class TreeAlgorithms {
    /**
     * Finds the maximum Integer in a tree.
     * @param root Root of the tree.
     * @return The maximum Integer contained in the tree; null if the root is null.
     */
    public static Integer max(TreeNode<Integer> root) {
        //
        if (root == null) { return null; }
        Integer max_val = root.payload;
        if (root.children == null){
            return root.payload;
        }

        for (TreeNode<Integer> child : root.children){
            max_val = Math.max(max(child), max_val);
        }
        return max_val;
    }

    /**
     * Finds the minimum Integer in a tree.
     * @param root Root of the tree.
     * @return The minimum Integer contained in the tree; null if the root is null.
     */
    public static Integer min(TreeNode<Integer> root) {
        //
        if (root == null) { return null; }
        if (root.children == null){
            return root.payload;
        }
        Integer min_val = root.payload;
        for (TreeNode<Integer> child : root.children){
            min_val = Math.min(min(child), min_val);
        }
        return min_val;
    }

    /**
     * Finds all the tree leaves (nodes with no children) in a tree.
     * @param root Root of the tree.
     * @return A LinkedList of leaf TreeNodes from the tree.
     */
    public static LinkedList<TreeNode<Integer>> leaves(TreeNode<Integer> root) {
        //
        LinkedList<TreeNode<Integer>> returnList= new LinkedList<>();
        if (root == null ) { return returnList; }
        if (root.children.size()==0){
            returnList.add(root);
            return returnList;
        }
        for (TreeNode<Integer> child : root.children){
            returnList.addAll(leaves(child));
        }
        return returnList;
    }

    /**
     * Counts the number of nodes in a tree.
     * @param root Root of the tree.
     * @return
     */
    public static int count(TreeNode<Integer> root) {
        //
        int nodeNumber = 0;
        // int prevNumber = 0;
        if (root == null){return 0;}
        if (root.children.size()==0){return 1;}
        for (TreeNode<Integer> child : root.children){
            nodeNumber = nodeNumber + count(child);
           // prevNumber = root.children.size();
            //nodeNumber = prevNumber + count(child);
        }
        nodeNumber++; // for the root
        return nodeNumber;
    }

    /**
     * Computes the depth (height) of a tree.
     * A single node by itself has zero depth;
     * a single node and a single child has a depth of 1.
     * @param root Root of the tree.
     * @return The depth (height) of the tree.
     */
    public static <T> int depth(TreeNode<T> root) {
        //
       // int intDepth = 0;
        int height = 0;
        if (root == null){return 0;}
        if (root.children==null||root.children.size()==0){return 0;}
        //if (height==0&root.children.size()>0){height=1;}
        for (TreeNode<T> child : root.children){
           // height = 1;
            height = Math.max(height, depth(child));
            // prevNumber = root.children.size();
            //nodeNumber = prevNumber + count(child);
        }
        //height++; // for the root
        return height + 1;
    }

    /**
     * Determines if two trees are equal in value.
     * @param A Root of the first tree.
     * @param B Root of the second tree.
     * @param <T> Type of value contained by the tree.
     * @return True or false depending on the equality of the two trees.
     */
    public static <T> boolean equals(TreeNode<T> A, TreeNode<T> B) {
        //
        if (A==B){return true;}
        if(A.payload!=B.payload||A.children.size()!=B.children.size()){return false;}
        for (int i=0; i<A.children.size(); i++){
            if (A.getChild(i).payload != B.getChild(i).payload){
                return false;
            }
        }
        return true;
    }

    /**
     * Conducts a breadth first search on a tree, from top to bottom, left to right.
     *
     * Hint: use a Java Queue, rather than recursion (which depends on the Stack).
     * You can add and remove to the queue using Queue::add(e) and Queue::remove, respectively.
     *
     * @param root Root of the tree.
     * @return List of elements in the tree, in order of BFS search.
     */
    public static LinkedList<Integer> bfs(TreeNode<Integer> root) {
        /* YOUR CODE HERE */
        return null;
    }

    /**
     * Finds the path from a tree root to a target element.
     *
     * Note: unlike BinaryTreeAlgorithms::path, this method returns a list of nodes
     * rather than a list of directions (enums). Furthermore, this method returns
     * an empty list when there is no path, while the BinaryTreeAlgorithms::path method
     * will return null if there is no path.
     *
     * @param root Root of the tree.
     * @param value Value to search for.
     * @return A LinkedList of TreeNodes, starting with the root node, describing the path of nodes
     * from the root to the node containing the target value.
     * If the target element is not present in the tree, return an empty list.
     */
    public static <T> LinkedList<TreeNode<T>> path(TreeNode<T> root, T value) {
        /* YOUR CODE HERE */
        return null;
    }
}
