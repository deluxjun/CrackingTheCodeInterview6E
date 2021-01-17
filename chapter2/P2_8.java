package chapter2;

import lib.LinkedListNode;

public class P2_8 {

  public static class ValidateNode {
    LinkedListNode node;
    boolean traced;

    public ValidateNode(LinkedListNode node, boolean traced) {
      this.node = node;
      this.traced = traced;
    }
  }
  // public static LinkedListNode searchRotate(LinkedListNode start) {
  // LinkedListNode temp = start;

  // }

  public static void main(String[] args) {
    LinkedListNode n1 = LinkedListNode.init(1, 2, 3, 4, 5);
    LinkedListNode n2 = LinkedListNode.init(6, 7, 8, 9, 10);
    n1.last.next = n2;
    n2.last.next = n1.next.next.next.next;

    // test
    LinkedListNode temp = n1;
    int index = 10;
    while (temp != null && index++ < 100) {
      System.out.println(temp.data);
      System.out.println(temp.hashCode());
      temp = temp.next;
    }

  }
}
