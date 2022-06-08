package com.soumen.leetcodesolutions
package simple.removepalindromicsubsequences

/**
 * <a href = "https://leetcode.com/problems/remove-palindromic-subsequences/">
 * 1332. Remove Palindromic Subsequences
 * </a>
 * */
object RemovePalindromicSubsequences extends App {
  def removePalindromeSub(s: String): Int = if (s.isEmpty) 0 else if (s == s.reverse) 1 else 2
}

//Runtime: 628 ms, faster than 100.00% of Scala online submissions for Remove Palindromic Subsequences.
//Memory Usage: 65.6 MB, less than 100.00% of Scala online submissions for Remove Palindromic Subsequences.