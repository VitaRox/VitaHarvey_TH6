/**
 * @author Vita.Wiebe
 * A binary search tree, a sorted version of the sequential tree class;
 */
public class IntSearchTree {

    // Fields:
    IntTreeNode overallRoot;

    // Constructors
    public IntSearchTree() {
        overallRoot = null;
    }
    


    // Methods:

    /**
     * Pre: root != null;
     * Post: returns true if element is found in our BST;
     * @param sought, the value being looked for;
     * @return true if "sought" is found, false if not;
     */
    public boolean contains(int sought) {
        return contains(this.overallRoot, sought);
    }

    // Figure out rest of implementation of this method;
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

    // Supply implementation; 1 is a dummy value;
    public static int getMin(IntTreeNode root) {
        return 1;
    }
    public int countLevels() {
        
        return countLevels(overallRoot);
    }

    private int countLevels(IntTreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(countLevels(root.left), countLevels(root.right));
        }
    }

    public void add(int value) {
        overallRoot = add(overallRoot, value);
    }

    private IntTreeNode add(IntTreeNode root, int value) {
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
    
    public void printInorder() {
        System.out.println("inorder: ");
        printInorder(overallRoot);
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
        printSideways(overallRoot, "");
    }

    private void printSideways(IntTreeNode root, String indent) {
        if (root != null) {
            printSideways(root.right, indent + "    ");
            System.out.println(indent + root.data);
            printSideways(root.left, indent + "    ");
        }
    }
    
    public void remove(int value) {
        overallRoot = remove(overallRoot, value);
    }
    
    private IntTreeNode remove(IntTreeNode root, int value) {
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
                root.right = remove();
            }
        }
    }
    


}
