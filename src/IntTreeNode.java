/**
 * @author Vita Wiebe
 */
public class IntTreeNode {

    // Fields
    int data;
    IntTreeNode left;
    IntTreeNode right;

    // Constructors:

    // Construct a leaf node with the given data;
    public IntTreeNode(int data) {
        this(data, null, null);
    }

    // Construct a branch node;
    public IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
