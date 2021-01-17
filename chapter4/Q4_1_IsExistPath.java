package chapter4;

import java.util.LinkedList;

import chapter4.Graph.Node;
import chapter4.Graph.State;

/**
 * 4_1_IsExistPath
 */
public class Q4_1_IsExistPath {

  public static boolean search(Graph g, Node start, Node end) {
    LinkedList<Node> q = new LinkedList<>();

    q.addLast(start);
    start.state = State.Visited;

    while (!q.isEmpty()) {
      Node next = q.poll();
      for (Node child : next.getAdjacent()) {
        if (child == null)
          break;
        if (child.state == State.Unvisited) {
          if (child == end)
            return true;
        }
        q.addLast(child);
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Graph g = new Graph();
    Node n1 = new Node("1", 1);
    Node n2 = new Node("2", 1);
    Node n3 = new Node("3", 2);
    Node n4 = new Node("4", 1);
    n1.addAdjacent(n2);
    n2.addAdjacent(n4);
    n3.addAdjacent(n2);
    n3.addAdjacent(n4);
    // n4.addAdjacent(n2);

    g.addNode(n1);
    g.addNode(n2);
    g.addNode(n3);
    g.addNode(n4);

    System.out.println(Q4_1_IsExistPath.search(g, n1, n4));

  }
}