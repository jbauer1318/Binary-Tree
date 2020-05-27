import java.util.NoSuchElementException;
public abstract class BinaryTree<T> implements BinaryTreeADT<T> {
  protected class BinaryTreeNode<T> {
    public T info;
    public BinaryTreeNode<T> lLink;
    public BinaryTreeNode<T> rLink;
    
    public BinaryTreeNode() {
      info = null;
      lLink = null;
      rLink = null;
    }
    
    public BinaryTreeNode(T item) {
      info = item;
      lLink = null;
      rLink = null;
    }
    
    public BinaryTreeNode(T item, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
      info = item;
      lLink = left;
      rLink = right;
    }
    
    public Object clone() {
      BinaryTreeNode<T> copy = null;
      try {
        copy = (BinaryTreeNode<T>) super.clone();
      } catch (CloneNotSupportedException e) {
        return null;
      } 
      return copy;
    }
    public String toString() {
      return info.toString();
    }
  }
  
  protected BinaryTreeNode<T> root;
  
  public BinaryTree() {
    root = null;
  }
  
  public Object clone() {
    BinaryTree<T> copy = null;
    try {
      copy = (BinaryTree<T>) super.clone();
    } catch (CloneNotSupportedException e) {
      return null;
    }
    if (root != null) {
      copy.root = copyTree(root);
    }
    return copy;
  }
  
  private BinaryTreeNode<T> copyTree(BinaryTreeNode<T> otherTreeRoot) {
    BinaryTreeNode<T> temp;
    if (otherTreeRoot == null) {
      temp = null;
    } else {
      temp = (BinaryTreeNode<T>) otherTreeRoot.clone();
      temp.lLink = copyTree(otherTreeRoot.lLink);
      temp.rLink = copyTree(otherTreeRoot.rLink);
    }
    return temp;
  }
  
  public boolean isEmpty() {
    return (root == null);
  }
  
  public void inOrderTraversal() {
    inOrder(root);
  }
  
  private void inOrder(BinaryTreeNode<T> t) {
    if (t != null) {
      inOrder(t.lLink);
      System.out.print(t.info + " ");
      inOrder(t.rLink);
    }
  }
  
  public void iterativeInOrderTraversal() {
    iterativeInOrder(root);
  }
  
  private void iterativeInOrder(BinaryTreeNode<T> t) {
    BinaryTreeNode<T> current = t;
    BinaryTreeNode<T> pre;
    while (current != null) {
      if (current.lLink == null) {
        System.out.print(current.info + " ");
        current = current.rLink;
      }
      else {
      pre = current.lLink;
      while (pre.rLink != null && pre.rLink != current) {
        pre = pre.rLink;
      }
      if (pre.rLink == null) {
        pre.rLink = current;
        current = current.lLink;
      }
      
      else {
        pre.rLink = null;
        System.out.print(current.info + " ");
        current = current.rLink;
      }
      }
    }
  }
  
  public void iterativePreOrderTraversal() {
    iterativePreOrder(root);
  }
  
  private void iterativePreOrder(BinaryTreeNode<T> t) {
    while (t != null) {
      if (t.lLink == null) {
        System.out.print(t.info + " ");
        t = t.rLink;
      }
      else {
        BinaryTreeNode<T> current = t.lLink;
        while (current.rLink != null && current.rLink != t) {
          current = current.rLink;
        }
        
        if (current.rLink == t) {
          current.rLink = null;
          t = t.rLink;
        }
        
        else {
          System.out.print(t.info + " ");
          current.rLink = t;
          t = t.lLink;
        }
      }
    }
  }
      

public void preOrderTraversal() {
  preOrder(root);
}

private void preOrder(BinaryTreeNode<T> t) {
  if (t != null) {
    System.out.print(t.info + " ");
    preOrder(t.lLink);
    preOrder(t.rLink);
  }
}

public void iterativePostOrderTraversal() {
  iterativePostOrder(root);
}

private void iterativePostOrder(BinaryTreeNode<T> t) {
  while (t != null) {
      if (t.lLink == null) {
        System.out.print(t.info + " ");
        t = t.rLink;
      }
      else {
        BinaryTreeNode<T> current = t.lLink;
        while (current.rLink != null && current.rLink != t) {
          current = current.rLink;
        }
        
        if (current.rLink == t) {
          current.rLink = null;
          t = t.rLink;
        }
        
        else {
          System.out.print(t.info + " ");
          current.rLink = t;
          t = t.lLink;
        }
      }
    }
  }


public void postOrderTraversal() {
  postOrder(root);
}

private void postOrder(BinaryTreeNode<T> t) {
  if (t != null) {
    postOrder(t.lLink);
    postOrder(t.rLink);
    System.out.print(t.info + " ");
  }
}


public int treeHeight() {
  return height(root);
}

private int height(BinaryTreeNode<T> t) {
  if (t == null) {
    return 0;
  } else if (t.lLink == null && t.rLink == null) {
    return 0;
  } else {
    return 1 + Math.max(height(t.lLink), height(t.rLink));
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

public int treeLeavesCount() {
  return leavesCount(root);
}

private int leavesCount(BinaryTreeNode<T> t) {
  System.out.println("To be done later.");
  return 0;
}

public void destroyTree() {
  root = null;
}

public abstract boolean search(T item);
public abstract void insert(T item);
public abstract void delete(T item);
}
  
  
      