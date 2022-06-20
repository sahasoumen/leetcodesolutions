package com.soumen.leetcodesolutions
package simple.longestcommonprefix

/**
 * <a href="https://leetcode.com/problems/longest-common-prefix/">
 * 14. Longest Common Prefix
 * </a>
 * */
object LongestCommonPrefix4 extends App {
  def longestCommonPrefix(strs: Array[String]): String = if (strs.length == 1) strs.head else strs.map(_.length).min match {
    case 0 => ""
    case m => (0 until m).takeWhile(i => strs.forall(_ (i) == strs.head(i))).map(strs.head).mkString
  }

  println(longestCommonPrefix(Array("flower", "flow", "flight")))
  println(longestCommonPrefix(Array("dog", "racecar", "car")))
  println(longestCommonPrefix(Array("")))
  println(longestCommonPrefix(Array("ab", "a")))
}
//Runtime: 714 ms, faster than 76.36% of Scala online submissions for Longest Common Prefix.
//Memory Usage: 67 MB, less than 56.36% of Scala online submissions for Longest Common Prefix.