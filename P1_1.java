public class P1_1 {
  boolean isUnique(String str) {
    boolean check[] = new boolean[256];
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i);
      if (check[val])
        return false;
      check[val] = true;
    }
    return true;
  }

  public static void main(String[] args) {
    P1_1 e = new P1_1();
    System.out.println(e.isUnique("112233"));
    System.out.println(e.isUnique("123"));
  }
}