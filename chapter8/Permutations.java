package chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
  I'll use a recursive function.
  for examaple, let's see 'abcd'
  a is just a
  ab is ab, ba
  abc is made from the previous string's permutations that is called P(ab). 
  Add 'c' to all items of P(ab) in order.
  we'll call it P(abc). let's see all simplified list.

  abcd
  a -> a
  ab -> ab ba
  abc -> cab cba acb bca abc bac
  abcd -> d + P(abc)

  arraylist perm(string str, int len) {
    if (str.length <= 1)
      return new ArrayList(str);
    
    String smaller = str.substring(0, len-1);
    preList = perm(smaller, len-1);
    ArrayList all = new ArrayList();

    // add all
    int pos = 0;
    while(pos++ < len) {
      forEach(preStr in preList) {
        String prefix = preStr.substring(0, pos);
        String sufix = preStr.substring(pos, preStr.length);
        all.put(prefix + sufix + );
      }
    }
  }
*/

public class Permutations {

  public static List<String> perm(String str, int len) {
    if (len == 0)
      return Collections.emptyList();
    if (len == 1)
      return Arrays.asList(str);

    String smaller = str.substring(0, len - 1);
    List<String> preList = perm(smaller, len - 1);
    ArrayList<String> all = new ArrayList<String>();

    // add all
    int pos = 0;
    String last = str.substring(len - 1);
    while (pos < len) {
      for (String preStr : preList) {
        String prefix = preStr.substring(0, pos);
        String sufix = preStr.substring(pos, preStr.length());
        all.add(prefix + last + sufix);
      }
      pos++;
    }

    return all;
  }

  public static void main(String[] args) {
    System.out.println(Permutations.perm("abcd", 4));
  }
}
