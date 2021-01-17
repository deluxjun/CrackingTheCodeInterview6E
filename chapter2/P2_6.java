package chapter2;

import java.util.Stack;

import lib.LinkedListNode;

public class P2_6 {
  public static boolean palin(LinkedListNode node) {
    LinkedListNode head2 = node;

    Stack<Integer> stack = new Stack<Integer>();

    int len = node.length();

    // search mid
    int midLen = (len + 1) / 2;
    for (int i = 0; i < midLen; i++) {
      stack.push(head2.data);
      head2 = head2.next;
    }

    // if count is odd, throw away mid value.
    if (len % 2 == 1)
      stack.pop();

    while (head2 != null) {
      if (stack.pop() != head2.data)
        return false;
      head2 = head2.next;
    }
    return true;
  }

  public static void main(String[] args) {
    LinkedListNode n1 = LinkedListNode.init(1, 6, 1, 1, 6, 1);
    System.out.println(palin(n1));
  }
}
