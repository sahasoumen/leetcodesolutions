package com.soumen.leetcodesolutions
package simple.longestcommonprefix

/**
 * <a href="https://leetcode.com/problems/longest-common-prefix/">
 * 14. Longest Common Prefix
 * </a>
 * */
object LongestCommonPrefix2 extends App {
  def longestCommonPrefix(strs: Array[String]): String = {
    val maxPossible = strs.map(_.length).min

    def prefix(i: Int = 0): String =
      if (i == maxPossible) ""
      else strs.map(_ (i)).distinct match {
        case Array(c) => c.toString + prefix(i + 1)
        case _ => ""
      }

    prefix()
  }

  println(longestCommonPrefix(Array("flower", "flow", "flight")))
  println(longestCommonPrefix(Array("dog", "racecar", "car")))
}
//Runtime: 880 ms, faster than 36.97% of Scala online submissions for Longest Common Prefix.
//Memory Usage: 67.8 MB, less than 30.91% of Scala online submissions for Longest Common Prefix.