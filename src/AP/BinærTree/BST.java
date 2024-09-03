package AP.BinærTree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * BST is a binary search tree.
 * Note: Equal elements are not allowed in the tree.
 * Note: The methods add() and remove does not re-balance the tree.
 */

public class BST<E extends Comparable<E>> {
    private TreeNode root;
    private int size = 0;
    private java.util.Comparator<E> c;

    /**
     * Create a default BST with a natural order comparator
     */
    public BST() {
        this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
    }

    /**
     * Create a BST with a specified comparator
     */
    public BST(java.util.Comparator<E> c) {
        this.c = c;
    }

    // Return a (current, parent)-pair consisting of
    // the node containing the element e and this node's parent.
    // Return value:
    //   current != null and parent != null: current contains e and parent is the parent to current
    //   current != null and parent == null: current is the root containing e
    //   current == null and parent != null: e is not found
    //         and parent is the node where a node with e would be inserted as child
    //   current == null and parent == null: the three is empty
    private NodePair locateNodeAndParent(E e) {
        boolean found = false;
        TreeNode parent = null;
        TreeNode current = root; // Start from the root
        while (!found && current != null) {
            if (c.compare(e, current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                parent = current;
                current = current.right;
            } else {
                found = true;
            }
        }
        return new NodePair(current, parent);
    }

    private class NodePair {
        private TreeNode current;
        private TreeNode parent;

        public NodePair(TreeNode current, TreeNode parent) {
            this.current = current;
            this.parent = parent;
        }
    }

    /**
     * Returns true if the element is in the tree
     */
    public boolean search(E e) {
        // Locate the node with the element e (and its parent node).
        NodePair pair = locateNodeAndParent(e);
        return pair.current != null;
    }


    /**
     * Insert element e into the binary tree
     * Return true if the element is inserted successfully
     * Return false if the element is found in the tree before insertion.
     */
    public boolean insert(E e) {
        // Locate the node with the element e and its parent node.
        NodePair pair = locateNodeAndParent(e);
        boolean inserted = false;
        if (pair.current == null) {
            if (root == null) {
                root = new TreeNode(e); // Create a new root
            } else {
                TreeNode parent = pair.parent;
                // Create a new node and attach it to the parent node.
                if (c.compare(e, parent.element) < 0) {
                    parent.left = new TreeNode(e);
                } else {
                    parent.right = new TreeNode(e);
                }
            }
            inserted = true;
            size++;
        }
        return inserted; // Element inserted successfully
    }


    /**
     * Inorder traversal from the root
     */
    public void inorder() {
        inorder(root);
    }

    /**
     * Inorder traversal from a subtree
     */
    private void inorder(TreeNode root) {
        //TODO
        // left as an exercise
        if (root.left != null) {
            inorder(root.left);
        }
        System.out.println(root.element);
        if (root.right != null){
            inorder(root.right);
        }

    }


    /**
     * Postorder traversal from the root
     */
    public void postorder() {
        //TODO
        // left as an exercise
        postOrder(root);

    }
    private void postOrder(TreeNode root){
        if (root.left != null){
            postOrder(root.left);
        }
        if (root.right != null){
            postOrder(root.right);
        }
        System.out.println(root.element);
    }


    /**
     * Preorder traversal from the root
     */
    public void preorder() {
        //TODO
        // left as an exercise
        preOrder(root);
    }
    private void preOrder(TreeNode root){
        System.out.println(root.element);
        if (root.left != null){
            preOrder(root.left);
        }
        if (root.right != null){
            preOrder(root.right);
        }
    }
    public List<E> inOrderList(){
        List<E> liste = new ArrayList<>();
        inorderList(root,liste);
        return liste;
    }
    private void inorderList(TreeNode root,List<E> liste){
        if (root.left != null){
            inorderList(root.left,liste);
        }
        liste.add(root.element);
        if (root.right != null){
            inorderList(root.right,liste);
        }
    }

    public int height(){
        return -1;
    }
    public E findmax(){
        TreeNode max = root;
        findMax(max);
        return max.element;
    }
    private void findMax(TreeNode root){
        TreeNode max = null;
        while (root.right != null){
            max = root;
        }

    }

    private class TreeNode {
        private E element;
        private TreeNode left;
        private TreeNode right;

        private TreeNode(E e) {
            element = e;
        }
    }


    /**
     * Get the number of nodes in the tree
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the root of the tree
     */
    private TreeNode getRoot() {
        return root;
    }


    /**
     * Delete an element from the binary tree.
     * Return true if the element is deleted successfully
     * Return false if the element is not in the tree
     */
    public boolean delete(E e) {
        // Locate the node with the element e and its parent node.
        NodePair pair = locateNodeAndParent(e);
        boolean found = true;
        if (pair.current == null) { // the element e is not in the tree
            found = false;
        } else {
            TreeNode current = pair.current;
            TreeNode parent = pair.parent; // may be null
            // Case 1: current has no left child
            if (current.left == null) {
                // Connect the parent with the right child of the current node
                if (parent == null) {
                    root = current.right;
                } else {
                    if (c.compare(e, parent.element) < 0)
                        parent.left = current.right;
                    else
                        parent.right = current.right;
                }
            } else {
                // Case 2: The current node has a left child
                // Locate the rightmost(biggest) node in the left subtree of
                // the current node and also its parent
                TreeNode parentOfRightMost = current;
                TreeNode rightMost = current.left;

                if (rightMost.right == null) { // special case: no node to the right of rightMost
                    current.element = rightMost.element;
                    current.left = rightMost.left;
                } else {
                    while (rightMost.right != null) {
                        parentOfRightMost = rightMost;
                        rightMost = rightMost.right; // keep going to the right
                    }
                    // Replace the element in current by the element in rightMost.
                    current.element = rightMost.element;
                    // Eliminate rightmost node.
                    parentOfRightMost.right = rightMost.left;
                }

            }
            size--; // Reduce the size of the tree
        }
        return found; // Element deleted successfully
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(TreeNode node) {
        if (node == null) return "";
        return toString(node.left) + " " + node.element + " " + toString(node.right);
    }

    //-------------------------------------------------------------------


}
