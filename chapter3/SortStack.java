package chapter3;

public class SortStack {

  public static Stack<Integer> sort(Stack<Integer> a) {
    Stack<Integer> b = new Stack<Integer>();
    while (!a.isEmpty()) {
      Integer t = a.pop();
      // a pop 이 b 의 pop 계속해서 클동안 다 a에 푸시
      while (!b.isEmpty() && t < b.peek()) {
        a.push(b.pop());
      }
      b.push(t);
    }
    return b;
  }

  // public T popAt(int index) {
  // for (int i = 0; i < index; i++) {

  // }
  // }

  // 3 > 1 > 6 > 5 > 2 > 4
  // 1 > 2 > 3 > 4 > 5 > 6

  // a : 3 > 1 > 6 > 5 > 2
  // b : 4

  // a : 3 > 1 > 6 > 5 > 4
  // b : 2

  // a : 3 > 1
  // b : 2 > 4 > 5 > 6

  // a : 3
  // b : 1 > 2 > 4 > 5 > 6

  // a : 6 > 5
  // b : 1 > 2 > 3

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>(3, 1, 6, 5, 2, 4);
    System.out.println(SortStack.sort(stack));
  }
}
