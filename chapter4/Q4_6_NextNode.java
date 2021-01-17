package chapter4;

/**
 * 4_1_IsExistPath
 */
public class Q4_6_NextNode {

  public static TreeNode<Integer> getNextNode(TreeNode<Integer> node) {
    if (node.right != null) {
      // search lowest left
      TreeNode<Integer> lastLeft = node.right;
      while (lastLeft.left != null) {
        lastLeft = lastLeft.left;
      }
      return lastLeft;
    } else {
      TreeNode<Integer> parent = node.parent;
      TreeNode<Integer> me = node;
      while (parent != null) {
        if (parent.left == me)
          return parent;
        me = parent;
        parent = parent.parent;
      }
      return null;
    }
  }

  public static void main(String[] args) {
    // TreeNode<Integer> n1 = new TreeNode<Integer>(1);
    // TreeNode<Integer> n2 = new TreeNode<Integer>(2);
    // TreeNode<Integer> n3 = new TreeNode<Integer>(3);
    // TreeNode<Integer> n4 = new TreeNode<Integer>(4);
    // TreeNode<Integer> n5 = new TreeNode<Integer>(5);
    // TreeNode<Integer> n6 = new TreeNode<Integer>(6);
    // TreeNode<Integer> n7 = new TreeNode<Integer>(7);

    // n1.left = n2;
    // n1.right = n3;
    // n2.left = n4;
    // n2.right = n5;
    // n3.right = n6;
    // n6.left = n7;

    // System.out.println(Q4_5_IsBST.IsBST(n1));
    TreeNode<Integer> n0 = new TreeNode<Integer>(0);
    TreeNode<Integer> n1 = new TreeNode<Integer>(1);
    TreeNode<Integer> n2 = new TreeNode<Integer>(2);
    TreeNode<Integer> n3 = new TreeNode<Integer>(3);
    TreeNode<Integer> n4 = new TreeNode<Integer>(4);
    TreeNode<Integer> n5 = new TreeNode<Integer>(5);
    TreeNode<Integer> n6 = new TreeNode<Integer>(6);
    TreeNode<Integer> n7 = new TreeNode<Integer>(7);
    TreeNode<Integer> n8 = new TreeNode<Integer>(8);

    n5.setLeft(n2);
    n5.setRight(n7);
    n2.setLeft(n0);
    n2.setRight(n4);
    n0.setRight(n1);
    n4.setLeft(n3);

    n7.setLeft(n6);
    n7.setRight(n8);

    System.out.println(Q4_6_NextNode.getNextNode(n2));
    System.out.println(Q4_6_NextNode.getNextNode(n4));
    System.out.println(Q4_6_NextNode.getNextNode(n1));
    System.out.println(Q4_6_NextNode.getNextNode(n6));

  }
}