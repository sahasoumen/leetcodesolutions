package com.soumen.leetcodesolutions
package medium.longestpalindrome

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/">
 * 5. Longest Palindromic Substring
 * </a>
 * */
object LongestPalindromicSubstring9 extends App {
  def longestPalindrome(s: String): String = {
    val dp = Array.ofDim[Boolean](s.length, s.length)
    val (start, end) = s.indices.foldLeft((0, 0)) { case ((start, end), len) =>
      (0 until s.length - len).foldLeft((start, end)) { case ((st, en), i) =>
        dp(i)(i + len) = s(i) == s(i + len) && (len < 2 || dp(i + 1)(i + len - 1))
        if (dp(i)(i + len) && len > en - st) i -> (i + len) else st -> en
      }
    }

    s.substring(start, end + 1)
  }

  println(longestPalindrome("babad"))
  println(longestPalindrome("cbbd"))
}
//Runtime: 2696 ms, faster than 24.10% of Scala online submissions for Longest Palindromic Substring.
//Memory Usage: 711.4 MB, less than 24.10% of Scala online submissions for Longest Palindromic Substring.