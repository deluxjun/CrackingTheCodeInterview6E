package chapter2;

import lib.LinkedListNode;

public class P2_5 {
  public static LinkedListNode sum(LinkedListNode n1, LinkedListNode n2) {
    LinkedListNode result = null;

    int over = 0;

    while (n1 != null || n2 != null) {
      int data1 = (n1 != null) ? n1.data : 0;
      int data2 = (n2 != null) ? n2.data : 0;

      int sum = data1 + data2;
      int one = (sum) % 10;

      if (result == null)
        result = new LinkedListNode(one, null);
      else {
        result.addToLast(one + over); // add ten position
      }

      over = (sum >= 10) ? 1 : 0;

      // go to next
      if (n1 != null)
        n1 = n1.next;
      if (n2 != null)
        n2 = n2.next;
    }

    return result;
  }

  public static LinkedListNode sumInvert(LinkedListNode n1, LinkedListNode n2) {
    int n1Len = n1.length();
    int n2Len = n2.length();

    int maxLen = (n1Len > n2Len) ? n1Len : n2Len;
    n1 = n1.padLeft(maxLen - n1Len, 0); // changed new head
    n2 = n2.padLeft(maxLen - n2Len, 0);

    Pair pair = carrySum(n1, n2);

    return pair.node;
  }

  public static Pair carrySum(LinkedListNode n1, LinkedListNode n2) {
    if (n1 == null && n2 == null)
      return new Pair(null, false);

    Pair nextPair = carrySum(n1.next, n2.next);
    int sum = n1.data + n2.data;

    if (nextPair.node != null) { // not last
      if (nextPair.carry)
        sum++;
      nextPair.node = new LinkedListNode(sum % 10, nextPair.node);
    } else { // last
      nextPair.node = new LinkedListNode(sum % 10, null);
    }

    nextPair.carry = (sum >= 10);

    return nextPair;
  }

  public static class Pair {
    LinkedListNode node;
    boolean carry;

    public Pair(LinkedListNode node, boolean carry) {
      this.node = node;
      this.carry = carry;
    }
  }

  public static void main(String[] args) {
    LinkedListNode n1 = LinkedListNode.init(1, 6);
    LinkedListNode n2 = LinkedListNode.init(5, 9, 2);
    System.out.println(n1);
    System.out.println(n2);
    // System.out.println(sum(n1, n2)); // 61 + 295 = 356, 6 -> 5 -> 3
    System.out.println(sumInvert(n1, n2)); // 016 + 592 = 608, 6 -> 0 -> 8
    sumInvert(n1, n2);
    System.out.println(n1);
    System.out.println(n2);

  }
}
