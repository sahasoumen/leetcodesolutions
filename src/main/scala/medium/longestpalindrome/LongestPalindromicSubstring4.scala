package com.soumen.leetcodesolutions
package medium.longestpalindrome

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 5. Longest Palindromic Substring
 * */
object LongestPalindromicSubstring4 extends App {
  def longestPalindrome(s: String): String = {
    @scala.annotation.tailrec
    def isPalindrome(s: String, palindrome: Boolean = true): Boolean = s match {
      case "" | null => palindrome
      case _ => if (s.length == 1) palindrome else isPalindrome(s.substring(1, s.length - 1), palindrome && (s.charAt(0) == s.charAt(s.length - 1)))
    }

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