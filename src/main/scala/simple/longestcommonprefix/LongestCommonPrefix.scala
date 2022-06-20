package com.soumen.leetcodesolutions
package simple.longestcommonprefix

import scala.annotation.tailrec

/**
 * <a href="https://leetcode.com/problems/longest-common-prefix/">
 * 14. Longest Common Prefix
 * </a>
 * */
object LongestCommonPrefix extends App {
  def longestCommonPrefix(strs: Array[String]): String = {
    val maxPossible = strs.map(_.length).min

    @tailrec
    def len(i: Int = 0): Int = if (i == maxPossible || strs.map(_ (i)).distinct.length > 1) i else len(i + 1)

    strs.head.substring(0, len())
  }

  println(longestCommonPrefix(Array("flower", "flow", "flight")))
  println(longestCommonPrefix(Array("dog", "racecar", "car")))
}
//Runtime: 781 ms, faster than 60.00% of Scala online submissions for Longest Common Prefix.
//Memory Usage: 67.4 MB, less than 41.21% of Scala online submissions for Longest Common Prefix.