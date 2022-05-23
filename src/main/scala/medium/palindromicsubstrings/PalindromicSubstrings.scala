package com.soumen.leetcodesolutions
package medium.palindromicsubstrings

/**
 * <a href = "https://leetcode.com/problems/palindromic-substrings/">
 * 647. Palindromic Substrings
 * </a>
 * */
object PalindromicSubstrings extends App {
  def countSubstrings(s: String): Int = (for (i <- 0 until s.length; j <- i + 1 to s.length) yield s.substring(i, j)).count(s => s == s.reverse)


  println(countSubstrings("abc"))
}
//Memory Limit Exceeded
//130 / 130 test cases passed, but took too much memory.