package com.soumen.leetcodesolutions
package contest.weeklycontest298.longestbinarysubsequencelessthanorequaltok

/**
 * <a href="https://leetcode.com/contest/weekly-contest-298/problems/longest-binary-subsequence-less-than-or-equal-to-k/">
 * 6099. Longest Binary Subsequence Less Than or Equal to K
 * </a>
 * */
object LongestBinarySubsequenceLessThanOrEqualToK extends App {
  def longestSubsequence(s: String, k: Int): Int =
    s.foldRight((0, 0, 1)) { case (c, (count, sum, pow)) =>
      if (sum + pow <= k)
        if (c == '1') (count + 1, sum + pow, pow << 1)
        else (count + 1, sum, pow << 1)
      else if (c == '0') (count + 1, sum, pow)
      else (count, sum, pow)
    }._1

  println(longestSubsequence("1001010", 5))
  println(longestSubsequence("00101001", 1))
}
//Runtime: 980 ms, faster than 100.00% of Scala online submissions for Longest Binary Subsequence Less Than or Equal to K.
//Memory Usage: 70.5 MB, less than 100.00% of Scala online submissions for Longest Binary Subsequence Less Than or Equal to K.