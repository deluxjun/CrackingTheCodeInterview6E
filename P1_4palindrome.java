public class P1_4palindrome {
  // int toInt(char a) {

  // char[] c = s.toCharArray();
  // java.util.Arrays.sort(c);
  // return new String(c);
  // }

  boolean exam(String s) {
    int countOdd = 0;
    char[] chars = s.toCharArray();
    int num[] = new int[512];
    for (char c : chars) {
      if (c == ' ')
        continue;
      num[c]++;
      if (num[c] % 2 == 0)
        countOdd--;
      else
        countOdd++;
    }
    return countOdd <= 1;
  }

  public static void main(String[] args) {
    P1_4palindrome e = new P1_4palindrome();
    System.out.println(e.exam("abab cco")); // true
    System.out.println(e.exam("abccdd")); // false
  }
}