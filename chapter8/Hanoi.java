package chapter8;

import java.util.Stack;

// move(int n, s, b, t) {
//   if (n == 1) {
//     t.push(s.pop())
//   }
//   move(n-1, s, t, b)
//   t.push(n)
//   move(n-1, b, s, t)

// }

public class Hanoi {
  public static void move(int n, Stack<Integer> s, Stack<Integer> b, Stack<Integer> t) {
    if (n == 1) {
      t.push(s.pop());
      return;
    }
    move(n - 1, s, t, b);
    t.push(s.pop());
    move(n - 1, b, s, t);
    System.out.println("Result / " + n + ", S:" + s + ",B:" + b + ",T:" + t);
  }

  public static void main(String[] args) {
    Stack<Integer> s = new Stack<Integer>();
    Stack<Integer> b = new Stack<Integer>();
    Stack<Integer> t = new Stack<Integer>();
    for (int i = 5; i > 0; i--) {
      s.push(i);
    }
    System.out.println("Init:" + s);

    Hanoi.move(5, s, b, t);
  }
}
