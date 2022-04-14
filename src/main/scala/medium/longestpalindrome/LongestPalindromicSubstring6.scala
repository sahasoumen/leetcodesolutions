package com.soumen.leetcodesolutions
package medium.longestpalindrome

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 5. Longest Palindromic Substring
 * */
object LongestPalindromicSubstring6 extends App {
  def longestPalindrome(s: String): String = {
    def isPalindrome(s: String, start: Int, len: Int) = s.substring(start, start + len) match {
      case s => s == s.reverse
    }

    @scala.annotation.tailrec
    def longestPalindrome(s: String, len: Int): String = (0 to s.length - len).find(i => isPalindrome(s, i, len)) match {
      case Some(i) => s.substring(i, i + len)
      case _ => longestPalindrome(s, len - 1)
    }

    longestPalindrome(s, s.length)
  }

  def time[A, B](f: Function[A, B], arg: A): (B, Double) = {
    val start = System.currentTimeMillis
    f(arg) -> (System.currentTimeMillis - start) / 1000.0
  }
}
////Memory Limit Exceeded