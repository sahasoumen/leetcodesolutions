package com.soumen.leetcodesolutions
package simple.palindromenumber

/**
 * https://leetcode.com/problems/palindrome-number/
 * 9. Palindrome Number
 */
object PalindromeNumber3 extends App {
  def isPalindrome(x: Int): Boolean = {
    val s = x.toString
    s == s.reverse
  }
}

//Runtime: 914 ms, faster than 35.23% of Scala online submissions for Palindrome Number.
//Memory Usage: 67.4 MB, less than 47.73% of Scala online submissions for Palindrome Number.