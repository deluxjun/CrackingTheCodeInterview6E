package chapter4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 4_1_IsExistPath
 */
public class Q4_4_Balanced {

  public static <T> int checkBalanced(TreeNode<T> node) {
    if (node == null)
      return -1;

    int leftHeight = checkBalanced(node.left);
    int rightHeight = checkBalanced(node.right);

    if (Math.abs(leftHeight - rightHeight) > 1)
      throw new RuntimeException("Unbalanced Tree");

    return Math.max(leftHeight, rightHeight) + 1;
  }

  public static void main(String[] args) {
    TreeNode<Integer> n1 = new TreeNode<Integer>(1);
    TreeNode<Integer> n2 = new TreeNode<Integer>(2);
    TreeNode<Integer> n3 = new TreeNode<Integer>(3);
    TreeNode<Integer> n4 = new TreeNode<Integer>(4);
    TreeNode<Integer> n5 = new TreeNode<Integer>(5);
    TreeNode<Integer> n6 = new TreeNode<Integer>(6);
    TreeNode<Integer> n7 = new TreeNode<Integer>(7);

    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    n3.right = n6;
    n6.left = n7;

    int height = Q4_4_Balanced.<Integer>checkBalanced(n1);

    System.out.println(height);

  }
}