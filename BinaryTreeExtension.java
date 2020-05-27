public abstract class BinaryTreeExtension<T> extends BinaryTree<T> {
  
  public BinaryTreeExtension() {
    super();
  }
  
  public boolean isBinarySearchTree() {
    return isBST(root);
  }
  
  public boolean isBST(BinaryTreeNode<T> t) {
    if (t != null) {
      Comparable<T> tmp = (Comparable<T>) t.info;
      return (tmp.compareTo(t.rLink.info) < 0 && tmp.compareTo(t.lLink.info) > 0 && isBST(t.lLink) && isBST(t.rLink));
    }
    return true;
  }
  
  public boolean similarTrees(BinaryTreeNode<T> otherTree) {
    return similar(root, otherTree);
  }
  
  public boolean similar(BinaryTreeNode<T> tree1, BinaryTreeNode<T> tree2) {
    if (tree1 == null && tree2 == null) {
      return true;
    } else if ((tree1 == null && tree2 != null) || (tree1 != null && tree2 == null)) {
     return false;
    } else {
      return similar(tree1.lLink, tree2.lLink) && similar(tree1.rLink, tree2.rLink); 
    }
  }
  
  public int treeLeavesCount() {
    return leavesCount(root);
  }
  
  private int leavesCount(BinaryTreeNode<T> t) {
    if (t == null) {
      return 0;
    }
    if (t.lLink == null && t.rLink == null) {
      return 1;
    } else {
      return leavesCount(t.lLink) + leavesCount(t.rLink);
    }
  }
  
  public int treeNodeCount() {
    return nodeCount(root);
  }
  
  private int nodeCount(BinaryTreeNode<T> t) {
    if (t == null) {
      return 0;
    } else {
      return nodeCount(t.lLink) + nodeCount(t.rLink) + 1;
    }
  }
    
  
}  