package com.soumen.leetcodesolutions
package medium.longestpalindrome

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/">
 *   5. Longest Palindromic Substring
 * </a>
 * */
object LongestPalindromicSubstring5 extends App {
  def longestPalindrome(s: String): String = {
    def isPalindrome(s: String) = s == s.reverse

    @scala.annotation.tailrec
    def longestPalindrome(s: String, sliding: Int): String = sliding match {
      case 0 => s.substring(0, 1)
      case n => s.sliding(n).find(ss => isPalindrome(ss)) match {
        case Some(p) => p
        case _ => longestPalindrome(s, sliding - 1)
      }
    }

    longestPalindrome(s, s.length)
  }

  def time[A, B](f: Function[A, B], arg: A): (B, Double) = {
    val start = System.currentTimeMillis
    f(arg) -> (System.currentTimeMillis - start) / 1000.0
  }
}
//Memory Limit Exceeded