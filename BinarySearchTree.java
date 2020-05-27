public class BinarySearchTree<T> extends BinaryTree<T> {
  
  public BinarySearchTree() {
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
  
  public int iterativeTreeLeavesCount() {
    return leavesCount(root);
  }
  
  private int leavesCount(BinaryTreeNode<T> t) {
    int count = 0;
    BinaryTreeNode<T> reset = t;
    BinaryTreeNode<T> previous = null;
    if (t == null) {
      return 0;
    } else if (t.lLink == null && t.rLink == null) {
      return 1;
    }
    while (t.lLink != null) {
      previous = t;
      t = t.lLink;
      count++;
    }
    t = reset;
    while (t.rLink != null) {
      previous = t;
      t = t.rLink;
      count++;
    }
    return count;
  }
  
  public int recTreeLeavesCount() {
    return recLeavesCount(root);
  }
  
  private int recLeavesCount(BinaryTreeNode<T> t) {
    if (t == null) {
      return 0;
    }
    if (t.lLink == null && t.rLink == null) {
      return 1;
    } else {
      return recLeavesCount(t.lLink) + recLeavesCount(t.rLink);
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
  
  public boolean search(T item) {
    return recSearch(root, item);
  }
  
  public boolean recSearch(BinaryTreeNode<T> tree, T item) {
    if (tree == null) {
      return false;
    }
    else {
      Comparable<T> temp = (Comparable<T>) tree.info;
      if (temp.compareTo(item) == 0) {
        return true;
      } else if (temp.compareTo(item) > 0) {
        return recSearch(tree.lLink, item);
      } else {
        return recSearch(tree.rLink, item);
      }
    }
  }
  
  public void insert(T item) {
    if (root == null) {
      root = new BinaryTreeNode<T>(item, null, null);
      return;
    }
    BinaryTreeNode<T> current = root;
    BinaryTreeNode<T> parent = root;
    while (current != null) {
      Comparable<T> temp = (Comparable<T>) current.info;
      if (temp.compareTo(item) > 0) {
        parent = current;
        current = current.lLink;
      }
      else {
        parent = current;
        current = current.rLink;
      }
    }
    BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(item, null, null);
    Comparable<T> temp = (Comparable<T>) parent.info;
    if (temp.compareTo(item) > 0) {
      parent.lLink = newNode;
    }
    if (temp.compareTo(item) < 0) {
      parent.rLink = newNode;
    }
  }
  
  public void insertWithRec(T item) {
    root = recInsert(root, item);
  }
  
  public BinaryTreeNode<T> recInsert(BinaryTreeNode<T> tree, T item) {
    if (tree == null) {
      tree = new BinaryTreeNode<T>(item); 
    } else {
      Comparable<T> temp = (Comparable<T>) tree.info;
      if (temp.compareTo(item) == 0) {
        System.err.print("Already in - duplicates are not allowed.");
        return null;
      } else if (temp.compareTo(item) > 0) {
        tree.lLink = recInsert(tree.lLink, item);
      } else {
        tree.rLink = recInsert(tree.rLink, item);
      }
    }
    return tree;
  }
  
  public void delete(T deleteItem) {
    BinaryTreeNode<T> current;
    BinaryTreeNode<T> trailCurrent;
    boolean found = false;
    if (root == null) {
      System.out.println("Error, cannot delete from an empty tree.");
    }
    else {
      current = root;
      trailCurrent = root;
      while (current != null && !found) {
        trailCurrent = current;
        Comparable<T> temp = (Comparable<T>) current.info;
        if (temp.compareTo(deleteItem) == 0) 
          found = true;
        else if (temp.compareTo(deleteItem) > 0)
          current = current.lLink;
        else
          current = current.rLink;
      }
      if (current == null) {
        System.out.println("The delete item is not in the tree.");
      }
      else if (found) {
        if (current == root) {
          root = deleteFromTree(root);
        }
        else {
          Comparable<T> temp = (Comparable<T>) trailCurrent.info;
          if (temp.compareTo(deleteItem) > 0) {
            trailCurrent.lLink = deleteFromTree(trailCurrent.lLink);
          }
          else {
            trailCurrent.rLink = deleteFromTree(trailCurrent.rLink);
          }
        }
      }
    }
  }
  
  public BinaryTreeNode<T> deleteFromTree(BinaryTreeNode<T> root) {
    BinaryTreeNode<T> current;
    BinaryTreeNode<T> trailCurrent;
    
    if (root == null) {
      System.out.println("Error, cannot delete from an empty tree!");
    }
    else {
      current = root;
      trailCurrent = root;
      
      if (root.lLink == null && root.rLink == null) {
        root = null;
      }
      else if (root.lLink == null) {
        root = root.lLink;
      }
      else if (root.rLink == null) {
        root = root.rLink;
      }
      else {
        current = root.lLink;
        trailCurrent = null;
      }
      while (current.rLink != null) {
        trailCurrent = current;
        current = current.rLink;
      }
      root.info = current.info;
      if (trailCurrent == null) {
        root.lLink = current.lLink;
      }
      else {
        trailCurrent.rLink = current.lLink;
      }
    }
    return root;
  }
    
    public void deleteWithRec(T item) {
      root = recDelete(root, item);
    }
    
    public BinaryTreeNode<T> recDelete(BinaryTreeNode<T> tree, T item) {
      if (tree == null) {
        System.err.println("Cannot delete from an empty tree.");
      } else {
        Comparable<T> temp = (Comparable<T>) tree.info;
        if (temp.compareTo(item) > 0) {
          tree.lLink = recDelete(tree.lLink, item);
        } 
        else if (temp.compareTo(item) < 0) {
          tree.rLink = recDelete(tree.rLink, item);
        }
        else if (tree.lLink != null && tree.rLink != null) {
          tree.info = findMin(tree.rLink).info;
          tree.rLink = removeMin(tree.rLink);
        }
        else if (root.lLink != null) {
          tree = tree.lLink;
        }
        else if (root.rLink != null) {
          tree = tree.rLink;
        }
      }
      return tree;
    }
    
    protected BinaryTreeNode<T> findMin(BinaryTreeNode<T> tree) {
      if (tree != null) {
        while (tree.lLink != null) {
          tree = tree.lLink;
        }
      }
      return tree;
    }
    
    protected BinaryTreeNode<T> removeMin(BinaryTreeNode<T> tree) {
      if (tree == null) {
        System.err.println("Cannot delete from an empty tree.");
        return null;
      }
      else if(tree.lLink != null) {
        tree.lLink = removeMin(tree.lLink);
        return tree;
      }
      else {
        return tree.rLink;
      }
    }
}
  
  
  
