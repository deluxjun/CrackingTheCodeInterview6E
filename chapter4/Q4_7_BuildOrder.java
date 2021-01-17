package chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import chapter4.Graph.Node;
import chapter4.Graph.State;

/**
 * 4_1_IsExistPath
 */
public class Q4_7_BuildOrder {

  public static List<Node> getStarts(Graph g) {
    List<Node> starts = new ArrayList<>();
    for (Node node : g.getNodes()) {
      if (node != null && node.state != State.Child)
        starts.add(node);
    }
    return starts;
  }

  public static void printOrders(List<Node> nodes) {
    Queue<Node> q = new LinkedList<Node>();

    for (Node node : nodes) {
      if (node != null)
        q.add(node);
    }

    while (!q.isEmpty()) {
      Node n = q.poll();
      System.out.println(n + " > ");
      for (Node child : n.getAdjacent()) {
        if (child != null) {
          if (!q.contains(child))
            q.add(child);
        }
      }
    }
  }

  public static void main(String[] args) {
    Node f = new Node("f", 5);
    Node a = new Node("a", 5);
    Node b = new Node("b", 5);
    Node d = new Node("d", 5);
    Node c = new Node("c", 5);
    Node e = new Node("e", 5);
    f.addAdjacent(b);
    f.addAdjacent(a);
    b.addAdjacent(d);
    d.addAdjacent(c);
    a.addAdjacent(d);

    Graph g = new Graph();
    g.addNode(a);
    g.addNode(b);
    g.addNode(c);
    g.addNode(d);
    g.addNode(e);
    g.addNode(f);

    Q4_7_BuildOrder.printOrders(Q4_7_BuildOrder.getStarts(g));
  }
}