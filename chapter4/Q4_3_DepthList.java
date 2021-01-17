package chapter4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 4_1_IsExistPath
 */
public class Q4_3_DepthList {

  public static void makeDepthList(TreeNode<Integer> node, Map<Integer, List> lists, int depth) {
    if (node == null)
      return;
    List one = lists.get(depth);
    if (one == null) {
      one = new LinkedList<>();
      lists.put(depth, one);
    }
    one.add(node);
    makeDepthList(node.left, lists, depth + 1);
    makeDepthList(node.right, lists, depth + 1);
  }

  public static void main(String[] args) {
    TreeNode<Integer> n1 = new TreeNode<Integer>(1);
    TreeNode<Integer> n2 = new TreeNode<Integer>(2);
    TreeNode<Integer> n3 = new TreeNode<Integer>(3);
    TreeNode<Integer> n4 = new TreeNode<Integer>(4);
    TreeNode<Integer> n5 = new TreeNode<Integer>(5);
    TreeNode<Integer> n6 = new TreeNode<Integer>(6);

    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    n3.right = n6;

    Map<Integer, List> lists = new HashMap<Integer, List>();
    Q4_3_DepthList.makeDepthList(n1, lists, 0);

    System.out.println(lists);

  }
}