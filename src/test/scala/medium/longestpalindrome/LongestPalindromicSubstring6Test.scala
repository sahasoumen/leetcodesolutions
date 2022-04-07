package com.soumen.leetcodesolutions
package medium.longestpalindrome

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should

class LongestPalindromicSubstring6Test extends AnyFreeSpec with should.Matchers {
  val longestPalindromicSubstring = LongestPalindromicSubstring6
  "Longest Palindrome" - {
    "should find larges palindrome substring" in {
      longestPalindromicSubstring.longestPalindrome("babad") should be("bab")
      longestPalindromicSubstring.longestPalindrome("a") should be("a")
      longestPalindromicSubstring.longestPalindrome("aba") should be("aba")
      longestPalindromicSubstring.longestPalindrome("ac") should be("a")
      longestPalindromicSubstring.longestPalindrome("cbbd") should be("bb")
      longestPalindromicSubstring.longestPalindrome("eabcb") should be("bcb")
      longestPalindromicSubstring.longestPalindrome("bacabab") should be("bacab")
    }
  }
}
