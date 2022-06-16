package com.soumen.leetcodesolutions
package medium.longestpalindrome

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/">
 * 5. Longest Palindromic Substring
 * </a>
 * */
object LongestPalindromicSubstring8 extends App {
  def longestPalindrome(s: String): String = {
    val dp = Array.ofDim[Boolean](s.length, s.length)
    var start = 0
    var end = 0
    for (length <- s.indices; i <- 0 until s.length - length) {
      dp(i)(i + length) = s(i) == s(i + length) && (length < 2 || dp(i + 1)(i + length - 1))
      if (dp(i)(i + length) && length > end - start) {
        start = i
        end = i + length
      }
    }
    s.substring(start, end + 1)
  }

  println(longestPalindrome("babad"))
  println(longestPalindrome("cbbd"))
}
//Runtime: 1457 ms, faster than 40.96% of Scala online submissions for Longest Palindromic Substring.
//Memory Usage: 85.5 MB, less than 56.63% of Scala online submissions for Longest Palindromic Substring.