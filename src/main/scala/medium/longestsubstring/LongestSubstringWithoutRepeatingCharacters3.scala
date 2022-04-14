package com.soumen.leetcodesolutions
package medium.longestsubstring

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 3. Longest Substring Without Repeating Characters
 * */
object LongestSubstringWithoutRepeatingCharacters3 extends App {
  def lengthOfLongestSubstring(s: String): Int = {
    @scala.annotation.tailrec
    def startingSubstringLen(s: Seq[Char], chars: Map[Char, _] = Map.empty): Int = s match {
      case Nil => chars.size
      case head :: tail => chars get head match {
        case Some(_) => chars.size
        case _ => startingSubstringLen(tail, chars + (head -> Nil))
      }
    }

    @scala.annotation.tailrec
    def maxSubstring(s: Seq[Char], maxLen: Int = 0): Int = if (s.isEmpty || s.length <= maxLen) maxLen else maxSubstring(s.tail, Math.max(maxLen, startingSubstringLen(s)))

    maxSubstring(s.toList)
  }
}

//Runtime: 2159 ms, faster than 9.65% of Scala online submissions for Longest Substring Without Repeating Characters.
//Memory Usage: 317.7 MB, less than 8.88% of Scala online submissions for Longest Substring Without Repeating Characters.