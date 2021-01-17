package chapter3;

public class MyQueue<T> {
  Stack<T> oldItems = new Stack<T>();
  Stack<T> newItems = new Stack<T>();

  public void push(T data) {
    newItems.push(data);
  }

  public T pop() {
    // shift;
    T item;
    if (oldItems.isEmpty())
      while ((item = newItems.pop()) != null) {
        oldItems.push(item);
      }

    return oldItems.pop();
  }

  // public T popAt(int index) {
  // for (int i = 0; i < index; i++) {

  // }
  // }

  public static void main(String[] args) {
    MyQueue<Integer> queue = new MyQueue<Integer>();
    queue.push(3);
    queue.push(4);
    queue.push(5);
    System.out.println(queue.pop());
    queue.push(6);
    queue.push(7);
    queue.push(8);

    System.out.println(queue.pop());
    System.out.println(queue.pop());
    System.out.println(queue.pop());

  }
}
