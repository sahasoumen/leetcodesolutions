package com.soumen.leetcodesolutions
package medium.longestsubstring

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">
 * 3. Longest Substring Without Repeating Characters
 * </a>
 * */
object LongestSubstringWithoutRepeatingCharacters5 extends App {
  def lengthOfLongestSubstring(s: String): Int = {
    val lastIndexOf = Array.ofDim[Int](128)

    s.indices.foldLeft((0, 0)) {
      case ((last, longest), next) =>
        val l = last max lastIndexOf(s(next))
        lastIndexOf(s(next)) = next + 1
        l -> (longest max (next - l + 1))
    }._2
  }

  println(lengthOfLongestSubstring("abcabcbb"))
  println(lengthOfLongestSubstring("bbbbb"))
  println(lengthOfLongestSubstring("pwwkew"))
}

//Runtime: 784 ms, faster than 76.99% of Scala online submissions for Longest Substring Without Repeating Characters.
//Memory Usage: 71.5 MB, less than 61.65% of Scala online submissions for Longest Substring Without Repeating Characters.