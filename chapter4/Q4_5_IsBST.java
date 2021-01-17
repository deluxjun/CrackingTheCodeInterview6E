package chapter4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 4_1_IsExistPath
 */
public class Q4_5_IsBST {

  public static int IsBST(TreeNode<Integer> node, int side) {
    // if (node == null)
    // return true;

    int leftMax = node.value;
    int rightMin = node.value;
    if (node.left != null)
      leftMax = IsBST(node.left, -1);

    if (node.right != null)
      rightMin = IsBST(node.right, 1);

    if (leftMax > node.value)
      throw new RuntimeException("Error left : " + leftMax + "," + node.value);

    if (rightMin < node.value)
      throw new RuntimeException("Error right : " + rightMin + "," + node.value);

    int min = Math.min(Math.min(leftMax, rightMin), node.value);
    int max = Math.max(Math.max(leftMax, rightMin), node.value);
    if (side == -1)
      return max;
    else if (side == 1)
      return min;
    else
      return node.value;

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
    TreeNode<Integer> n1 = new TreeNode<Integer>(1);
    TreeNode<Integer> n2 = new TreeNode<Integer>(2);
    TreeNode<Integer> n3 = new TreeNode<Integer>(3);
    TreeNode<Integer> n4 = new TreeNode<Integer>(4);
    TreeNode<Integer> n5 = new TreeNode<Integer>(5);
    TreeNode<Integer> n6 = new TreeNode<Integer>(6);
    TreeNode<Integer> n7 = new TreeNode<Integer>(7);

    n4.left = n2;
    n4.right = n6;
    n2.left = n1;
    n2.right = n5;
    n6.right = n7;

    System.out.println(Q4_5_IsBST.IsBST(n4, 0));

  }
}