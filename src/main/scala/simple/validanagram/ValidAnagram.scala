package com.soumen.leetcodesolutions
package simple.validanagram

/**
 * <a href="https://leetcode.com/problems/valid-anagram/">
 *    242. Valid Anagram
 * </a>
 *  */
object ValidAnagram {
  def isAnagram(s: String, t: String): Boolean = s.sorted == t.sorted
}
//Runtime: 933 ms, faster than 42.37% of Scala online submissions for Valid Anagram.
//Memory Usage: 72.8 MB, less than 45.76% of Scala online submissions for Valid Anagram.