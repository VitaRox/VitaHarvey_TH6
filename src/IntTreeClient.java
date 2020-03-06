import jdk.packager.services.UserJvmOptionsService;

import java.util.*;

/**
 * @author Vita Wiebe
 */
public class IntTreeClient {

    public static void main(String[] args) {
        
        Scanner console = new Scanner(System.in);
        IntSearchTree numbers = new IntSearchTree();
        System.out.println("next int (0 to quit):");
        int number1 = console.nextInt();
        while (number1 != 0) {
            numbers.add(number1);
            System.out.print("");
            number1 = console.nextInt();
        }
        System.out.println();
        System.out.print("");
        
//        IntSearchTree sT = new IntSearchTree();
        System.out.println("Binary search tree structure, sideways:");
        System.out.println();
        numbers.printSideways();
        System.out.println();
        numbers.printInorder();
        System.out.println();
        
//        sT.add(56);
//        sT.add(12);
//        sT.add(79);
//        sT.add(-4);
//        sT.add(999);
//        sT.add(-45);
//        sT.add(68);
        numbers.printInorder();
        System.out.println("Print sideways");
        numbers.printSideways();
    }

}
