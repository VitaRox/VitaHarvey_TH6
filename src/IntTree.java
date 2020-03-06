/**
 * @author Vita.Wiebe@seattlecolleges.edu
 * A class to generate a SEQUENTIAL binary tree that contains int values;
 */
public class IntTree {

    // Fields: just one;
    private IntTreeNode root;   // Null if an empty tree; she called hers "overallRoot";

    /*
     Constructors:
     Pass the maximum node number to include in the tree;
     Use private helper method, buildTree, inside constructor to do the work;
     Pre: max > 0;
     Post: construct a tree with given number of nodes;
    */
    public IntTree(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("max: " + max);
        }
        root = buildTree(1, max);
    }


    // Client code talks to the IntTree object, not the IntTreeNodes which comprise it;

    // Methods:

    /*
     Post: returns a sequential tree with n as its root unless n is less than max,
     in which case it returns an empty tree;
    */
//    private IntTreeNode buildTree(int n, int max) {
//        if (n > max) {
//            return null;
//        } else {
//            IntTreeNode left = buildTree(2 * n, max);
//            IntTreeNode right = buildTree(2 * n + 1, max);
//            return new IntTreeNode(n, left, right);
//        }
//    }

    // Concise version of IntTreeNode;
    private IntTreeNode buildTree(int n, int max) {
        if (n > max) {
            return null;
        } else {
            return new IntTreeNode(n, buildTree(2 * n, max), buildTree(2 * n + 1, max));
        }
    }

    // Following four methods print InOrder;
    public void print() {
        print(root);            // Recursive method call;
        System.out.println();   // End line of input;
    }

    private void print(IntTreeNode root) {
        // Base case: is implicitly to do nothing on null;
        if (root != null) {
            // Recursive cases: print left, center, right;
            print(root.left);
            System.out.println(root.data + " ");    // Only the order of these needs to be
            print(root.right);                      // changed in order to implement other
                                                    // print traversals;
        }
    }

    public void printInorder() {
        System.out.println("inorder: ");
        printInorder(root);
        System.out.println();
    }

    private void printInorder(IntTreeNode root) {
        if (root != null) {
            printInorder(root.left);            // Left subtree
            System.out.println(" " + root.data);// root
            printInorder(root.right);           // Right subtree
        }
    }

    public void printSideways() {
        printSideways(root, "");
    }

    private void printSideways(IntTreeNode root, String indent) {
        if (root != null) {
            printSideways(root.right, indent + "    ");
            System.out.println(indent + root.data);
            printSideways(root.left, indent + "    ");
        }

    }

    public int sum() {
        return sum(root);
    }

    private int sum(IntTreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return root.data + sum(root.left) + sum(root.right);
        }

    }


    public int countLevels() {
        return countLevels(root);
    }

    private int countLevels(IntTreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(countLevels(root.left), countLevels(root.right));
        }
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(IntTreeNode root) {
        if (root == null) {
            return 0;
        // Base case
        } else if (root.left == null && root.left == null) {
            return 1;
        // Recursive case:
        } else {
            return countLeaves(root.left) + countLeaves(root.right);
        }
    }



}
