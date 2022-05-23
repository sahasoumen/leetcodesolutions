package com.soumen.leetcodesolutions
package medium.palindromicsubstrings

/**
 * <a href = "https://leetcode.com/problems/palindromic-substrings/">
 * 647. Palindromic Substrings
 * </a>
 * */
object PalindromicSubstrings3 extends App {

  def countSubstrings(s: String): Int = {
    @scala.annotation.tailrec
    def isPalindrome(i: Int, j: Int, palindrome: Boolean = true): Boolean = if (i >= j || !palindrome) palindrome else isPalindrome(i + 1, j - 1, palindrome && s(i) == s(j))

    (for (i <- 0 until s.length; j <- i + 1 to s.length) yield if (isPalindrome(i, j - 1)) 1 else 0).sum
  }


  println(countSubstrings("abc"))
}
//Runtime: 973 ms, faster than 10.00% of Scala online submissions for Palindromic Substrings.
//Memory Usage: 58.3 MB, less than 70.00% of Scala online submissions for Palindromic Substrings.