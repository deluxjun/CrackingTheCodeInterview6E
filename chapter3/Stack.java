package chapter3;

public class Stack<T> {
  StackNode<T> top;
  int size = 0;

  public static class StackNode<T> {
    T data;
    StackNode<T> next;

    public StackNode(T data) {
      this.data = data;
    }
  }

  public Stack() {
  }

  public Stack(T... items) {
    for (T t : items) {
      this.push(t);
    }
  }

  public void push(T data) {
    StackNode<T> t = new StackNode<T>(data);
    t.next = top;
    top = t;
    size++;
  }

  public T peek() {
    if (top == null)
      return null;
    return top.data;
  }

  public T pop() {
    if (top == null)
      return null;
    T rdata = top.data;
    top = top.next;
    size--;
    return rdata;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int getSize() {
    return size;
  }

  @Override
  public String toString() {
    StringBuffer b = new StringBuffer();
    StackNode node = top;
    b.append(node.data);
    while (node.next != null) {
      b.append(" > " + node.next.data);
      node = node.next;
    }
    return b.toString();
  }

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(3);
    stack.push(4);
    stack.push(6);
    System.out.println(stack.toString());

    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }
}
