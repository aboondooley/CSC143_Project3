package trees;

import java.util.*;

public class TreeAlgorithms {
    /**
     * Finds the maximum Integer in a tree.
     * @param root Root of the tree.
     * @return The maximum Integer contained in the tree; null if the root is null.
     */
    public static Integer max(TreeNode<Integer> root) {
        // Returns the max value in the whole tree.
        if (root == null) { return null; }
        Integer max_val = root.payload;
        if (root.children == null){
            // If the node has no children, return the node value
            return root.payload;
        }
        // This solution has a O(n) at worst because we have to check each node.
        for (TreeNode<Integer> child : root.children){
            // Compare the returned value to the current max value
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
        // Finds the minimum value of the entire tree
        if (root == null) { return null; }
        if (root.children == null){
            return root.payload;
        }
        Integer min_val = root.payload;
        for (TreeNode<Integer> child : root.children){
            // Compares the returned value to the current min value
            min_val = Math.min(min(child), min_val);
            // Need to differentiate between math.min() vs min()
        }
        return min_val;
    }

    /**
     * Finds all the tree leaves (nodes with no children) in a tree.
     * @param root Root of the tree.
     * @return A LinkedList of leaf TreeNodes from the tree.
     */
    public static LinkedList<TreeNode<Integer>> leaves(TreeNode<Integer> root) {
        // Returns only nodes with no children i.e. only the leaves
        LinkedList<TreeNode<Integer>> returnList= new LinkedList<>();
        if (root == null ) { return returnList; }
        if (root.children.size()==0){
            // If no children exist, this is a leaf, so add to the return list
            returnList.add(root);
            return returnList;
        }
        for (TreeNode<Integer> child : root.children){
            // recurse through all the children
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
        // Counts the number of nodes in the entire tree
        // By virtue of the purpose of this method it has to be O(n)
        int nodeNumber = 0;
        if (root == null){return 0;}
        // If no children exist then just return one for the root.
        if (root.children.size()==0){return 1;}
        for (TreeNode<Integer> child : root.children){
            nodeNumber = nodeNumber + count(child);
        }
        nodeNumber++; // adds all the values of the nodes on the way back up
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
        // Counts the number of levels of children that exist
        int height = 0; // start at 0
        if (root == null){return 0;}
        if (root.children==null||root.children.size()==0){return 0;} // if no children return 0 as well
        for (TreeNode<T> child : root.children){
            // compares the current height with those returned by other children
            // keeps the max height
            height = Math.max(height, depth(child));
        }
        return height + 1; // Add one for the current level
    }

    /**
     * Determines if two trees are equal in value.
     * @param A Root of the first tree.
     * @param B Root of the second tree.
     * @param <T> Type of value contained by the tree.
     * @return True or false depending on the equality of the two trees.
     */
    public static <T> boolean equals(TreeNode<T> A, TreeNode<T> B) {
        // Compares two trees to see if they are exactly the same in structure and payload values
        if(A.payload!=B.payload||A.children.size()!=B.children.size()){return false;}
        for (int i=0; i<A.children.size(); i++){
            // uses recursion to compare each child in the tree
            // Also an O(n) operation at worst.
            if (equals(A.getChild(i), B.getChild(i))){
                return true;
            } else {
                return false; // returns early if two nodes don't match
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
        // Traverses the nodes in depth order from left to right
        // Called breadth first
        LinkedList<Integer> returnList = new LinkedList<>();
        if (root==null){return returnList;}
        // Create a queue to save all the nodes with children so they can
        // Be traversed at a later time
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        // pop off and add root node first.
        queue.add(root);
        returnList.add(root.payload);
        TreeNode<Integer> current;
        while(!queue.isEmpty()){
            // continue through the queue of children while it's not empty
            current = queue.remove();
            for (TreeNode<Integer> child : current.children) {
                returnList.add(child.payload);
                if (child.children.size() > 0) {
                    // If the child has children, add this child to the queue to be traversed later
                    queue.add(child);
                }
            }
        }

        return returnList;
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
        // Creates a list of nodes that create a path to the node specified.
        LinkedList<TreeNode<T>> returnList = new LinkedList<>();
        if (root==null){return returnList;}
        if (root.payload==value){
            returnList.add(root);
            return returnList;
        }
        for (TreeNode<T> child : root.children){
            LinkedList<TreeNode<T>> values = path(child, value);
            if (values.size()>0){
                // if the list is greater than 0 then we know that we are on the right path
                // and we add the current node to the front of our return list
                returnList.addFirst(root);
                returnList.addAll(values);
            }
        }

        return returnList;
    }
}
