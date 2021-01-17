package chapter8;

public class MagicIndex {
  // draw grid
  public static int searchMagic(int array[]) {
    return searchMagic(array, 0, array.length - 1);
  }

  public static int searchMagic(int array[], int start, int end) {
    // check end
    if (start > end)
      return -1;

    // find mid
    int mid = (start + end) / 2;

    System.out.println(start + "," + end);
    // check
    if (array[mid] == mid)
      return mid;

    // value is smaller then index? then search right side
    if (array[mid] < mid) {
      return searchMagic(array, mid + 1, end);
    } else {
      return searchMagic(array, start, mid - 1);
    }
  }

  public static void main(String[] args) {
    // -12 -5 1 2 4 10 20
    // 0 1 2 3 4 5 6
    int[] array = new int[] { -12, -5, 1, 2, 4, 10, 20 };
    int i = MagicIndex.searchMagic(array);
    System.out.println(i);
  }
}
