public class P1_2 {
  String sort(String s) {
    char[] c = s.toCharArray();
    java.util.Arrays.sort(c);
    return new String(c);
  }

  boolean exam(String s, String t) {
    return sort(s).equals(sort(t));
  }

  public static void main(String[] args) {
    P1_2 e = new P1_2();
    System.out.println(e.exam("112233", "321"));
    System.out.println(e.exam("123", "321"));
  }
}