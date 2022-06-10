package com.soumen.leetcodesolutions
package medium.longestsubstring

import scala.annotation.tailrec

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">
 * 3. Longest Substring Without Repeating Characters
 * </a>
 * */
object LongestSubstringWithoutRepeatingCharacters4 extends App {
  def lengthOfLongestSubstring(s: String): Int = {
    def isUnique(s: String) = !s.groupBy(identity).exists(_._2.length > 1)

    @tailrec
    def helper(len: Int = s.length): Int = if (len <= 1) len else (0 to s.length - len).find(i => isUnique(s.substring(i, i + len))) match {
      case Some(_) => len
      case _ => helper(len - 1)
    }

    helper()
  }

  println(lengthOfLongestSubstring("abcabcbb"))
  println(lengthOfLongestSubstring("bbbbb"))
  println(lengthOfLongestSubstring("pwwkew"))
}

//Memory Limit Exceeded