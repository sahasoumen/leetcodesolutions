package com.soumen.leetcodesolutions
package simple.palindromenumber

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should

class PalindromeNumberTest extends AnyFreeSpec with should.Matchers {
  val palindromeNumber = PalindromeNumber
  "Palindrome Number" - {
    "Should match non-zero, multiple digits" in {
      palindromeNumber.isPalindrome(11) should be(true)
      palindromeNumber.isPalindrome(121) should be(true)
      palindromeNumber.isPalindrome(2332) should be(true)
      palindromeNumber.isPalindrome(123321) should be(true)
      palindromeNumber.isPalindrome(1001001001) should be(true)
      palindromeNumber.isPalindrome(233) should be(false)
      palindromeNumber.isPalindrome(1000021) should be(false)
      palindromeNumber.isPalindrome(101011) should be(false)
    }
    "Should match single digits" in {
      palindromeNumber.isPalindrome(1) should be(true)
      palindromeNumber.isPalindrome(0) should be(true)
    }
    "Should match negative numbers" in {
      palindromeNumber.isPalindrome(-1) should be(false)
      palindromeNumber.isPalindrome(-121) should be(false)
    }
  }
}
