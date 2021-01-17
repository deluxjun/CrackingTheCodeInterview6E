package chapter4;

import java.util.LinkedList;

import chapter4.Graph.Node;
import chapter4.Graph.State;

/**
 * 4_1_IsExistPath
 */
public class Q4_2_CreateMinimalBST {
  public static <T> TreeNode<T> createMinimalBST(T arr[], int start, int end) {
    if (start > end)
      return null;
    int mid = (start + end) / 2;
    TreeNode<T> t = new TreeNode<T>(arr[mid]);
    t.left = createMinimalBST(arr, start, mid - 1);
    t.right = createMinimalBST(arr, mid + 1, end);
    return t;
  }

  public static void printTree(TreeNode tree) {
    if (tree != null) {
      System.out.print(tree + ",");
    }
    if (tree.left != null) {
      printTree(tree.left);
    }
    if (tree.right != null) {
      printTree(tree.right);
    }
    System.out.println();
  }

  public static void main(String[] args) {
    TreeNode<Integer> tree = Q4_2_CreateMinimalBST.<Integer>createMinimalBST(new Integer[] { 0, 1, 2, 3, 4, 5 }, 0, 5);

    Q4_2_CreateMinimalBST.printTree(tree);

  }
}