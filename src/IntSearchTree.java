import java.lang.Math;
import java.util.NoSuchElementException;


/**
 * @author Vita.Wiebe
 * A binary search tree, a sorted version of the sequential tree class;
 */
public class IntSearchTree {

    // Fields:
    private IntTreeNode overallRoot;

    // Constructors
    public IntSearchTree() {
        overallRoot = null;
    }
    
    // Methods:
    
    /**
     * A simple getter for accessing our encapsulated field, "overallRoot";
     * @return the overallRoot of the current BST;
     */
    public IntTreeNode getOverallRoot() {
        return this.overallRoot;
    }
    
    /**
     * Pre: root != null;
     * Post: returns true if element is found in our BST;
     * @param sought, the value being looked for;
     * @return true if "sought" is found, false if not;
     */
    public boolean contains(int sought) {
        return contains(this.overallRoot, sought);
    }
    
    /**
     * A helper method for the above public version of 'contains';
     * @param root, the root of the current branch;
     * @param sought, the value being sought;
     * @return false if contains nothing, true if it does contain value 'sought';
     *          Otherwise, recursively calls itself to continue search;
     */
    private boolean contains(IntTreeNode root, int sought) {
        if (root == null) {
            return false;
        } else if (root.data == sought) {
            return true;
        } else if (root.data > sought){
            return contains(root.left, sought);
        } else {
            return contains(root.right, sought);
        }
    }
    
    /**
     * Public method to find the lowest data value in our BST;
     * @return a recursive call to its private helper method, defined below;
     */
    public int getMin() {
        if (overallRoot == null) {
            throw new NoSuchElementException();
        } else {
            return getMin(overallRoot);
        }
    }
    
    /**
     *
     * @param root the IntTreeNode currently being inspected, the root of its own sub-tree;
     * @return the lowest value found in our IntSearchTree;
     */
    private int getMin(IntTreeNode root) {
        if (root.left == null) {
            return root.data;
        } else {
            return getMin(root.left);
        }
    }
    
    /**
     *
     * @return the number of levels in the current BST;
     */
    public int countLevels () {
        return countLevels(overallRoot);
    }

    /**
     *
     * @param root the root of the current branch;
     * @return
     */
    private int countLevels (IntTreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(countLevels(root.left), countLevels(root.right));
        }
    }

    /**
     * Add a value to the BST;
     * @param value the data value to add to our BST;
     */
    public void add ( int value) {
        overallRoot = add(overallRoot, value);
    }

    /**
     * A private helper for the public 'add';
     * @param root the current root of the current node;
     * @param value the value to be added to our binary search tree;
     * @return root if the value being added is a duplicate value;
     */
    private IntTreeNode add (IntTreeNode root,int value) {
        if (root == null) {
            root = new IntTreeNode(value);
        } else if (value <= root.data) {
            root.left = add(root.left, value);
        } else {
            root.right = add(root.right, value);
        }
        // else: a duplicate. Do nothing;
        return root;
    }

    /**
     * Implement an in-order traversal algorithm to print the values of the current BST in-order;
     */
    public void printInorder () {
        System.out.println("inorder: ");
        printInorder(overallRoot);
        System.out.println();
    }

    /**
     * A private helper method for the above version of 'printInorder()";
     * @param root the data value associated with the current node being examined;
     */
    private void printInorder (IntTreeNode root) {
        if (root != null) {
            printInorder(root.left);            // Left subtree
            System.out.println(" " + root.data);// root
            printInorder(root.right);           // Right subtree
        }
    }

    /**
     * Print the current BST in a sideways fashion to the console;
     */
    public void printSideways () {
        printSideways(overallRoot, "");
    }

    /**
     * A private helper for the public 'printSideways()' method;
     * @param root root the current node being printed;
     * @param indent the amount of indentation being added for readability & style;
     */
    private void printSideways (IntTreeNode root, String indent) {
        if (root != null) {
            printSideways(root.right, indent + "    ");
            System.out.println(indent + root.data);
            printSideways(root.left, indent + "    ");
        }
    }

    /**
     * Remove a given value;
     * @param value, the value to be removed from our BST;
     */
    public void remove ( int value) {
        overallRoot = remove(overallRoot, value);
    }

    /**
     * A private helper for the above 'remove()' method;
     * @param root the current node being examined,
     * @param value, the value to remove from our BST;
     * @return IntTreeNode being removed;
     */
    private IntTreeNode remove (IntTreeNode root, int value) {
        if (root == null) {
            return null;
        } else if (root.data > value) {
            root.left = remove(root.left, value);
        } else if (root.data < value) {
            root.right = remove(root.right, value);
        } else {
            if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                root.data = getMin(root.right);
                root.right = remove(root.right, root.data);
            }
        }
        return root;
    }
}

