package com.soumen.leetcodesolutions
package medium.longestpalindrome

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/">
 *   5. Longest Palindromic Substring
 * </a>
 * */
object LongestPalindromicSubstring extends App {
  def longestPalindrome(s: String): String = {
    @scala.annotation.tailrec
    def isPalindrome(s: Seq[Char], palindrome: Boolean = true): Boolean = s match {
      case Nil | _ :: Nil => palindrome
      case head :: tail => isPalindrome(tail.init, palindrome && (head == tail.last))
    }

    @scala.annotation.tailrec
    def startingLongestPalindrome(s: Seq[Char]): Seq[Char] = s match {
      case Nil => Nil
      case _ => if (isPalindrome(s)) s else startingLongestPalindrome(s.init)
    }

    @scala.annotation.tailrec
    def longestPalindrome(s: Seq[Char], result: Seq[Char] = Nil): Seq[Char] = s match {
      case Nil => result
      case _ :: tail => longestPalindrome(tail, if (result.length >= s.length) result else {
        val r = startingLongestPalindrome(s)
        if (result.length >= r.length) result else r
      })
    }

    new String(longestPalindrome(s.toList).toArray)
  }

  def time[A, B](f: Function[A, B], arg: A): (B, Long) = {
    val start = System.currentTimeMillis
    f(arg) -> (System.currentTimeMillis - start)
  }
}
