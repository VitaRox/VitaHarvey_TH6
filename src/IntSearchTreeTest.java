import java.util.Arrays;

/**
 * A test class with hard-coded values for easy testing of assignment 6, IntSearchTree.java;
 * @author Vita Harvey <Vita.Wiebe@seattlecolleges.edu><b>Drop me a line!</b></Vita.Wiebe@seattlecolleges.edu>
 */
public class IntSearchTreeTest {
	
	
	public static void main(String[] args) {
		
		// Create two arrays of ints to test our BST methods with;
		int[] list1 = {55,29,87,-3,42,60,91};
		int[] list2 =  {60,55,100,45,57};
		
		// Create two IntSearchTrees, one for each array;
		IntSearchTree test1 = new IntSearchTree(list1);
		IntSearchTree test2 = new IntSearchTree(list2);
		
		// Begin to demonstrate methods and output is appropriate and expected;
		
		// List2 tests:
		System.out.println("The original array list1 is: " + Arrays.toString(list1));
		
		// Print our tree out as a tree;
		System.out.println("Tree Structure");
		test1.printSideways();
		System.out.println();
		
		// Print sorted values;
		System.out.println("Sorted list1:");
		test1.printInorder();
		System.out.println();
		
		// Demonstrate countLeftNodes() method:
		System.out.println("Overall root of test2: " + test1.getOverallRoot().data);
		System.out.println("The number of left nodes is "  + test1.countLeftNodes()); // test1.countLeftNodes()
		System.out.println("This is a full binary tree: " +  test1.isFull());
		System.out.println();
		System.out.println();
		
		// List2 tests:
		System.out.println("The original array list2 is: " + Arrays.toString(list2));
		
		// Print our tree out as a tree;
		System.out.println("Tree Structure");
		test2.printSideways();
		System.out.println();
		
		// Print sorted values;
		System.out.println("Sorted list2:");
		test2.printInorder();
		System.out.println();
		
		// Demonstrate countLeftNodes() method:
		System.out.println("Overall root of test2: " + test2.getOverallRoot().data);
		System.out.println("The number of left nodes is " + test2.countLeftNodes());
		System.out.println("This is a full binary tree: " + test2.isFull());
		System.out.println();
		System.out.println();
	}
}
