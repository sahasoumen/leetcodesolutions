package com.soumen.leetcodesolutions
package medium.longestpalindrome

object LongestPalindromicSubstring3 extends App {
  def longestPalindrome(s: String): String = {
    @scala.annotation.tailrec
    def isPalindrome(s: String, palindrome: Boolean = true): Boolean = s match {
      case "" | null => palindrome
      case _ => if (s.length == 1) palindrome else isPalindrome(s.substring(1, s.length - 1), palindrome && (s.charAt(0) == s.charAt(s.length - 1)))
    }

    (s.length - 1 to 1 by -1).flatMap(i => s.sliding(i)).foldLeft(if (isPalindrome(s)) s else "")((s1, s2) => if (s1.length >= s2.length) s1 else if (isPalindrome(s2)) s2 else s1)
  }

  def time[A, B](f: Function[A, B], arg: A): (B, Long) = {
    val start = System.currentTimeMillis
    f(arg) -> (System.currentTimeMillis - start)
  }
}
//Memory Limit Exceeded