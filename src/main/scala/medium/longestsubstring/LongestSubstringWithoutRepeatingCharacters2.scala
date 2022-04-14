package com.soumen.leetcodesolutions
package medium.longestsubstring

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 3. Longest Substring Without Repeating Characters
 * */
object LongestSubstringWithoutRepeatingCharacters2 extends App {
  def lengthOfLongestSubstring(s: String): Int = {
    @scala.annotation.tailrec
    def containsDuplicate(s: String): Boolean = if (s.isEmpty) false else if (s.tail.contains(s.head)) true else containsDuplicate(s.tail)

    def safeMax(s: Seq[Int]) = if (s.isEmpty) 0 else s.max

    @scala.annotation.tailrec
    def partSubStrings(s: String, result: Seq[Int] = Nil): Int = if (s.isEmpty) safeMax(result) else partSubStrings(s.init, if (containsDuplicate(s)) result else result :+ s.length)

    @scala.annotation.tailrec
    def allSubstrings(s: String, result: Seq[Int] = Nil): Int = if (s.isEmpty) safeMax(result) else allSubstrings(s.tail, result :+ partSubStrings(s))

    allSubstrings(s)
  }
}

/** Memory Limit Exceeded */