package com.soumen.leetcodesolutions
package medium.longestsubstring

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should

class LongestSubstringWithoutRepeatingCharactersTest extends AnyFreeSpec with should.Matchers {
  val longestSubstring = LongestSubstringWithoutRepeatingCharacters
  "Longest substring" - {
    "should find the longest substring" in {
      longestSubstring.lengthOfLongestSubstring("abcabcbb") should be(3)
      longestSubstring.lengthOfLongestSubstring("bbbbb") should be(1)
      longestSubstring.lengthOfLongestSubstring("pwwkew") should be(3)
      longestSubstring.lengthOfLongestSubstring("") should be(0)
      longestSubstring.lengthOfLongestSubstring("hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789") should be(55)
    }
  }
}
