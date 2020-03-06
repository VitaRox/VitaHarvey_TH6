import jdk.packager.services.UserJvmOptionsService;

import java.util.*;

/**
 * @author Vita Wiebe
 */
public class IntTreeClient {
    
    /**
     * Our application method;
     * @param args the values to be added to form a given IntSearchTree;
     */
    public static void main(String[] args) {
        
        // Create a Scanner object to take and parse user input;
        Scanner console = new Scanner(System.in);
        IntSearchTree numbers = new IntSearchTree();
        System.out.println("next int (0 to quit):");
        int number1 = console.nextInt();
        
        // Continues allowing user to enter ints, provided they don't enter 0, the flag to exit and print stuff;
        while (number1 != 0) {
            numbers.add(number1);
            System.out.print("");
            number1 = console.nextInt();
        }
        
        // Print stuff:
        System.out.println();
        System.out.print("");
        System.out.println();
        numbers.printSideways();
        System.out.println();
        numbers.printInorder();
        System.out.println();
        
        System.out.println();
        System.out.println("Print sideways");
        numbers.printSideways();
        System.out.println("Overall root: " + numbers.getOverallRoot().data);
        System.out.println("Minimum value: " + numbers.getMin());
    }

}
