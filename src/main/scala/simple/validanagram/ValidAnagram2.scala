package com.soumen.leetcodesolutions
package simple.validanagram

/**
 * <a href="https://leetcode.com/problems/valid-anagram/">
 * 242. Valid Anagram
 * </a>
 * */
object ValidAnagram2 extends App {
  def isAnagram(s: String, t: String): Boolean =
    s.foldLeft(Map.empty[Char, Int])((m, c) => m + (c -> (m.getOrElse(c, 0) + 1))) == t.foldLeft(Map.empty[Char, Int])((m, c) => m + (c -> (m.getOrElse(c, 0) + 1)))

  println(isAnagram("abc", "bca"))
}
//Runtime: 1292 ms, faster than 5.93% of Scala online submissions for Valid Anagram.
//Memory Usage: 88.1 MB, less than 11.86% of Scala online submissions for Valid Anagram.