import java.util.Scanner;
public class ClientBST {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
    Integer num;
    System.out.print("Enter integers(999 to stop): ");
    num = getInt(input);
    System.out.println("Utilizing iterative insertion method...");
    while (num != 999) {
      bst.insert(num);
      num = getInt(input);
    }
    System.out.println("Tree Height: " + bst.treeHeight());
    System.out.print("Enter value to search for: ");
    num = getInt(input);
    if(bst.search(num)) {
      System.out.println(num + " was found in this tree.");
    } else {
      System.out.println(num + " was NOT found in this tree.");
    }
    System.out.print("Inorder traversal: (recursive) ");
    bst.inOrderTraversal();
    System.out.print("Inorder traversal: (iterative) ");
    bst.iterativeInOrderTraversal();
    System.out.print("\nPreorder traversal: (recursive) ");
    bst.preOrderTraversal();
    System.out.print("\nPreorder traversal: (iterative) ");
    bst.iterativePreOrderTraversal();
    System.out.print("\nPostorder traversal: (recursive) ");
    bst.postOrderTraversal();
    System.out.print("\nPostorder traversal: (iterative) ");
    bst.iterativePostOrderTraversal();
    System.out.print("\nEnter value to be deleted from tree: ");
    num = getInt(input);
    System.out.print("\nUtilizing iterative deletion method...");
    bst.deleteWithRec(num);
    System.out.print("\nInorder traversal (recursive) after removing " + num + ": ");
    bst.inOrderTraversal();
    System.out.print("\nPreorder traversal (recursive) after removing " + num + ": ");
    bst.preOrderTraversal();
    System.out.print("\nPostorder traversal (recursive) after removing " + num + ": ");
    bst.postOrderTraversal();
    System.out.println();
    System.out.print("\nTesting the ITERATIVE leavesCount() method. The number of leaves is: " + bst.iterativeTreeLeavesCount());
    System.out.print("\nTesting the RECURSIVE recLeavesCount() method. The number of leaves is: " + bst.recTreeLeavesCount());
    System.out.print("\nTesting treeNodeCount() method. The number of nodes is: " + bst.treeNodeCount());
  }
    
    public static int getInt(Scanner input) {
      int num = 0;
      while (!input.hasNextInt()) {
        System.out.println("Invalid input. Required: int");
        input.next();
      }
      num = input.nextInt();
      return num;
    }
}
    