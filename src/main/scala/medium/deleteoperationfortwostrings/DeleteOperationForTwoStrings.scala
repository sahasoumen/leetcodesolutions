package com.soumen.leetcodesolutions
package medium.deleteoperationfortwostrings

/**
 * <a href="https://leetcode.com/problems/delete-operation-for-two-strings/">
 * 583. Delete Operation for Two Strings
 * </a>
 * */
object DeleteOperationForTwoStrings extends App {
  def minDistance(word1: String, word2: String): Int = {
    def lcs(s1: String = word1, s2: String = word2, l1: Int = word1.length, l2: Int = word2.length): Int =
      if (l1 == 0 || l2 == 0) 0
      else if (s1(l1 - 1) == s2(l2 - 1)) 1 + lcs(s1, s2, l1 - 1, l2 - 1)
      else lcs(s1, s2, l1 - 1, l2) max lcs(s1, s2, l1, l2 - 1)

    word1.length + word2.length - 2 * lcs()
  }

  println(minDistance("sea", "eat"))
  println(minDistance("leetcode", "etco"))
}
//Memory Limit Exceeded