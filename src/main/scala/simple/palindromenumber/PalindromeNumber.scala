package com.soumen.leetcodesolutions
package simple.palindromenumber
/**
 * https://leetcode.com/problems/palindrome-number/
 */
object PalindromeNumber extends App {
  def isPalindrome(x: Int): Boolean = {
    def digits(x: Int) = Math.log10(x).toInt + 1

    @scala.annotation.tailrec
    def isPalindrome(x: Int, digit: Int, nth: Int): Boolean = if (digit <= 1) true else digit - digits(x) match {
      case 0 => if (x % 10 != x / nth) false else isPalindrome(x % nth / 10, digit - 2, nth / 100)
      case _ => if (x % 10 != 0) false else isPalindrome(x / 10, digit - 2, nth / 100)
    }

    if (x < 0) false else if (x < 10) true else digits(x) match {
      case d => isPalindrome(x, d, Math.pow(10, d - 1).toInt)
    }
  }
}
//Runtime: 488 ms, faster than 99.62% of Scala online submissions for Palindrome Number.
//Memory Usage: 52.4 MB, less than 82.95% of Scala online submissions for Palindrome Number.
