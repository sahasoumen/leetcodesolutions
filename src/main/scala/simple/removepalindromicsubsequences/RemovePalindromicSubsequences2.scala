package com.soumen.leetcodesolutions
package simple.removepalindromicsubsequences

/**
 * <a href = "https://leetcode.com/problems/remove-palindromic-subsequences/">
 * 1332. Remove Palindromic Subsequences
 * </a>
 * */
object RemovePalindromicSubsequences2 extends App {
  @scala.annotation.tailrec
  def isPalindrome(s: String, i: Int = 0, l: Int = 0): Boolean = if (i >= l) true else if (s(i) != s(l)) false else isPalindrome(s, i + 1, l - 1)

  def removePalindromeSub(s: String): Int = if (s.isEmpty) 0 else if (isPalindrome(s, 0, s.length - 1)) 1 else 2
}

//Runtime: 737 ms, faster than 100.00% of Scala online submissions for Remove Palindromic Subsequences.
//Memory Usage: 65.5 MB, less than 100.00% of Scala online submissions for Remove Palindromic Subsequences.