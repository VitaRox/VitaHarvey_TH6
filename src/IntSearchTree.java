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
    
    /**
     * A constructor which generates a BST from an array of ints;
     * @param inputList
     */
    public IntSearchTree(int[] inputList) {
        // Call no-arg constructor;
        this();
        // For number of elems in inputList, populate our BST;
        for(int i = inputList.length - 1; i > 0; i--) {
            this.add(inputList[i]);
        }
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
        return contains(getOverallRoot(), sought);
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
        if (getOverallRoot() == null) {
            throw new NoSuchElementException();
        } else {
            return getMin(getOverallRoot());
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
        return countLevels(getOverallRoot());
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
    public void add (int value) {
        overallRoot = add(getOverallRoot(), value);
    }

    /**
     * A private helper for the public 'add';
     * @param root the current root of the current node;
     * @param value the value to be added to our binary search tree;
     * @return root if the value being added is a duplicate value;
     */
    private IntTreeNode add (IntTreeNode root, int value) {
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
            System.out.print(" " + root.data);// root
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
    public void remove(int value) {
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
    
    /**
     * Traverse the IntSearchTree starting with the overallRoot node,
     * counting number of left-child nodes;
     * @return the total number of left-child nodes in the BST;
     */
    public int countLeftNodes() {
        if (getOverallRoot().left == null) {
            return 0;
        } else {
            return countLeftNodes(getOverallRoot());
        }
    }
    
    /**
     * A private, recursive helper method;
     * This works by traversing the nodes of the tree, counting when a given node has
     * a left-child node and recursively calling itself until there are no more nodes to
     * search, at which point the number of these is returned;
     * @param in the current IntTreeNode being inspected by our algorithm;
     * @return the running tally that is the current state of 'count';
     */
    private int countLeftNodes(IntTreeNode in) {
        // 'Count' is the current number of left-child nodes;
        int count = 0;
        
        /*
         Recursive case: if has a left child node, increment 'count'
         and recursive call to itself, passing in next node to examine;
        */
        if (in.left != null) {
            // Recursive call, passing in reference to next left-child node;
            count++;
            return countLeftNodes(in.left) + count;
        }
        
        /*
         Base case: once there are no more left-child nodes to traverse,
         return the number of them;
        */
        return count;
    }
    
    /**
     * Public isFull() method begins traversing the BST starting from its overallRoot
     * @return true if our IntSearchTree is 'full', or has only nodes
     * containing 0 or 2 child nodes;
     */
    public boolean isFull() {
        return isFull(getOverallRoot());
    }
    
    /**
     * Private helper isFull() method that inspects the current node, treating
     * it as the root of its own subtree;
     * @param root
     * @return false if a non-full subtree is found;
     */
    private boolean isFull(IntTreeNode root) {
        // Base case: if node that isn't full OR a leaf is found, return false;
        if ((root.left == null && root.right != null) || (root.right == null && root.left != null)) {
            return false;
        } else {
            return isFull(root.left) && isFull(root.right);
        }
    }
    
}

