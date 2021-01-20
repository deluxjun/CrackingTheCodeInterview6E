package chapter8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// ArrayList list p(int[] n) {
//   if (n.length < 1)
//     return emptyList;

//   make subset sub = (n-1)
//   preList = p(sub);
//   clonedList.addAll(preList);
//   foreach(sub in preList) {
//     clonedList.add(sub.add(n))
//   }
//   list.addAll(preList);
//   list.addAll(clonedList);
//   return list;
// }

public class Subset {
  // draw grid
  public static List<List<Integer>> subset(int a[]) {
    if (a.length < 1) {
      List<List<Integer>> empty = new ArrayList<>();
      empty.add(new ArrayList<>());
      return empty;
    }

    int[] sub = new int[a.length - 1];
    for (int i = 0; i < sub.length; i++) {
      sub[i] = a[i];
    }

    List<List<Integer>> preList = subset(sub);
    List<List<Integer>> cloneList = new ArrayList<>(preList);
    for (List<Integer> list : cloneList) {
      List<Integer> copy = new ArrayList<>(list);
      copy.add(a[a.length - 1]);
      preList.add(copy);
    }
    return preList;
  }

  public static void main(String[] args) {
    // -12 -5 1 2 4 10 20
    // 0 1 2 3 4 5 6
    int[] array = new int[] { 1, 2, 3, 4 };
    System.out.println(Subset.subset(array));
  }
}
