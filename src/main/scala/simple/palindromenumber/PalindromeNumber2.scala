package com.soumen.leetcodesolutions
package simple.palindromenumber

/**
 * https://leetcode.com/problems/palindrome-number/
 */
object PalindromeNumber2 extends App {
  def isPalindrome(x: Int): Boolean = x.toString match {
    case s => s == s.reverse
  }
}

//Runtime: 738 ms, faster than 79.17% of Scala online submissions for Palindrome Number.
//Memory Usage: 67.6 MB, less than 45.45% of Scala online submissions for Palindrome Number.