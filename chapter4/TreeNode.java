package chapter4;

public class TreeNode<T> {
  public TreeNode<T> left;
  public TreeNode<T> right;
  public TreeNode<T> parent;
  public T value;

  public TreeNode(T data) {
    value = data;
  }

  @Override
  public String toString() {
    if (value != null)
      return value.toString();
    return "";
  }

  public void setLeft(TreeNode<T> left) {
    this.left = left;
    left.parent = this;
  }

  public void setRight(TreeNode<T> right) {
    this.right = right;
    right.parent = this;
  }

  public static <T> TreeNode<T> createMinimalBST(T arr[], int start, int end) {
    if (start > end)
      return null;
    int mid = (start + end) / 2;
    TreeNode<T> t = new TreeNode<T>(arr[mid]);
    t.left = createMinimalBST(arr, start, mid - 1);
    t.right = createMinimalBST(arr, mid + 1, end);
    return t;
  }

}
