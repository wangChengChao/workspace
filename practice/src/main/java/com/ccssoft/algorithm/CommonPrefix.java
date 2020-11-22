package com.ccssoft.algorithm;

/**
 * 最长公共前缀
 *
 * @author: kermit
 * @date: 2020/11/22/10:45
 */
public class CommonPrefix {

  public String longestCommonPrefix(String[] strs) {

    String ret = "";

    if (strs == null || strs.length == 0) return ret;

    ret = strs[0];
    for (int i = 1; i < strs.length; i++) {

      if (ret.isEmpty()) return ret;

      ret = calculate(ret, strs[i]);
    }
    return ret;
  }

  private String calculate(String s1, String s2) {

    String res = "";

    if (s1 == null && s2 == null) return res;

    if (s1 == null || s2 == null) return res;

    int i = 0;

    // leet leed
    while (i < s1.length() && i < s2.length()) {

      char c1 = s1.charAt(i);
      char c2 = s2.charAt(i);
      if (c1 != c2) {
        break;
      }
      i++;
    }

    res = s1.substring(0, i);

    return res;
  }
}
