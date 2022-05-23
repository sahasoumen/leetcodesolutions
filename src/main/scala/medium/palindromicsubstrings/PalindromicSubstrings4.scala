package com.soumen.leetcodesolutions
package medium.palindromicsubstrings

/**
 * <a href = "https://leetcode.com/problems/palindromic-substrings/">
 * 647. Palindromic Substrings
 * </a>
 * */
object PalindromicSubstrings4 extends App {

  def countSubstrings(s: String): Int = {
    @scala.annotation.tailrec
    def isPalindrome(i: Int, j: Int): Boolean = if (i >= j) true else if (s(i) == s(j)) isPalindrome(i + 1, j - 1) else false

    (for (i <- 0 until s.length; j <- i + 1 to s.length) yield if (isPalindrome(i, j - 1)) 1 else 0).sum
  }


  println(countSubstrings("abc"))
}
//Runtime: 1292 ms, faster than 10.00% of Scala online submissions for Palindromic Substrings.
//Memory Usage: 86.5 MB, less than 10.00% of Scala online submissions for Palindromic Substrings.