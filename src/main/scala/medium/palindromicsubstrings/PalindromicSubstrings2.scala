package com.soumen.leetcodesolutions
package medium.palindromicsubstrings

/**
 * <a href = "https://leetcode.com/problems/palindromic-substrings/">
 * 647. Palindromic Substrings
 * </a>
 * */
object PalindromicSubstrings2 extends App {
  def countSubstrings(s: String): Int = (for (i <- 0 until s.length; j <- i + 1 to s.length) yield if (s.substring(i, j) == s.substring(i, j).reverse) 1 else 0).sum


  println(countSubstrings("abc"))
}
//Runtime: 2427 ms, faster than 10.00% of Scala online submissions for Palindromic Substrings.
//Memory Usage: 727.3 MB, less than 10.00% of Scala online submissions for Palindromic Substrings.