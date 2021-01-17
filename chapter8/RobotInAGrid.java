package chapter8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

// If we start from 0,0 position, then this problem is more difficult. because what if the last position(r-1 or c-1) is off limits?
// So, we think of processing from r,c
// we are using boolean array. map[r][c], r : row, c : column

public class RobotInAGrid {
  // draw grid
  public static void drawPath(boolean map[][], ArrayList<Point> path) {
    for (int r = 0; r < map.length; r++) {
      for (int c = 0; c < map[r].length; c++) {
        System.out.print(map[r][c] ? "B" : "O");
      }
      System.out.println();
    }

    for (Point p : path) {
      System.out.print(p.row + "," + p.col + " | ");
    }
  }

  // make grid
  public static boolean[][] initMap(int row, int col, int off) {
    boolean map[][] = new boolean[row][col];
    Random random = new Random(System.currentTimeMillis());
    for (int i = 0; i < off; i++) {
      int r = random.nextInt(row - 1);
      int c = random.nextInt(col - 1);
      map[r][c] = true;
    }
    return map;
  }

  // getPath
  public static ArrayList<Point> getPath(boolean map[][]) {
    ArrayList<Point> path = new ArrayList<Point>();
    HashSet<Point> skips = new HashSet<>(); // points to skip, because already has been searched.

    getPath(path, map, map.length - 1, map[0].length - 1, skips);

    return path;
  }

  public static boolean getPath(ArrayList<Point> path, boolean map[][], int r, int c, HashSet skips) {
    if (r < 0 || c < 0 || map[r][c] == true) { // off limits or out of range
      return false;
    }
    Point p = new Point(r, c);
    if (skips.contains(p))
      return false;

    // check goal
    boolean atGoal = (r == 0) && (c == 0);

    if (atGoal || getPath(path, map, r - 1, c, skips) || getPath(path, map, r, c - 1, skips)) {
      path.add(p);
      return true;
    }

    skips.add(p);
    return false;
  }

  public static class Point {
    int row;
    int col;

    public Point(int r, int c) {
      row = r;
      col = c;
    }
  }

  public static void main(String[] args) {
    boolean map[][] = RobotInAGrid.initMap(70, 70, 300);

    ArrayList<Point> path = RobotInAGrid.getPath(map);

    RobotInAGrid.drawPath(map, path);
  }
}
