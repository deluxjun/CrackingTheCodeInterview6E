package lib;

public class LinkedListNode {
  public LinkedListNode next;
  public LinkedListNode prev;
  public LinkedListNode last;
  public int data;

  public LinkedListNode(int d, LinkedListNode n, LinkedListNode p) {
    data = d;
    next = n;
    prev = p;
    if (next == null)
      last = this;
  }

  public LinkedListNode(int d, LinkedListNode n) {
    this(d, n, null);
  }

  public LinkedListNode addToLast(int d) {
    LinkedListNode newNode = new LinkedListNode(d, null);
    this.last.next = newNode;
    this.last = newNode;
    return newNode;
  }

  public LinkedListNode insert(int d) {
    LinkedListNode newNode = new LinkedListNode(d, null);
    newNode.next = this.next;
    this.next = newNode;
    // if this is last, change it
    if (this.last == this) {
      this.last = this.next;
    } else {
      newNode.last = this.last;
    }
    return newNode;
  }

  public LinkedListNode insertBefore(int d) {
    LinkedListNode newNode = new LinkedListNode(d, null);
    newNode.next = this;
    newNode.last = this.last;

    return newNode;
  }

  public LinkedListNode padLeft(int count, int data) {
    LinkedListNode head = this;
    while (count-- > 0) {
      head = head.insertBefore(data);
    }
    return head;
  }

  public LinkedListNode addToLast(int[] numbers) {
    LinkedListNode node = this;
    for (int i : numbers) {
      node.addToLast(i);
    }
    return node;
  }

  public int length() {
    LinkedListNode node = this;
    int len = 1;
    node = node.next;
    while (node != null) {
      len++;
      node = node.next;
    }
    return len;
  }

  public static LinkedListNode init(int... numbers) {
    if (numbers == null || numbers.length < 1) {
      System.err.println("Illegal argument");
      return null;
    }
    LinkedListNode head = new LinkedListNode(numbers[0], null);
    for (int i = 1; i < numbers.length; i++) {
      head.addToLast(numbers[i]);
    }
    return head;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.data);
    LinkedListNode node = this.next;
    while (node != null) {
      sb.append(" -> " + node.data);
      node = node.next;
    }
    return sb.toString();
  }

}
