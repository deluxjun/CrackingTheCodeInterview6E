package chapter4;

public class Graph {
  public static int MAX_NODE = 100;
  private Node nodes[];
  private int count = 0;

  public Graph() {
    this.nodes = new Node[MAX_NODE];
  }

  public void addNode(Node a) {
    if (count >= nodes.length)
      throw new RuntimeException("Graph is full");
    this.nodes[count++] = a;
  }

  public Node[] getNodes() {
    return nodes;
  }

  public static enum State {
    Visited, Unvisited, Child
  }

  //
  public static class Node {
    private Node adjacent[];
    private int count = 0;
    private String name;
    State state = State.Unvisited;

    public Node(String name, int adjacentLength) {
      adjacent = new Node[adjacentLength];
      this.name = name;
    }

    public void addAdjacent(Node a) {
      if (count >= adjacent.length)
        throw new RuntimeException("Node is full");
      adjacent[count++] = a;
      a.state = State.Child;
    }

    public Node[] getAdjacent() {
      return adjacent;
    }

    public String getName() {
      return name;
    }

    @Override
    public String toString() {
      return name;
    }
  }
}
