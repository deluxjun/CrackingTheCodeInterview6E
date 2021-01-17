package chapter4;

/**
 * 4_1_IsExistPath
 */
public class Q4_8_CommonAncestor {
  public static int getDepth(TreeNode<Integer> n) {
    int d = 0;
    int left = -1;
    TreeNode<Integer> prev = n;
    while (n != null) {
      d++;
      // n is root
      if (n.parent == null && n != prev) {
        if (prev == n.left) {
          left = -1;
        } else if (prev == n.right) {
          left = 1;
        }
      }
      prev = n;
      n = n.parent;
    }

    return left * d;
  }

  public static TreeNode<Integer> getCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> n1,
      TreeNode<Integer> n2) {
    TreeNode<Integer> found = null;

    int d1 = getDepth(n1);
    int d2 = getDepth(n2);
    int side1 = (d1 < 0) ? -1 : 1;
    int side2 = (d2 < 0) ? -1 : 1;
    int abs1 = Math.abs(d1);
    int abs2 = Math.abs(d2);

    // root
    if (abs1 == 1 || abs2 == 1)
      return root;

    // different side
    if (side1 * side2 < 0)
      return root;

    int differ = Math.abs(abs1 - abs2);
    TreeNode<Integer> lower = n1;
    TreeNode<Integer> higher = n1;

    if (abs1 > abs2) {
      lower = n1;
      higher = n2;
    } else {
      lower = n2;
      higher = n1;
    }

    for (int i = 0; i < differ; i++) {
      lower = lower.parent;
    }
    while (lower != higher) {
      lower = lower.parent;
      higher = higher.parent;
    }

    return lower;
  }

  public static void main(String[] args) {
    TreeNode<Integer> n1 = new TreeNode<Integer>(1);
    TreeNode<Integer> n2 = new TreeNode<Integer>(2);
    TreeNode<Integer> n3 = new TreeNode<Integer>(3);
    TreeNode<Integer> n4 = new TreeNode<Integer>(4);
    TreeNode<Integer> n5 = new TreeNode<Integer>(5);
    TreeNode<Integer> n6 = new TreeNode<Integer>(6);
    TreeNode<Integer> n7 = new TreeNode<Integer>(7);
    TreeNode<Integer> n8 = new TreeNode<Integer>(8);
    TreeNode<Integer> n9 = new TreeNode<Integer>(9);
    TreeNode<Integer> n10 = new TreeNode<Integer>(10);

    n1.setLeft(n2);
    n1.setRight(n3);
    n2.setLeft(n4);
    n2.setRight(n5);
    n3.setLeft(n6);
    n3.setRight(n7);
    n4.setLeft(n8);
    n4.setRight(n9);
    n7.setLeft(n10);

    System.out.println(Q4_8_CommonAncestor.getCommonAncestor(n1, n4, n10));
    // System.out.println(Q4_8_CommonAncestor.getDepth(n9));
    // System.out.println(Q4_8_CommonAncestor.getDepth(n5));
    // System.out.println(Q4_8_CommonAncestor.getDepth(n1));
  }
}