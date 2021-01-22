package chapter8;

// multi(small, big) {
//   if (small == 1)
//     return big;
//   div = small >> 1;
//   value = multi(div, big)
//   if (small % 2 == 1)
//     return value << 1 + big;
//   return value << 1
// }

public class Multiple {
  public static int multi(int a, int b) {
    if (a > b)
      return multiOrder(b, a);
    else
      return multiOrder(a, b);
  }

  // draw grid
  public static int multiOrder(int small, int big) {
    if (small == 1)
      return big;
    if (small == 0)
      return 0;
    int div = small >> 1;
    int value = multi(div, big);
    if (small % 2 == 1)
      return value + value + big;
    return value + value;
  }

  public static void main(String[] args) {
    System.out.println(Multiple.multi(9, 9));
  }
}
