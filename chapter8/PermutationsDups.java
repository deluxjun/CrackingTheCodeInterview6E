package chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
  I'll use a recursive function.
  for examaple, let's see 'abba'
  It is 2a and 2b, I'll represent 2a2b.
  2a2b is made from 2a1b and 1a2b
  As a result,
  2a2b = a + (1a2b), b + (2a1b)
  1a2b = b + (1a1b), a + (2b)
  2a1b = a + (1a1b), b + (2a)
  1a1b = b + (1a), a + (1b)

  ------
  aabb
  aabb -> bbaa baba baab abba abab aabb
  2a2b : b+(2a1b),a+(1a2b) : baab, baba, bbaa, abab, abba, aabb
  1a2b : b+(1a1b),a+(2b) : bab, bba, abb
  aab -> 2a1b : a+(1a1b),b+(2a) : aab, aba, baa
  aa -> 2a : a + (1a)
  ab -> 1a1b = (1a),(1b)
  ------

  Map makeHash(str) {
    map = HashMap();
    map.put(a, count);
  }

  void allPerm(str) {
    hash = makeHash(str);
    perm(hash, "", str.length(), result)
  }

  void perm(hash, prefix, remain, result) {
    if (remain < 1){
      result.add(prefix);
      return;
    }

    for(char c: hash) {
      int count = hash.get(c);
      if (count > 1) {
        hash.put(c, count-1)
        result = perm(hash, prefix + c, remain-1, result)
        hash.put(c, count)
      }
    }
  }
*/

public class PermutationsDups {

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
    System.out.println(PermutationsDups.perm("abcd", 4));
  }
}
