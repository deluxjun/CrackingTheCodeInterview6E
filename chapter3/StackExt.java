package chapter3;

public class StackExt extends Stack<Integer> {
  // int min = Integer.MAX_VALUE;
  Stack<Integer> min = new Stack<Integer>();

  public StackExt() {
    super();
  }

  @Override
  public void push(Integer data) {
    super.push(data);
    Integer minData = min.peek();
    if (minData == null)
      minData = Integer.MAX_VALUE;
    if (data < minData)
      this.min.push(data);
  }

  @Override
  public Integer pop() {
    Integer r = super.pop();
    Integer minData = min.peek();
    if (r == minData)
      this.min.pop();

    return r;
  }

  public Integer min() {
    return min.peek();
  }

  public static void main(String[] args) {
    StackExt stack = new StackExt();
    stack.push(3);
    stack.push(4);
    stack.push(6);
    stack.push(2);
    stack.push(5);
    stack.pop();
    stack.pop();
    System.out.println(stack.min());
  }

}
